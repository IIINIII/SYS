package com.sys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sys.MsgBox.MessageBox;

public class Manager extends JFrame implements MouseMotionListener,WindowListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9181815501788384844L;
	private static int last_mouse_x = -1, last_mouse_y = -1;
	public static int width = 1200, height = 700;
	public static JPanel viewPanel = null;

	public Manager() {
		Statics.activeFrame = this;
		setResizable(false);
		setUndecorated(true);
		setTitle("[SYS] Login");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
		getContentPane().setBackground(Color.decode("#000000"));
		getContentPane().setPreferredSize(new Dimension(width+2, height+2));
		getContentPane().setLayout(null);
		
		viewPanel = new JPanel();
		viewPanel.setBackground(Color.decode("#ffffff"));
		viewPanel.setBounds(1, 1, width, height);
		getContentPane().add(viewPanel);
		GridBagLayout gbl_viewPanel = new GridBagLayout();
		gbl_viewPanel.columnWidths = new int[] {48, 32, 1088, 32};
		gbl_viewPanel.rowHeights = new int[] {32, 636, 32};
		gbl_viewPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_viewPanel.rowWeights = new double[]{0.0, 0.0, 0.0};
		viewPanel.setLayout(gbl_viewPanel);
		
		/*JLabel lblHeaderImage = new JLabel("");
		lblHeaderImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderImage.setIcon(new ImageIcon(Manager.class.getResource("/com/sys/imgs/ankara-wide1.png")));
		GridBagConstraints gbc_lblHeaderImage = new GridBagConstraints();
		gbc_lblHeaderImage.fill = GridBagConstraints.BOTH;
		gbc_lblHeaderImage.gridwidth = gbl_viewPanel.columnWidths.length;
		gbc_lblHeaderImage.gridx = 0;
		gbc_lblHeaderImage.gridy = 0;
		viewPanel.add(lblHeaderImage, gbc_lblHeaderImage);*/
		
		GridBagConstraints gbc_sidePanel = new GridBagConstraints();
		gbc_sidePanel.gridheight = 1;
		gbc_sidePanel.anchor = GridBagConstraints.NORTH;
		gbc_sidePanel.fill = GridBagConstraints.BOTH;
		gbc_sidePanel.gridwidth = 1;
		gbc_sidePanel.gridx = 0;
		gbc_sidePanel.gridy = 1;
		SidePanel sidePanel = new SidePanel(gbl_viewPanel.columnWidths[gbc_sidePanel.gridx], 9, gbl_viewPanel.rowHeights[gbc_sidePanel.gridy]-4);
		viewPanel.add(sidePanel, gbc_sidePanel);
		sidePanel.CreateIconBtn("profil.png", Statics.user.getAd_soyad());
		if(!Statics.user.getAd_soyad().equalsIgnoreCase("admin"))
			sidePanel.CreateIconBtn("islerim.png", "İşlerim");
		sidePanel.CreateIconBtn("butun_isler.png", "Tüm İşler");
		if(Statics.user.getAd_soyad().equalsIgnoreCase("admin")) {
			sidePanel.CreateIconBtn("users.png", "Personel Ayarları");
		}
		sidePanel.CreateIconBtn("arama.png", "Faaliyet Ara");
		sidePanel.CreateIconBtn("ekle.png", "Faaliyet Ekle");
		sidePanel.CreateIconBtn("sifre.png", "Şifre Değiştirme");
		sidePanel.CreateLastBtn("cikis.png", "Çıkış");
		
		pack();
		this.addMouseMotionListener(this);
		setLocationRelativeTo(null);
		setVisible(true);
		Listeners.removeAllPanels(viewPanel, "forFun");
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		last_mouse_x=e.getX();
		last_mouse_y =e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(last_mouse_x==-1)last_mouse_x=e.getX();
		if(last_mouse_y==-1)last_mouse_y=e.getY();
		int dx = e.getX()-last_mouse_x, dy = e.getY()-last_mouse_y;
		this.setLocation(this.getLocation().x+dx, this.getLocation().y+dy);
	}

	@Override
	public void windowClosing(WindowEvent e) {	
		if(MessageBox.createMessageBox(this, "Abi çıkıyon mu?", true, MessageBox.CONFIRM_MESSAGE, this.getLocation().x+Manager.width-399, this.getLocation().y+601)==MessageBox.OK_RESULT) {
			dispose();
			System.exit(0);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
