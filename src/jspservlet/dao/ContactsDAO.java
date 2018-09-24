package jspservlet.dao;

import java.util.ArrayList;

import jspservlet.vo.Contacts;

public interface ContactsDAO {
	public void add(Contacts contacts) throws Exception; 
	public void delete(Contacts contacts) throws Exception; 
	public void modify(Contacts contacts) throws Exception;
	public ArrayList<Contacts> queryByContactsNature(String i ,Contacts contacts) throws Exception;
}
