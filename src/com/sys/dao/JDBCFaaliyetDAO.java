package com.sys.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import com.sys.vo.Faaliyet;

public class JDBCFaaliyetDAO implements FaaliyetDAO {
	
	Connection connection = null;
	 
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/sys_db?useUnicode=true&characterEncoding=UTF-8&user=root&password=");
        } catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "JDBC Driver sınıfı bulunamadı!","Hata",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Veri tabanına bağlanamadı!","Bağlantı hatası",JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    public void closeConnection() {
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public boolean insert(Faaliyet faaliyet) {
		if(connection==null) return false;
		String sql = "INSERT INTO faaliyetler SET "
				+ "konu=?, "
				+ "talep_tarihi=?, "
				+ "maliyet_bedeli=?, "
				+ "odenek=?, "
				+ "ihale_tarihi=?, "
				+ "sozlesme_tarihi=?, "
				+ "teslim_suresi=?, "
				+ "sozlesme_alim_bedeli=?, "
				+ "ilave_siparis_bedeli=?, "
				+ "odenen=?, "
				+ "firma=?, "
				+ "aciklama=?, "
				+ "sorumlu=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int cid=1;
			preparedStatement.setString(cid++, faaliyet.getKonu());
			preparedStatement.setString(cid++, faaliyet.getTalepTarihi());
			preparedStatement.setDouble(cid++, faaliyet.getMaliyetBedeli());
			preparedStatement.setString(cid++, faaliyet.getOdenek());
			preparedStatement.setString(cid++, faaliyet.getIhaleTarihi());
			preparedStatement.setString(cid++, faaliyet.getSozlesmeTarihi());
			preparedStatement.setString(cid++, faaliyet.getTeslimSuresi());
			preparedStatement.setDouble(cid++, faaliyet.getSozlesmeAlimBedeli());
			preparedStatement.setDouble(cid++, faaliyet.getIlaveSiparisBedeli());
			preparedStatement.setDouble(cid++, faaliyet.getOdenen());
			preparedStatement.setString(cid++, faaliyet.getFirma());
			preparedStatement.setString(cid++, faaliyet.getAciklama());
			preparedStatement.setString(cid++, faaliyet.getSorumlu());
			int rs = preparedStatement.executeUpdate();
			preparedStatement.close();
			if(rs>0)
				return true;
		} catch (SQLException e) {
			// Error
		}
		return false;
	}

	@Override
	public boolean update(Faaliyet faaliyet) {
		if(connection==null) return false;
		String sql = "UPDATE faaliyetler SET "
				+ "konu=?, "
				+ "talep_tarihi=?, "
				+ "maliyet_bedeli=?, "
				+ "odenek=?, "
				+ "ihale_tarihi=?, "
				+ "sozlesme_tarihi=?, "
				+ "teslim_suresi=?, "
				+ "sozlesme_alim_bedeli=?, "
				+ "ilave_siparis_bedeli=?, "
				+ "odenen=?, "
				+ "firma=?, "
				+ "aciklama=?, "
				+ "sorumlu=? "
				+ "WHERE id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int cid=1;
			preparedStatement.setString(cid++, faaliyet.getKonu());
			preparedStatement.setString(cid++, faaliyet.getTalepTarihi());
			preparedStatement.setDouble(cid++, faaliyet.getMaliyetBedeli());
			preparedStatement.setString(cid++, faaliyet.getOdenek());
			preparedStatement.setString(cid++, faaliyet.getIhaleTarihi());
			preparedStatement.setString(cid++, faaliyet.getSozlesmeTarihi());
			preparedStatement.setString(cid++, faaliyet.getTeslimSuresi());
			preparedStatement.setDouble(cid++, faaliyet.getSozlesmeAlimBedeli());
			preparedStatement.setDouble(cid++, faaliyet.getIlaveSiparisBedeli());
			preparedStatement.setDouble(cid++, faaliyet.getOdenen());
			preparedStatement.setString(cid++, faaliyet.getFirma());
			preparedStatement.setString(cid++, faaliyet.getAciklama());
			preparedStatement.setString(cid++, faaliyet.getSorumlu());
			preparedStatement.setInt(cid++, faaliyet.getId());
			int rs = preparedStatement.executeUpdate();
			preparedStatement.close();
			if(rs>0)
				return true;
		} catch (SQLException e) {
			// Error
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		if(connection==null) return false;
		String sql = "DELETE FROM faaliyetler WHERE id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			int rs = preparedStatement.executeUpdate();
			preparedStatement.close();
			if(rs>0)
				return true;
		} catch (SQLException e) {
			// Error
		}
		return false;
	}

	@Override
	public ArrayList<Faaliyet> select() {
		if(connection==null) return null;
		String sql = "SELECT * FROM faaliyetler";
		ArrayList<Faaliyet> list = new ArrayList<Faaliyet>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Faaliyet faaliyet = new Faaliyet();
				faaliyet.setId(rs.getInt(1));
				faaliyet.setKonu(rs.getString(2));
				faaliyet.setTalepTarihi(rs.getString(3));
				faaliyet.setMaliyetBedeli(rs.getDouble(4));
				faaliyet.setOdenek(rs.getString(5));
				faaliyet.setIhaleTarihi(rs.getString(6));
				faaliyet.setSozlesmeTarihi(rs.getString(7));
				faaliyet.setTeslimSuresi(rs.getString(8));
				faaliyet.setSozlesmeAlimBedeli(rs.getDouble(9));
				faaliyet.setIlaveSiparisBedeli(rs.getDouble(10));
				faaliyet.setOdenen(rs.getDouble(11));
				faaliyet.setFirma(rs.getString(12));
				faaliyet.setAciklama(rs.getString(13));
				faaliyet.setSorumlu(rs.getString(14));
				list.add(faaliyet);
			}
			statement.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// Error
		}
		return null;
	}

	@Override
	public ArrayList<Faaliyet> selectFrom(String s) {
		if(connection==null) return null;
		String sql = "SELECT * FROM faaliyetler WHERE sorumlu=?";
		ArrayList<Faaliyet> list = new ArrayList<Faaliyet>();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, s);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				Faaliyet faaliyet = new Faaliyet();
				faaliyet.setId(rs.getInt(1));
				faaliyet.setKonu(rs.getString(2));
				faaliyet.setTalepTarihi(rs.getString(3));
				faaliyet.setMaliyetBedeli(rs.getDouble(4));
				faaliyet.setOdenek(rs.getString(5));
				faaliyet.setIhaleTarihi(rs.getString(6));
				faaliyet.setSozlesmeTarihi(rs.getString(7));
				faaliyet.setTeslimSuresi(rs.getString(8));
				faaliyet.setSozlesmeAlimBedeli(rs.getDouble(9));
				faaliyet.setIlaveSiparisBedeli(rs.getDouble(10));
				faaliyet.setOdenen(rs.getDouble(11));
				faaliyet.setFirma(rs.getString(12));
				faaliyet.setAciklama(rs.getString(13));
				faaliyet.setSorumlu(rs.getString(14));
				list.add(faaliyet);
			}
			statement.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// Error
		}
		return null;
	}

	@Override
	public ArrayList<Faaliyet> selectWhere(String sql) {
		if(connection==null) return null;
		ArrayList<Faaliyet> list = new ArrayList<Faaliyet>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Faaliyet faaliyet = new Faaliyet();
				faaliyet.setId(rs.getInt(1));
				faaliyet.setKonu(rs.getString(2));
				faaliyet.setTalepTarihi(rs.getString(3));
				faaliyet.setMaliyetBedeli(rs.getDouble(4));
				faaliyet.setOdenek(rs.getString(5));
				faaliyet.setIhaleTarihi(rs.getString(6));
				faaliyet.setSozlesmeTarihi(rs.getString(7));
				faaliyet.setTeslimSuresi(rs.getString(8));
				faaliyet.setSozlesmeAlimBedeli(rs.getDouble(9));
				faaliyet.setIlaveSiparisBedeli(rs.getDouble(10));
				faaliyet.setOdenen(rs.getDouble(11));
				faaliyet.setFirma(rs.getString(12));
				faaliyet.setAciklama(rs.getString(13));
				faaliyet.setSorumlu(rs.getString(14));
				list.add(faaliyet);
			}
			statement.close();
			rs.close();
			return list;
		} catch (SQLException e) {
			// Error
		}
		return null;
	}

}
