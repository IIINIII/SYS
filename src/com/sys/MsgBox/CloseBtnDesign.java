package com.sys.MsgBox;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class CloseBtnDesign implements MouseListener, FocusListener {

	boolean pressed = false;
	
	@Override
	public void mouseReleased(MouseEvent e) {
		JLabel b = (JLabel) e.getSource();
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeBackColor);
		b.setBorder(null);
		pressed = false;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		JLabel b = (JLabel) e.getSource();
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeDownBackColor);
		b.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(0, 0, 0, 64)));
		pressed = true;
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		JLabel b = (JLabel) e.getSource();
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeBackColor);
		b.setBorder(null);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		JLabel b = (JLabel) e.getSource();
		if(pressed) {
			b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeDownBackColor);
			b.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, new Color(0, 0, 0, 32)));
			return;
		}
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeHoverBackColor);
		b.setBorder(null);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel b = (JLabel) e.getSource();
		MessageBox frame = (MessageBox) SwingUtilities.getRoot(b);
		if(b.getIcon().toString().contains("miniKapat.png"))
			frame.setResult(MessageBox.CLOSE_RESULT);
		else
			frame.setResult(MessageBox.OK_RESULT);
		frame.setVisible(false);
	}

	@Override
	public void focusGained(FocusEvent e) {
		JLabel b = (JLabel) e.getSource();
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeBackColor);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JLabel b = (JLabel) e.getSource();
		b.setBackground(((MessageBox)SwingUtilities.getRoot(b)).theme.closeHoverBackColor);
	}

}
