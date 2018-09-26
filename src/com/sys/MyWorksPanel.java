package com.sys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class MyWorksPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7272018057239949958L;

	public MyWorksPanel() {
		setBorder(new MatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(MyWorksPanel.class.getResource("/com/sys/imgs/islerim.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		SharedFunctions.createMyTable(this, 64, 16, 1008, 604, "", new String[]{"S. No","Alım Konusu","Talep Tarihi","Yaklaşık Maliyet Bedeli","Ödenek","İhale Tarihi","Sözleşme Tarihi","Teslim Süresi","Sözleşme/Alım Bedeli","İlave Sipariş Bedeli","Ödenen","İhale Üzerine Kalan Firma","Açıklama","Sorumlu"});
		
		Statics.myDetails = new JLabel("");
		Statics.myDetails.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/detail.png")));
		Statics.myDetails.setOpaque(true);
		Statics.myDetails.setHorizontalAlignment(SwingConstants.CENTER);
		Statics.myDetails.setForeground(Color.WHITE);
		Statics.myDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Statics.myDetails.setBackground(new Color(51, 51, 51));
		Statics.myDetails.setBounds(2, 75, 48, 48);
		Statics.myDetails.setVisible(false);
		Statics.myDetails.addMouseListener(Listeners.btnDesign);
		add(Statics.myDetails);
		
		setVisible(false);
	}
}
