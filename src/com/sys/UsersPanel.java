package com.sys;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

import com.sys.MsgBox.MessageBox;
import com.sys.dao.JDBCKullaniciDAO;
import com.sys.vo.Kullanici;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class UsersPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7589061970384205599L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public UsersPanel() {
		setBorder(new MatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(UsersPanel.class.getResource("/com/sys/imgs/users.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.decode("#fafafa"));
		panel1.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel1.setBounds(583, 92, 396, 497);
		add(panel1);
		panel1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(UsersPanel.class.getResource("/com/sys/imgs/remove_user.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(12, 12, 372, 160);
		panel1.add(label_1);
		
		JLabel label_2 = new JLabel("Ad Soyad :");
		label_2.setBounds(12, 183, 372, 15);
		panel1.add(label_2);
		
		JList<Object> list = new JList<Object>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		list.setFixedCellHeight(48);
		DefaultListModel<Object> defaultListModel = new DefaultListModel<Object>();
		for(Kullanici k : Statics.users)
			if(k.getId()>=0)
				defaultListModel.addElement(k);
		list.setModel(defaultListModel);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(12, 210, 372, 200);
		panel1.add(scrollPane);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()==-1) {
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnSil), "Lütfen bir personel seçiniz!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnSil).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnSil).getLocation().y+601);
				}
				else if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnSil), list.getSelectedValue() + " silinsin mi?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(btnSil).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnSil).getLocation().y+601) == MessageBox.OK_RESULT) {
					JDBCKullaniciDAO dao = new JDBCKullaniciDAO();
					dao.getConnection();
					((Kullanici) list.getSelectedValue()).setActive(false);
					if(dao.update((Kullanici) list.getSelectedValue())) {
						((DefaultListModel<Object>) list.getModel()).remove(list.getSelectedIndex());
						MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnSil), "Personel başarıyla silindi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(btnSil).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnSil).getLocation().y+601);
					} else {
						MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnSil), "Personel silinemedi!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnSil).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnSil).getLocation().y+601);
					}
					dao.closeConnection();
				}
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSil.setBounds(12, 421, 372, 65);
		panel1.add(btnSil);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#fafafa"));
		panel.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(92, 92, 396, 497);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UsersPanel.class.getResource("/com/sys/imgs/add_user.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(12, 12, 372, 160);
		panel.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(12, 211, 372, 42);
		panel.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(12, 292, 372, 42);
		panel.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(12, 373, 372, 42);
		panel.add(textField_2);
		
		JButton button_1 = new JButton("Temizle");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		
		JButton button = new JButton("Ekle");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().length()==0||textField_1.getText().trim().length()==0||textField_2.getText().trim().length()==0) {
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(button), "Alanlar boş bırakılmamalı!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(button).getLocation().x+Manager.width-399, SwingUtilities.getRoot(button).getLocation().y+601);
					textField_1.setText("");
					textField_2.setText("");
				} else if(!textField_1.getText().equals(textField_2.getText())) {
					System.out.println(textField_1.getText());
					System.out.println(textField_2.getText());
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(button), "Şifreler uyuşmuyor!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(button).getLocation().x+Manager.width-399, SwingUtilities.getRoot(button).getLocation().y+601);
					textField_1.setText("");
					textField_2.setText("");
				} else {
					JDBCKullaniciDAO dao = new JDBCKullaniciDAO();
					dao.getConnection();
					if(dao.insert(new Kullanici(-1, textField.getText().trim(), textField_1.getText(), true))) {
						MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(button), "Yeni personel eklendi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(button).getLocation().x+Manager.width-399, SwingUtilities.getRoot(button).getLocation().y+601);
						button_1.doClick();
					}
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(12, 426, 170, 42);
		panel.add(button);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_1.setBounds(214, 426, 170, 42);
		panel.add(button_1);
		
		JLabel lblAdSoyad = new JLabel("Ad Soyad :");
		lblAdSoyad.setBounds(12, 184, 372, 15);
		panel.add(lblAdSoyad);
		
		JLabel lblifre = new JLabel("Şifre :");
		lblifre.setBounds(12, 265, 372, 15);
		panel.add(lblifre);
		
		JLabel lblifretekrar = new JLabel("Şifre (Tekrar) :");
		lblifretekrar.setBounds(12, 346, 372, 15);
		panel.add(lblifretekrar);
		
		setVisible(false);
	}
}
