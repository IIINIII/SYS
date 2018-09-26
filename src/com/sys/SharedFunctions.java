package com.sys;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.sys.dao.JDBCFaaliyetDAO;
import com.sys.vo.Faaliyet;

public abstract class SharedFunctions {
	
	public static JTableHeader comp;
	public static JTableHeader comp1;
	public static JTableHeader comp2;
	public static JTable table;
	public static JTable table1;
	public static JTable table2;
	
	public static JPanel prepareTable(String query, String[] headers) {
		JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
		dao.getConnection();
		Statics.faaliyetler = dao.select();
		Object[][] data = new Object[Statics.faaliyetler.size()][14];
		int i=0,j;
		for (Object o : Statics.faaliyetler.toArray()) {
			Object[] oa = ((Faaliyet)o).toObjectArray();
			j=0;
			for(Object o1 : oa) {
				data[i][j++]=o1;
			}
			i++;
		}
		dao.closeConnection();
		table = new JTable(data, headers);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = -7258942368504262480L;

			@Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        if(!isSelected)
		        	c.setBackground(row % 2 == 1 ? Color.decode("#ededed") : Color.WHITE);
		        else
		        	c.setBackground(Color.decode("#4CBCEE"));
		        return c;
		    }
		});
		table.setRowHeight(32);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table.getSelectedRowCount()==1) {
					Statics.selectedFaaliyet = Statics.faaliyetler.get(table.getSelectedRow());
					Statics.allDetails.setVisible(true);
				}
				else {
					Statics.selectedFaaliyet = null;
					Statics.allDetails.setVisible(false);
					Statics.allDetails.setVisible(false);
				}
			}
		});
		SharedFunctions.table.setRowHeight(32);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table.getTableHeader();
		tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		tablePanel.add(table,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createTable(JComponent b,int x,int y,int w, int h,String query,String[] headers) {
		JPanel pane = prepareTable(query,headers);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y, w, h);
		panel.setPreferredSize(pane.getPreferredSize());
		b.add(panel);
	}
	
	public static JPanel prepareMyTable(String query, String[] headers) {
		JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
		dao.getConnection();
		Statics.faaliyetler1 = dao.selectFrom(Statics.user.getAd_soyad());
		Object[][] data = new Object[Statics.faaliyetler1.size()][14];
		int i=0,j;
		for (Object o : Statics.faaliyetler1.toArray()) {
			Object[] oa = ((Faaliyet)o).toObjectArray();
			j=0;
			for(Object o1 : oa) {
				data[i][j++]=o1;
			}
			i++;
		}
		dao.closeConnection();
		table1 = new JTable(data, headers);
		table1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = -7258942368504262480L;

			@Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        if(!isSelected)
		        	c.setBackground(row % 2 == 1 ? Color.decode("#ededed") : Color.WHITE);
		        else
		        	c.setBackground(Color.decode("#4CBCEE"));
		        return c;
		    }
		});
		table1.setRowHeight(32);
		table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table1.getSelectedRowCount()==1) {
					Statics.selectedFaaliyet1 = Statics.faaliyetler1.get(table1.getSelectedRow());
					Statics.myDetails.setVisible(true);
				}
				else {
					Statics.selectedFaaliyet1 = null;
					Statics.myDetails.setVisible(false);
				}
			}
		});
		SharedFunctions.table1.setRowHeight(32);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table1.getTableHeader();
		tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		tablePanel.add(table1,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createMyTable(JComponent b,int x,int y,int w, int h,String query,String[] headers) {
		JPanel pane = prepareMyTable(query,headers);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y, w, h);
		panel.setPreferredSize(pane.getPreferredSize());
		b.add(panel);
	}
	
	public static JPanel prepareSearchTable(String sql, String[] headers) {
		JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
		dao.getConnection();
		Statics.faaliyetler2 = dao.selectWhere(sql);
		Object[][] data = new Object[Statics.faaliyetler2.size()][14];
		int i=0,j;
		for (Object o : Statics.faaliyetler2.toArray()) {
			Object[] oa = ((Faaliyet)o).toObjectArray();
			j=0;
			for(Object o1 : oa) {
				data[i][j++]=o1;
			}
			i++;
		}
		dao.closeConnection();
		table2 = new JTable(data, headers);
		table2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = -7258942368504262480L;

			@Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        if(!isSelected)
		        	c.setBackground(row % 2 == 1 ? Color.decode("#ededed") : Color.WHITE);
		        else
		        	c.setBackground(Color.decode("#4CBCEE"));
		        return c;
		    }
		});
		table2.setRowHeight(32);
		table2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(table2.getSelectedRowCount()==1) {
					Statics.selectedFaaliyet1 = Statics.faaliyetler2.get(table2.getSelectedRow());
					DetailPanel.arama = true;
					if(table2.getModel().getValueAt(table2.getSelectedRow(), 13).equals(Statics.user.getAd_soyad()))
						DetailPanel.degisme = true;
					else
						DetailPanel.degisme = false;
					Statics.rsDetails.setVisible(true);
				}
				else {
					DetailPanel.arama = false;
					DetailPanel.degisme = false;
					Statics.selectedFaaliyet1 = null;
					Statics.rsDetails.setVisible(false);
				}
			}
		});
		SharedFunctions.table2.setRowHeight(32);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		JTableHeader hdr = table2.getTableHeader();
		tablePanel.add(hdr,BorderLayout.NORTH);
		hdr.setReorderingAllowed(true);
		
		tablePanel.add(table2,BorderLayout.CENTER);
		//toExcel(table, new File("d://newExcel.xls"));
		return tablePanel;
	}
	
	public static void createSearchTable(JComponent b,int x,int y,int w, int h,String sql,String[] headers) {
		JPanel pane = prepareSearchTable(sql,headers);
		JScrollPane panel = new JScrollPane(pane);
		panel.setBounds(x, y, w, h);
		panel.setPreferredSize(pane.getPreferredSize());
		b.add(panel);
	}
	
}
