package jspservlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ContactsDAO;
import jspservlet.dao.impl.ContactsImpl;
import jspservlet.vo.Contacts;
import net.sf.json.JSONArray;

public class SearchServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 Contacts contacts = new Contacts();
		 JSONArray jsonArray =new JSONArray();
		 contacts.setNature(req.getParameter("nature"));
		 
		 ContactsDAO dao = new ContactsImpl();
		 
		
		 
		 try {
				dao.queryByContactsNature("0",contacts);
				jsonArray =ContactsImpl.jsonArray;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 res.setContentType("text/html");
			 PrintWriter out=res.getWriter();
			 out.println(jsonArray);
			 System.out.println(jsonArray);
		 }
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{

	 }
}