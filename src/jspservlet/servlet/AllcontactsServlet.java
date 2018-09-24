package jspservlet.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.ContactsDAO;
import jspservlet.dao.impl.ContactsImpl;
import jspservlet.vo.Contacts;

public class AllcontactsServlet extends HttpServlet {
	
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{
		 Contacts contacts = new Contacts();

		 ContactsDAO dao = new ContactsImpl();   
	     ArrayList<Contacts> flag = null;
	     try {
				flag = dao.queryByContactsNature("2",contacts);
			} catch (Exception e) {
				e.printStackTrace();
		} 
		 if(flag != null&&flag.size()!=0){   
			 HttpSession session=req.getSession();   
	         session.setAttribute("list", flag);   
	         res.sendRedirect("./allcontacts.jsp");
	        } else {   
	         res.sendRedirect("./search fail.jsp");
	        }
	 }
	
	 public void doPost(HttpServletRequest req, HttpServletResponse res)
	    throws IOException, ServletException{

	 }
}
