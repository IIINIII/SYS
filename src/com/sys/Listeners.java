package com.sys;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sys.MsgBox.MessageBox;

public abstract class Listeners {

	static JLabel secilmis = null;
	
	public static MouseListener btnDesign = new MouseListener() {

		Color normal = Color.decode("#333333");
		Color hover = Color.decode("#555555");
		Color selectedNormal = Color.decode("#4CBCEE");
		Color selectedHover = Color.decode("#68C6EF");
		Color selectedExit = Color.decode("#E91E63");

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel b = (JLabel) e.getSource();
			if(secilmis != b) {
				b.setOpaque(true);
				b.setBackground(normal);
			} else {
				b.setOpaque(true);
				b.setBackground(selectedNormal);
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			JLabel b = (JLabel) e.getSource();
			if(secilmis != b) {
				b.setOpaque(true);
				b.setBackground(hover);
			} else {
				b.setOpaque(true);
				b.setBackground(selectedHover);
			}
			//Statics.lblBtnTitle = new JLabel(b.getToolTipText());

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(profilMi((JLabel) e.getSource()))
				return;
			if(cikisMi((JLabel) e.getSource())) {
				JLabel b = (JLabel) e.getSource();
				b.setOpaque(true);
				b.setBackground(selectedExit);
				if(MessageBox.createMessageBox((JFrame) SwingUtilities.getRoot(b), "Abi çıkıyon mu?", true, MessageBox.CONFIRM_MESSAGE, SwingUtilities.getRoot(b).getLocation().x+Manager.width-399, SwingUtilities.getRoot(b).getLocation().y+601)==MessageBox.OK_RESULT) {
					System.exit(0);
				} else {
					b.setOpaque(true);
					b.setBackground(normal);
				}
				return;
			}
			if(secilmis!=null) {
				secilmis.setOpaque(true);
				secilmis.setBackground(normal);
			}
			JLabel b = (JLabel) e.getSource();
			b.setOpaque(true);
			b.setBackground(selectedHover);
			secilmis = b;
			removeAllPanels(Manager.viewPanel, "forFun");
			if(b.getIcon().toString().contains("sifre.png")) {
				Panels.createChangPwdPanel(Manager.viewPanel);
				Statics.changPwdPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("butun_isler.png")) {
				Panels.createAllWorksPanel(Manager.viewPanel);
				Statics.allWorksPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("users.png")) {
				Panels.createUsersPanel(Manager.viewPanel);
				Statics.usersPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("islerim.png")) {
				Panels.createMyWorksPanel(Manager.viewPanel);
				Statics.myWorksPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("detail.png")) {
				DetailPanel.ekle = false;
				Panels.createDetailPanel(Manager.viewPanel);
				Statics.detailPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("ekle.png")) {
				DetailPanel.arama = false;
				DetailPanel.ekle = true;
				Panels.createDetailPanel(Manager.viewPanel);
				Statics.detailPanel.setVisible(true);
			} else if(b.getIcon().toString().contains("arama.png")) {
				Panels.createSearchFaaliyet(Manager.viewPanel);
				Statics.searchFaaliyet.setVisible(true);
			}
			SwingUtilities.getRoot(Manager.viewPanel).repaint();
		}
	};

	public static boolean profilMi(JLabel b) {
		if(b.getIcon().toString().contains("profil.png"))
			return true;
		return false;
	}

	public static boolean cikisMi(JLabel b) {
		if(b.getIcon().toString().contains("cikis.png"))
			return true;
		return false;
	}
	
	public static void removeAllPanels(JComponent c, String text) {
		for(Object o : c.getComponents()) {
			try {
				JPanel p = (JPanel) o;
				if(p.getToolTipText().equals(text)) {
					c.remove(p);
				}
			} catch(Exception e) {
				
			}
		}
	}

}
