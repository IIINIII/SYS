package com.sys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.sys.MsgBox.MessageBox;
import com.sys.dao.JDBCKullaniciDAO;
import com.sys.vo.Kullanici;

public class Login extends JFrame implements MouseMotionListener, ActionListener, WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2054956700598133985L;
	
	public static int width=400,height=600;
	JButton btnLogin,btnExit;
	JComboBox<Object> usersBox;
	JPasswordField pwdBox;
	private int last_mouse_x=-1,last_mouse_y=-1;

	public Login() {

		Statics.activeFrame = this;
		setResizable(false);
		setUndecorated(true);
		setTitle("[SYS] Login");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		getContentPane().setBackground(Color.decode("#000000"));
		getContentPane().setPreferredSize(new Dimension(width+2, height+2));
		getContentPane().setLayout(null);
		
		JPanel viewPanel = new JPanel();
		viewPanel.setBackground(Color.decode("#000000"));
		viewPanel.setBounds(1, 1, width, height);
		getContentPane().add(viewPanel);
		GridBagLayout gbl_viewPanel = new GridBagLayout();
		gbl_viewPanel.columnWidths = new int[] {72, 256, 72};
		gbl_viewPanel.rowHeights = new int[] {100, 100, 24, 40, 24, 40, 64, 64, 144};
		gbl_viewPanel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_viewPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		viewPanel.setLayout(gbl_viewPanel);
		
		JLabel lblAnkara = new JLabel("");
		lblAnkara.setIcon(new ImageIcon(Login.class.getResource("/com/sys/imgs/ankara.png")));
		GridBagConstraints gbc_lblAnkara = new GridBagConstraints();
		gbc_lblAnkara.anchor = GridBagConstraints.NORTH;
		gbc_lblAnkara.gridwidth = 3;
		gbc_lblAnkara.gridx = 0;
		gbc_lblAnkara.gridy = 0;
		viewPanel.add(lblAnkara, gbc_lblAnkara);
		
		/*JLabel lblTitle = new JLabel("S.Y.S");
		lblTitle.setFont(new Font("Montserrat", Font.PLAIN, 64));
		lblTitle.setForeground(Color.decode("#FDFDFD"));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		viewPanel.add(lblTitle, gbc_lblTitle);
		
		JLabel lblTitle1 = new JLabel("[       ]");
		lblTitle1.setFont(new Font("Montserrat Hairline", Font.PLAIN, 72));
		lblTitle1.setForeground(Color.decode("#F44336"));
		GridBagConstraints gbc_lblTitle1 = new GridBagConstraints();
		gbc_lblTitle1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle1.gridx = 1;
		gbc_lblTitle1.gridy = 1;
		viewPanel.add(lblTitle1, gbc_lblTitle1);*/
		
		JLabel lblTitle = new JLabel(new ImageIcon(Login.class.getResource("/com/sys/imgs/logo_gray.png")));
		lblTitle.setFont(new Font("Montserrat", Font.PLAIN, 64));
		lblTitle.setForeground(Color.decode("#FDFDFD"));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		viewPanel.add(lblTitle, gbc_lblTitle);
		
		JLabel lblUser = new JLabel("Kullan\u0131c\u0131 :");
		lblUser.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblUser.setForeground(Color.decode("#EEEEEE"));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.insets = new Insets(0, 5, 0, 5);
		gbc_lblUser.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 2;
		viewPanel.add(lblUser, gbc_lblUser);
		
		usersBox = new JComboBox<Object>();
		GridBagConstraints gbc_usersBox = new GridBagConstraints();
		gbc_usersBox.insets = new Insets(5, 5, 5, 5);
		gbc_usersBox.fill = GridBagConstraints.BOTH;
		gbc_usersBox.gridx = 1;
		gbc_usersBox.gridy = 3;
		viewPanel.add(usersBox, gbc_usersBox);
		
		JLabel lblPassword = new JLabel("\u015Eifre :");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPassword.setForeground(Color.decode("#EEEEEE"));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblPassword.insets = new Insets(0, 5, 0, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		viewPanel.add(lblPassword, gbc_lblPassword);
		
		pwdBox = new JPasswordField();
		pwdBox.addActionListener(this);
		GridBagConstraints gbc_pwdBox = new GridBagConstraints();
		gbc_pwdBox.insets = new Insets(5, 5, 5, 5);
		gbc_pwdBox.fill = GridBagConstraints.BOTH;
		gbc_pwdBox.gridx = 1;
		gbc_pwdBox.gridy = 5;
		viewPanel.add(pwdBox, gbc_pwdBox);
		
		btnLogin = new JButton("Giri\u015F");
		btnLogin.addActionListener(this);
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.fill = GridBagConstraints.BOTH;
		gbc_btnLogin.insets = new Insets(24, 5, 8, 5);
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 6;
		viewPanel.add(btnLogin, gbc_btnLogin);
		
		btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.addActionListener(this);
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(16, 5, 16, 5);
		gbc_btnExit.fill = GridBagConstraints.BOTH;
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 7;
		viewPanel.add(btnExit, gbc_btnExit);
		
		pack();
		this.addMouseMotionListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JDBCKullaniciDAO dao = new JDBCKullaniciDAO();
		dao.getConnection();
		Statics.users = dao.select();
		if(Statics.users == null)
			Statics.users = new ArrayList<Kullanici>();
		Statics.users.add(0, new Kullanici(-1, "Seçiniz", "", false));
		usersBox.setModel(new DefaultComboBoxModel<Object>(Statics.users.toArray()));
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		last_mouse_x=e.getX();
		last_mouse_y=e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(last_mouse_x==-1)last_mouse_x=e.getX();
		if(last_mouse_y==-1)last_mouse_y=e.getY();
		int dx = e.getX()-last_mouse_x, dy = e.getY()-last_mouse_y;
		this.setLocation(this.getLocation().x+dx, this.getLocation().y+dy);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().getClass().equals(JButton.class)) {
			JButton b = (JButton) e.getSource();
			if(b.getText().equals("Çıkış")) {
				if(MessageBox.createMessageBox(this, "Abi çıkıyon mu?", true, MessageBox.CONFIRM_MESSAGE, this.getLocation().x+1, this.getLocation().y+height-67)==MessageBox.OK_RESULT) {
					dispose();
					System.exit(0);
				}
			} else {
				pwdBox.requestFocus();
				if(usersBox.getSelectedIndex()==0) {
					MessageBox.createMessageBox(this, "Lütfen bir kullanıcı seçiniz!", true, MessageBox.ERROR_MESSAGE, this.getLocation().x+1, this.getLocation().y+height-67);
					usersBox.requestFocus();
					return;
				} else if(pwdBox.getPassword().length==0) {
					MessageBox.createMessageBox(this, "Lütfen şifrenizi giriniz!", true, MessageBox.ERROR_MESSAGE, this.getLocation().x+1, this.getLocation().y+height-67);
					return;
				}
				JDBCKullaniciDAO dao = new JDBCKullaniciDAO();
				dao.getConnection();
				int id = dao.checkExistance(new Kullanici(0,usersBox.getSelectedItem().toString(),new String(pwdBox.getPassword()),true));
				dao.closeConnection();
				if(id!=-1) {
					Statics.user = new Kullanici(id,usersBox.getSelectedItem().toString(),new String(pwdBox.getPassword()),true);
					setVisible(false);
					new Manager();
				} else {
					MessageBox.createMessageBox(this, "Hatalı şifre! Tekrar giriniz!", true, MessageBox.ERROR_MESSAGE, this.getLocation().x+1, this.getLocation().y+height-67);
				}
				pwdBox.setText("");
			}
		} else if(e.getSource().getClass().equals(JPasswordField.class)) {
			btnLogin.doClick();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(MessageBox.createMessageBox(this, "Abi çıkıyon mu?", true, MessageBox.CONFIRM_MESSAGE, this.getLocation().x+1, this.getLocation().y+height-67)==MessageBox.OK_RESULT) {
			dispose();
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
