package com.sys;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SidePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -860814314500158496L;
	int btnNum = 0, maxBtnNum = 8;
	int pnlHeight;

	public SidePanel(int width, int maxBtnNum, int pnlHeight) {
		this.maxBtnNum = maxBtnNum;
		this.pnlHeight = pnlHeight;
		this.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.decode("#4EB8EC")));
		this.setBackground(Color.decode("#333333"));
		GridBagLayout gbl_sidePanel = new GridBagLayout();
		gbl_sidePanel.columnWidths = new int[] {width};
		gbl_sidePanel.rowHeights = CreateBtnPlaces(width);
		gbl_sidePanel.columnWeights = new double[]{0.0};
		gbl_sidePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		this.setLayout(gbl_sidePanel);
	}
	
	public void CreateIconBtn(String iconFileName, String text) {
		JLabel lblCurrentBtn = new JLabel("");
		lblCurrentBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBtn.addMouseListener(Listeners.btnDesign);
		lblCurrentBtn.setIcon(new ImageIcon(Manager.class.getResource("/com/sys/imgs/"+iconFileName)));
		GridBagConstraints gbc_CurrentBtn = new GridBagConstraints();
		gbc_CurrentBtn.fill = GridBagConstraints.BOTH;
		gbc_CurrentBtn.gridx = 0;
		btnNum++;
		if(btnNum==maxBtnNum)
			btnNum++;
		gbc_CurrentBtn.gridy = btnNum-1;
		lblCurrentBtn.setToolTipText(text);
		this.add(lblCurrentBtn, gbc_CurrentBtn);
	}
	
	public void CreateLastBtn(String iconFileName, String text) {
		JLabel lblCurrentBtn = new JLabel("");
		lblCurrentBtn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentBtn.addMouseListener(Listeners.btnDesign);
		lblCurrentBtn.setIcon(new ImageIcon(Manager.class.getResource("/com/sys/imgs/"+iconFileName)));
		GridBagConstraints gbc_CurrentBtn = new GridBagConstraints();
		gbc_CurrentBtn.fill = GridBagConstraints.BOTH;
		gbc_CurrentBtn.gridx = 0;
		gbc_CurrentBtn.gridy = maxBtnNum;
		lblCurrentBtn.setToolTipText(text);
		this.add(lblCurrentBtn, gbc_CurrentBtn);
	}
	
	public int[] CreateBtnPlaces(int height) {
		int[] rowHeights = new int[maxBtnNum+1];
		for(int i=0;i<maxBtnNum-1;i++) {
			rowHeights[i]=height;
		}
		rowHeights[maxBtnNum-1]=pnlHeight-maxBtnNum*height;
		rowHeights[maxBtnNum]=height;
		return rowHeights;
	}

}
