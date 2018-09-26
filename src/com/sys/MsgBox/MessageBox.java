package com.sys.MsgBox;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class MessageBox extends JDialog implements MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3596055285016664369L;
	MsgBoxTheme theme;
	int width = 400, height = 68;
	private int last_mouse_y = -1;
	private int last_mouse_x = -1;
	public static int OK_RESULT = 1, CLOSE_RESULT = 0;
	private int result;
	public static int NOTIFICATION_MESSAGE = 0;
	public static int CONFIRM_MESSAGE = 1;
	public static int DONE_MESSAGE = 2;
	public static int ERROR_MESSAGE = 3;
	public static int WARNING_MESSAGE = 4;

	public MessageBox(JFrame owner, String title, boolean modal, int type) {
		super(owner,title,modal);
		theme = new MsgBoxTheme(type);
		setUndecorated(true);
		getContentPane().setBackground(theme.backColor);
		getContentPane().setLayout(null);
		setSize(width, height);
		setLocationRelativeTo(null);
		addMouseMotionListener(this);
		
		if(type == CONFIRM_MESSAGE) {
			ConfirmPanel confirmPanel = new ConfirmPanel(theme, title);
			confirmPanel.setBounds(0, 0, width, height);
			getContentPane().add(confirmPanel);
		} else {
			MsgPanel msgPanel = new MsgPanel(theme, title);
			msgPanel.setBounds(0, 0, width, height);
			getContentPane().add(msgPanel);
		}

		setVisible(true);
		repaint();

	}
	
	public MessageBox(JFrame owner, String title, boolean modal, int type, int x, int y) {
		super(owner,title,modal);
		theme = new MsgBoxTheme(type);
		setUndecorated(true);
		getContentPane().setBackground(theme.backColor);
		getContentPane().setLayout(null);
		setSize(width, height);
		setLocation(x, y);
		addMouseMotionListener(this);
		
		if(type == CONFIRM_MESSAGE) {
			ConfirmPanel confirmPanel = new ConfirmPanel(theme, title);
			confirmPanel.setBounds(0, 0, width, height);
			getContentPane().add(confirmPanel);
		} else {
			MsgPanel msgPanel = new MsgPanel(theme, title);
			msgPanel.setBounds(0, 0, width, height);
			getContentPane().add(msgPanel);
		}

		setVisible(true);
		repaint();

	}
	
	public static int createMessageBox(JFrame owner, String title, boolean modal, int type) {
		return new MessageBox(owner, title, modal, type).getResult();
	}
	
	public static int createMessageBox(JFrame owner, String title, boolean modal, int type, int x, int y) {
		return new MessageBox(owner, title, modal, type, x, y).getResult();
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

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}