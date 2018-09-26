package com.sys.MsgBox;

import java.awt.Color;

import javax.swing.ImageIcon;

public class MsgBoxTheme {
	
	Color backColor;
	Color iconBackColor;
	Color closeBackColor;
	Color closeHoverBackColor;
	Color closeDownBackColor;
	ImageIcon icon;
	ImageIcon closeIcon;
	ImageIcon okIcon;
	
	public MsgBoxTheme(int type) {
		if(type == MessageBox.NOTIFICATION_MESSAGE)
			createNotificationMessage();
		else if(type == MessageBox.CONFIRM_MESSAGE)
			createConfirmMessage();
		else if(type == MessageBox.DONE_MESSAGE)
			createDoneMessage();
		else if(type == MessageBox.ERROR_MESSAGE)
			createErrorMessage();
		else if(type == MessageBox.WARNING_MESSAGE)
			createWarningMessage();
		closeIcon = new ImageIcon(MessageBox.class.getResource("images/miniKapat.png"));
		okIcon = new ImageIcon(MessageBox.class.getResource("images/miniOnay.png"));
	}
	public void createNotificationMessage() {
		backColor = Color.decode("#333333");
		iconBackColor = Color.decode("#232323");
		closeBackColor = Color.decode("#333333");
		closeDownBackColor = Color.decode("#232323");
		closeHoverBackColor = Color.decode("#434343");
		icon = new ImageIcon(MessageBox.class.getResource("images/normal_msg.png"));
	}
	public void createConfirmMessage() {
		backColor = Color.decode("#34495E");
		iconBackColor = Color.decode("#24394E");
		closeBackColor = Color.decode("#34495E");
		closeDownBackColor = Color.decode("#24394E");
		closeHoverBackColor = Color.decode("#44596E");
		icon = new ImageIcon(MessageBox.class.getResource("images/soru.png"));
	}
	public void createDoneMessage() {
		backColor = Color.decode("#27AE61");
		iconBackColor = Color.decode("#179E51");
		closeBackColor = Color.decode("#27AE61");
		closeDownBackColor = Color.decode("#179E51");
		closeHoverBackColor = Color.decode("#37BE71");
		icon = new ImageIcon(MessageBox.class.getResource("images/basari.png"));
	}
	public void createErrorMessage() {
		backColor = Color.decode("#E84C3D");
		iconBackColor = Color.decode("#D83C2D");
		closeBackColor = Color.decode("#E84C3D");
		closeDownBackColor = Color.decode("#D83C2D");
		closeHoverBackColor = Color.decode("#F85C4D");
		icon = new ImageIcon(MessageBox.class.getResource("images/hata.png"));
	}
	public void createWarningMessage() {
		backColor = Color.decode("#F39C11");
		iconBackColor = Color.decode("#E38C01");
		closeBackColor = Color.decode("#F39C11");
		closeDownBackColor = Color.decode("#E38C01");
		closeHoverBackColor = Color.decode("#FFAC21");
		icon = new ImageIcon(MessageBox.class.getResource("images/uyari.png"));
	}

}
