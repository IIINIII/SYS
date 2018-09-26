package com.sys;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class SearchResult extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7193552891737690898L;

	public SearchResult(String sql) {
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
		
		SharedFunctions.createSearchTable(this, 64, 16, 1008, 604, sql, new String[]{"S. No","Alım Konusu","Talep Tarihi","Yaklaşık Maliyet Bedeli","Ödenek","İhale Tarihi","Sözleşme Tarihi","Teslim Süresi","Sözleşme/Alım Bedeli","İlave Sipariş Bedeli","Ödenen","İhale Üzerine Kalan Firma","Açıklama","Sorumlu"});
		
		Statics.rsDetails = new JLabel("");
		Statics.rsDetails.setIcon(new ImageIcon(AllWorksPanel.class.getResource("/com/sys/imgs/detail.png")));
		Statics.rsDetails.setOpaque(true);
		Statics.rsDetails.setHorizontalAlignment(SwingConstants.CENTER);
		Statics.rsDetails.setForeground(Color.WHITE);
		Statics.rsDetails.setFont(new Font("Tahoma", Font.PLAIN, 24));
		Statics.rsDetails.setBackground(new Color(51, 51, 51));
		Statics.rsDetails.setBounds(2, 75, 48, 48);
		Statics.rsDetails.setVisible(false);
		Statics.rsDetails.addMouseListener(Listeners.btnDesign);
		add(Statics.rsDetails);
		
		setVisible(false);
	}
}
