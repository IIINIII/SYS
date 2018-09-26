package com.sys;

import java.awt.GridBagConstraints;
import java.sql.PreparedStatement;

import javax.swing.JComponent;

import com.sys.vo.Faaliyet;

public class Panels {
	
	public static GridBagConstraints createLayoutConstraints() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 1;
		gbc.gridx = 2;
		gbc.gridy = 1;
		return gbc;
	}
	
	public static void createChangPwdPanel(JComponent c) {
		Statics.changPwdPanel = new ChangPwdPanel();
		Statics.changPwdPanel.setToolTipText("forFun");
		c.add(Statics.changPwdPanel, createLayoutConstraints());
	}
	
	public static void createAllWorksPanel(JComponent c) {
		Statics.allWorksPanel = new AllWorksPanel();
		Statics.allWorksPanel.setToolTipText("forFun");
		DetailPanel.tumu=true;
		c.add(Statics.allWorksPanel, createLayoutConstraints());
	}
	
	public static void createDetailPanel(JComponent c) {
		Statics.detailPanel = new DetailPanel(false);
		if(DetailPanel.arama) {
			Statics.faaliyetForm.setFaaliyet1();
			if(DetailPanel.degisme)
				Statics.faaliyetForm.setEditables(true);
			else
				Statics.faaliyetForm.setEditables(false);
			DetailPanel.ekle = false;
			DetailPanel.tumu = false;
		}
		else if(DetailPanel.ekle) {
			Statics.selectedFaaliyet = new Faaliyet();
			Statics.faaliyetForm.setFaaliyet();
			Statics.faaliyetForm.setEditables(true);
		}
		else if(DetailPanel.tumu) {
			Statics.faaliyetForm.setFaaliyet();
			Statics.faaliyetForm.setEditables(false);
		}
		else {
			Statics.faaliyetForm.setFaaliyet1();
			Statics.faaliyetForm.setEditables(true);
		}
		Statics.detailPanel.setToolTipText("forFun");
		c.add(Statics.detailPanel, createLayoutConstraints());
	}
	
	public static void createUsersPanel(JComponent c) {
		Statics.usersPanel = new UsersPanel();
		Statics.usersPanel.setToolTipText("forFun");
		c.add(Statics.usersPanel, createLayoutConstraints());
	}
	
	public static void createMyWorksPanel(JComponent c) {
		Statics.myWorksPanel = new MyWorksPanel();
		Statics.myWorksPanel.setToolTipText("forFun");
		DetailPanel.tumu=false;
		c.add(Statics.myWorksPanel, createLayoutConstraints());
	}
	
	public static void createSearchFaaliyet(JComponent c) {
		Statics.searchFaaliyet = new SearchFaaliyet();
		Statics.searchFaaliyet.setToolTipText("forFun");
		c.add(Statics.searchFaaliyet, createLayoutConstraints());
	}
	
	public static void createSearchResult(JComponent c, String sql) {
		Statics.searchResult = new SearchResult(sql);
		Statics.searchResult.setToolTipText("forFun");
		c.add(Statics.searchResult, createLayoutConstraints());
	}

}
