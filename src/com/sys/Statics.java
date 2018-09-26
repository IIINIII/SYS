package com.sys;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sys.vo.Faaliyet;
import com.sys.vo.Kullanici;

public abstract class Statics {
	
	public static Kullanici user = null;
	public static ArrayList<Kullanici> users = null;
	public static JLabel lblBtnTitle = null;
	public static JFrame activeFrame = null;
	public static ChangPwdPanel changPwdPanel = null;
	public static AllWorksPanel allWorksPanel = null;
	public static MyWorksPanel myWorksPanel = null;
	public static DetailPanel detailPanel = null;
	public static UsersPanel usersPanel = null;
	public static SearchFaaliyet searchFaaliyet = null;
	public static SearchResult searchResult = null;
	public static FaaliyetForm faaliyetForm = null;
	public static JLabel allDetails = null;
	public static JLabel myDetails = null;
	public static JLabel rsDetails = null;
	public static Faaliyet selectedFaaliyet = null;
	public static Faaliyet selectedFaaliyet1 = null;
	public static ArrayList<Faaliyet> faaliyetler = null;
	public static ArrayList<Faaliyet> faaliyetler1 = null;
	public static ArrayList<Faaliyet> faaliyetler2 = null;
	
}
