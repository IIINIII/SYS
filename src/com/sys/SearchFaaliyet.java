package com.sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.sys.dao.JDBCFaaliyetDAO;
import com.sys.vo.Kullanici;

public class SearchFaaliyet extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7193552891737690898L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JList<Object> list;

	public SearchFaaliyet() {
		setBorder(new MatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/arama.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		JLabel okLabel = new JLabel("");
		okLabel.setIcon(new ImageIcon(SearchFaaliyet.class.getResource("/com/sys/imgs/search.png")));
		okLabel.setOpaque(true);
		okLabel.setHorizontalAlignment(SwingConstants.CENTER);
		okLabel.setForeground(Color.WHITE);
		okLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		okLabel.setBackground(new Color(51, 51, 51));
		okLabel.setBounds(2, 75, 48, 48);
		okLabel.addMouseListener(new MouseListener() {
			
			boolean pressed = false;
			
			@Override
			public void mouseReleased(MouseEvent e) {
				okLabel.setBackground(Color.decode("#333333"));
				pressed = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				okLabel.setBackground(Color.decode("#68C6EF"));
				pressed = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				okLabel.setBackground(Color.decode("#333333"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!pressed)
					okLabel.setBackground(Color.decode("#535353"));
				else
					okLabel.setBackground(Color.decode("#68C6EF"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				okLabel.setBackground(Color.decode("#333333"));
				String sql = "SELECT * FROM faaliyetler WHERE konu LIKE '%"+textField_1.getText()+"%' AND odenek LIKE '%"+textField_2.getText()+"%' AND talep_tarihi LIKE '%"+textField_3.getText()+"%' AND ihale_tarihi LIKE '%"+textField_4.getText()+"%' AND sozlesme_tarihi LIKE '%"+textField_5.getText()+"%' AND firma LIKE '%"+textField_6.getText()+"%'";
				if(textField.isEnabled()&&!textField.getText().trim().equals(""))
					sql += " AND id = '"+textField.getText()+"'";
				String tmpData = "";
				for(Object o : list.getSelectedValues()) {
					try {
						String s = ((Kullanici) o).toString();
						if(!tmpData.equals(""))
							tmpData+=',';
						tmpData+="'"+s+"'";
					} catch(Exception e1) {
						//Bi bok yapma
					}
				}
				if(!tmpData.equals("")) {
					tmpData = "sorumlu IN("+tmpData+")";
					sql += " AND "+tmpData;
				}
				sql += " ORDER BY sorumlu";
				JDBCFaaliyetDAO dao = new JDBCFaaliyetDAO();
				Listeners.removeAllPanels(Manager.viewPanel, "forFun");
				Panels.createSearchResult(Manager.viewPanel, sql);
				Statics.searchResult.setVisible(true);
			}
		});
		add(okLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setText("0");
		textField.setEnabled(false);
		textField.setBounds(365, 77, 329, 32);
		add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxAk = new JCheckBox("A\u00E7\u0131k");
		chckbxAk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chckbxAk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAk.isSelected())
					textField.setEnabled(true);
				else
					textField.setEnabled(false);
			}
		});
		chckbxAk.setBounds(700, 77, 97, 32);
		add(chckbxAk);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setBounds(365, 119, 432, 32);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(365, 162, 432, 32);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(365, 205, 432, 32);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(365, 248, 432, 32);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(365, 291, 432, 32);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(365, 334, 432, 32);
		add(textField_6);
		
		list = new JList<Object>();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setFixedCellHeight(48);
		DefaultListModel<Object> defaultListModel = new DefaultListModel<Object>();
		for(Kullanici k : Statics.users)
			if(k.getId()>=0)
				defaultListModel.addElement(k);
		list.setModel(defaultListModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(365, 377, 432, 223);
		add(scrollPane);
		
		JLabel lblSNo = new JLabel("S. No :");
		lblSNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSNo.setBounds(24, 76, 329, 32);
		add(lblSNo);
		
		JLabel lblAlmKonusu = new JLabel("Al\u0131m Konusu :");
		lblAlmKonusu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlmKonusu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmKonusu.setBounds(24, 119, 329, 32);
		add(lblAlmKonusu);
		
		JLabel lbldenek = new JLabel("\u00D6denek :");
		lbldenek.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbldenek.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldenek.setBounds(24, 162, 329, 32);
		add(lbldenek);
		
		JLabel lblTalepTarihi = new JLabel("Talep Tarihi :");
		lblTalepTarihi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTalepTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTalepTarihi.setBounds(24, 205, 329, 32);
		add(lblTalepTarihi);
		
		JLabel lblIhaleTarihi = new JLabel("\u0130hale Tarihi :");
		lblIhaleTarihi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIhaleTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIhaleTarihi.setBounds(24, 248, 329, 32);
		add(lblIhaleTarihi);
		
		JLabel lblSzlemeTarihi = new JLabel("S\u00F6zle\u015Fme Tarihi :");
		lblSzlemeTarihi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSzlemeTarihi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSzlemeTarihi.setBounds(24, 290, 329, 32);
		add(lblSzlemeTarihi);
		
		JLabel lblIhalezerindeKalan = new JLabel("\u0130hale \u00DCzerinde Kalan Firma :");
		lblIhalezerindeKalan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIhalezerindeKalan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIhalezerindeKalan.setBounds(24, 334, 329, 32);
		add(lblIhalezerindeKalan);
		
		JLabel lblSorumlu = new JLabel("Sorumlu :");
		lblSorumlu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSorumlu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSorumlu.setBounds(24, 377, 329, 223);
		add(lblSorumlu);
		
		setVisible(false);
	}
}
