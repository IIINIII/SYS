package com.sys.MsgBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404174905788055753L;

	public ConfirmPanel(MsgBoxTheme theme, String title) {
		this.setBackground(theme.backColor);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {62, 0, 52, 52};
		gbl_panel.rowHeights = new int[] {0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0};
		this.setLayout(gbl_panel);

		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setOpaque(true);
		lblIcon.setBackground(new Color(0, 0, 0, 64));
		lblIcon.setIcon(theme.icon);
		GridBagConstraints gbc_lblIcon = new GridBagConstraints();
		gbc_lblIcon.insets = new Insets(0, 0, 0, 4);
		gbc_lblIcon.fill = GridBagConstraints.BOTH;
		gbc_lblIcon.gridx = 0;
		gbc_lblIcon.gridy = 0;
		this.add(lblIcon, gbc_lblIcon);

		JLabel lblMsgText = new JLabel("<html>"+title+"</html>");
		lblMsgText.setFocusable(true);
		lblMsgText.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMsgText.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblMsgText = new GridBagConstraints();
		gbc_lblMsgText.anchor = GridBagConstraints.WEST;
		gbc_lblMsgText.insets = new Insets(0, 4, 0, 4);
		gbc_lblMsgText.gridx = 1;
		gbc_lblMsgText.gridy = 0;
		this.add(lblMsgText, gbc_lblMsgText);

		JLabel lblClose = new JLabel("");
		lblClose.setOpaque(true);
		lblClose.setBackground(theme.closeBackColor);
		lblClose.setIcon(theme.closeIcon);
		lblClose.setFont(new Font("Symbol", Font.PLAIN, 11));
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblClose = new GridBagConstraints();
		gbc_lblClose.insets = new Insets(0, 0, 0, 0);
		gbc_lblClose.fill = GridBagConstraints.BOTH;
		gbc_lblClose.gridx = 3;
		gbc_lblClose.gridy = 0;
		this.add(lblClose, gbc_lblClose);
		CloseBtnDesign lblCloseDesign = new CloseBtnDesign();
		lblClose.addMouseListener(lblCloseDesign);

		JLabel lblOk = new JLabel("");
		lblOk.setOpaque(true);
		lblOk.setBackground(theme.closeBackColor);
		lblOk.setIcon(theme.okIcon);
		lblOk.setFont(new Font("Symbol", Font.PLAIN, 11));
		lblOk.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblOk = new GridBagConstraints();
		gbc_lblOk.insets = new Insets(0, 0, 0, 0);
		gbc_lblOk.fill = GridBagConstraints.BOTH;
		gbc_lblOk.gridx = 2;
		gbc_lblOk.gridy = 0;
		this.add(lblOk, gbc_lblOk);
		lblOk.addMouseListener(lblCloseDesign);
	}

}
