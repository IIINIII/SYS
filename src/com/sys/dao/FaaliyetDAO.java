package com.sys.dao;

import java.util.ArrayList;

import com.sys.vo.Faaliyet;

public interface FaaliyetDAO {
	
	public boolean insert(Faaliyet faaliyet);
	public boolean update(Faaliyet faaliyet);
	public boolean delete(int id);
	public ArrayList<Faaliyet> select();
	public ArrayList<Faaliyet> selectFrom(String s);
	public ArrayList<Faaliyet> selectWhere(String sql);

}
