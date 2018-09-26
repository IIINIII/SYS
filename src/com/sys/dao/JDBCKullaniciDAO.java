package com.sys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sys.Login;
import com.sys.Statics;
import com.sys.MsgBox.MessageBox;
import com.sys.vo.Kullanici;

public class JDBCKullaniciDAO implements KullaniciDAO {
	
	Connection connection = null;
	 
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/sys_db?useUnicode=true&characterEncoding=UTF-8&user=root&password=");
        } catch (ClassNotFoundException e) {
			MessageBox.createMessageBox(Statics.activeFrame, "JDBC Driver sınıfı bulunamadı!", true, MessageBox.ERROR_MESSAGE, Statics.activeFrame.getLocation().x+1, Statics.activeFrame.getLocation().y+Login.height-67);
        } catch (SQLException e) {
			MessageBox.createMessageBox(Statics.activeFrame, "Veri tabanına bağlanamadı!", true, MessageBox.ERROR_MESSAGE, Statics.activeFrame.getLocation().x+1, Statics.activeFrame.getLocation().y+Login.height-67);
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
	public int checkExistance(Kullanici kullanici) {
		if(connection==null) return -1;
		String sql = "SELECT id FROM users WHERE "
				+ "ad_soyad=? AND "
				+ "sifre=? AND "
				+ "aktif_mi=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int cid=1;
			preparedStatement.setString(cid++, kullanici.getAd_soyad());
			preparedStatement.setString(cid++, kullanici.getSifre());
			preparedStatement.setBoolean(cid++, true);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			preparedStatement.close();
		} catch (SQLException e) {
			// Error
		}
		return -1;
	}

	@Override
	public boolean insert(Kullanici kullanici) {
		if(connection==null) return false;
		String sql = "INSERT INTO users SET "
				+ "ad_soyad=?, "
				+ "sifre=?, "
				+ "aktif_mi=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int cid=1;
			preparedStatement.setString(cid++, kullanici.getAd_soyad());
			preparedStatement.setString(cid++, kullanici.getSifre());
			preparedStatement.setBoolean(cid++, kullanici.isActive());
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
	public boolean update(Kullanici kullanici) {
		if(connection==null) return false;
		String sql = "UPDATE users SET "
				+ "ad_soyad=?, "
				+ "sifre=?, "
				+ "aktif_mi=? "
				+ "WHERE id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			int cid=1;
			preparedStatement.setString(cid++, kullanici.getAd_soyad());
			preparedStatement.setString(cid++, kullanici.getSifre());
			preparedStatement.setBoolean(cid++, kullanici.isActive());
			preparedStatement.setInt(cid++, kullanici.getId());
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
	public ArrayList<Kullanici> select() {
		if(connection==null) return null;
		String sql = "SELECT id,ad_soyad,aktif_mi FROM users WHERE aktif_mi=1 ORDER BY ad_soyad";
		ArrayList<Kullanici> list = new ArrayList<Kullanici>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				Kullanici kullanici = new Kullanici();
				kullanici.setId(rs.getInt(1));
				kullanici.setAd_soyad(rs.getString(2));
				kullanici.setActive(rs.getBoolean(3));
				list.add(kullanici);
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
