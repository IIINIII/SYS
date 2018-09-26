package com.sys.dao;

import java.util.ArrayList;
import com.sys.vo.Kullanici;

public interface KullaniciDAO {

	public int checkExistance(Kullanici kullanici);
	public boolean insert(Kullanici kullanici);
	public boolean update(Kullanici kullanici);
	public boolean delete(int id);
	public ArrayList<Kullanici> select();

}
