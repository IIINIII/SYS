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

public class AllWorksPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7272018057239949958L;

	public AllWorksPanel() {
		setBorder(new MatteBorder(0, 2, 0, 2, Color.decode("#333333")));
		setLayout(null);
		
		JLabel lblPnlTitle = new JLabel("");
		lblPnlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPnlTitle.setIcon(new ImageIcon(ChangPwdPanel.class.getResource("/com/sys/imgs/butun_isler.png")));
		lblPnlTitle.setForeground(Color.WHITE);
		lblPnlTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPnlTitle.setBounds(2, 16, 48, 48);
		lblPnlTitle.setOpaque(true);
		lblPnlTitle.setBackground(Color.decode("#333333"));
		add(lblPnlTitle);
		
		SharedFunctions.createTable(this, 64, 16, 1008, 604, "", new String[]{"S. No","Alım Konusu","Talep Tarihi","Yaklaşık Maliyet Bedeli","Ödenek","İhale Tarihi","Sözleşme Tarihi","Teslim Süresi","Sözleşme/Alım Bedeli","İlave Sipariş Bedeli","Ödenen","İhale Üzerine Kalan Firma","Açıklama","Sorumlu"});
		
		Statics.allDetails = new JLabel("");
		Statics.allDetails.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/detail.png")));
		Statics.allDetails.setOpaque(true);
		Statics.allDetails.setHorizontalAlignment(SwingConstants.CENTER);
		Statics.allDetails.setForeground(Color.WHITE);
		Statics.allDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Statics.allDetails.setBackground(new Color(51, 51, 51));
		Statics.allDetails.setBounds(2, 75, 48, 48);
		Statics.allDetails.setVisible(false);
		Statics.allDetails.addMouseListener(Listeners.btnDesign);
		add(Statics.allDetails);
		
		setVisible(false);
	}
}
