package com.sys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.sys.MsgBox.MessageBox;
import com.sys.dao.JDBCKullaniciDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangPwdPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6737016303955918414L;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JLabel label,label_1,label_2;
	private JLabel lblEskiifre;
	private JLabel lblYeniifre;
	private JLabel lblYeniifreTekrar;
	
	public ChangPwdPanel() {
		
		//this.setBackground(Color.decode("#dddddd"));
		this.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		this.setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/sifre.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		JLabel lblProfilResmi = new JLabel("");
		lblProfilResmi.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfilResmi.setIcon(new ImageIcon(Manager.class.getResource("/com/sys/imgs/usericon.png")));
		lblProfilResmi.setBounds(134, 152, 279, 345);
		this.add(lblProfilResmi);
		
		JLabel lblAdSoyad = new JLabel(Statics.user.getAd_soyad());
		lblAdSoyad.setFont(new Font("Montserrat", Font.PLAIN, 24));
		lblAdSoyad.setBounds(455, 152, 400, 42);
		this.add(lblAdSoyad);
		
		textField = new JPasswordField();
		textField.setFont(new Font("Montserrat Light", Font.PLAIN, 24));
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().length()==0)
					return;
				if(textField.getText().equals(Statics.user.getSifre())) {
					label.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_dogru.png")));
					label.setToolTipText("Şifreniz doğru girilmiştir!");
				}
				else {
					label.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_yanlis.png")));
					label.setToolTipText("Şifreniz yanlış girilmiştir!");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				label.setIcon(null);
				label.setToolTipText("");
			}
		});
		textField.setBounds(455, 232, 400, 42);
		this.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setFont(new Font("Montserrat Light", Font.PLAIN, 24));
		textField_1.setColumns(10);
		textField_1.setBounds(455, 311, 400, 42);
		this.add(textField_1);
		
		textField_2 = new JPasswordField();
		textField_2.setFont(new Font("Montserrat Light", Font.PLAIN, 24));
		textField_2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().length()==0&&textField_2.getText().length()==0)
					return;
				if(textField_1.getText().equals(textField_2.getText())&&textField_1.getText().length()>0) {
					label_2.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_dogru.png")));
					label_2.setToolTipText("Yeni şifrenizin tekrarı doğru girilmiştir!");
				}
				else {
					label_2.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_yanlis.png")));
					label_2.setToolTipText("Yeni şifrenizin tekrarı yanlış girilmiştir!");
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				label_2.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_tekrar.png")));
				label_2.setToolTipText("Yeni şifrenizi tekrar giriniz!");
			}
		});
		textField_2.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				if(textField_1.getText().length()==0&&textField_2.getText().length()==0)
					return;
				if(textField_1.getText().equals(textField_2.getText())&&textField_1.getText().length()>0) {
					label_2.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_dogru.png")));
					label_2.setToolTipText("Yeni şifrenizin tekrarı doğru girilmiştir!");
				}
				else {
					label_2.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/sifre_yanlis.png")));
					label_2.setToolTipText("Yeni şifrenizin tekrarı yanlış girilmiştir!");
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(455, 390, 400, 42);
		this.add(textField_2);
		
		JButton btnDeitir = new JButton("Değiştir");
		btnDeitir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(Statics.user.getSifre())&&textField_1.getText().equals(textField_2.getText())&&textField_1.getText().length()>0) {
					Statics.user.setSifre(textField_1.getText());
					JDBCKullaniciDAO dao = new JDBCKullaniciDAO();
					dao.getConnection();
					boolean rs = dao.update(Statics.user);
					dao.closeConnection();
					if(rs) {
						MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnDeitir), "Şifreniz başarıyla değiştirildi!", true, MessageBox.DONE_MESSAGE, SwingUtilities.getRoot(btnDeitir).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnDeitir).getLocation().y+601);
					} else  {
						MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnDeitir), "Şifre değiştirme işlemi başarısız!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnDeitir).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnDeitir).getLocation().y+601);
					}
				} else if(!textField.getText().equals(Statics.user.getSifre())) {
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnDeitir), "Şifreniz hatalı girilmiştir!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnDeitir).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnDeitir).getLocation().y+601);
				} else if(!textField_1.getText().equals(textField_2.getText())) {
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnDeitir), "Yeni şifre ve tekrarı uyuşmuyorlar!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnDeitir).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnDeitir).getLocation().y+601);
				} else if(textField_1.getText().length()==0) {
					MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(btnDeitir), "Yeni şifre boş olamaz!", true, MessageBox.ERROR_MESSAGE, SwingUtilities.getRoot(btnDeitir).getLocation().x+Manager.width-399, SwingUtilities.getRoot(btnDeitir).getLocation().y+601);
				}
			}
		});
		btnDeitir.setBounds(695, 455, 160, 42);
		this.add(btnDeitir);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(873, 232, 42, 42);
		this.add(label);
		
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(873, 311, 42, 42);
		this.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/sifre_tekrar.png")));
		label_2.setBounds(873, 390, 42, 42);
		this.add(label_2);
		
		lblEskiifre = new JLabel("Eski Şifre :");
		lblEskiifre.setBounds(455, 206, 400, 15);
		add(lblEskiifre);
		
		lblYeniifre = new JLabel("Yeni Şifre :");
		lblYeniifre.setBounds(455, 285, 400, 15);
		add(lblYeniifre);
		
		lblYeniifreTekrar = new JLabel("Yeni Şifre (Tekrar) :");
		lblYeniifreTekrar.setBounds(455, 364, 400, 15);
		add(lblYeniifreTekrar);
		
		setVisible(false);
		
	}
}
