package jspservlet.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ContactsDAO;
import jspservlet.dao.impl.ContactsImpl;
import jspservlet.vo.Contacts;

public class DeleteServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 
		 HttpSession session = req.getSession();
		 Contacts contacts = new Contacts();
		 
		 contacts.setKey(Integer.parseInt(req.getParameter("key")));
		System.out.println(contacts.getContactsname());
		ContactsDAO dao = new ContactsImpl();
    	
	    	try {
	    		System.out.println("yunxingshanquanbu");
				dao.delete(contacts);
				res.sendRedirect("./delete.jsp");
			} catch (Exception e) {
				
				e.printStackTrace();
			  }
			
	 }
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	     throws IOException, ServletException{

	      }
	 }

