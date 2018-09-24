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

public class DisplayServlet extends HttpServlet {
	 public void doGet(HttpServletRequest req, HttpServletResponse res)
			    throws IOException, ServletException{
		 Contacts contacts = new Contacts();
		 contacts.setKey(Integer.parseInt(req.getParameter("key")));
		 
		 ContactsDAO dao = new ContactsImpl();   
	     ArrayList<Contacts> flag = null;
	     try {
	    	 flag = dao.queryByContactsNature("1",contacts);
			} catch (Exception e) {
				e.printStackTrace();
		} 
		 if(flag != null){   
			 HttpSession session=req.getSession();   
	         session.setAttribute("list", flag);   
	         res.sendRedirect("./detial.jsp");
	        } else {   
	         res.sendRedirect("./search failed.jsp");
	        }
			 }
	 
	/*	 Contacts contacts = new Contacts();
		 JSONArray jsonArray =new JSONArray();
		 contacts.setKey(Integer.parseInt(req.getParameter("key"))); 
		 ContactsDAO dao = new ContactsImpl();
		 
		
		 try {
				dao.queryByContactsNature("1",contacts);
				jsonArray =ContactsImpl.jsonArray;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 res.setContentType("text/html");
			 PrintWriter out=res.getWriter();
			 out.println(jsonArray);
			 
		 }
	*/
			
			 public void doPost(HttpServletRequest req, HttpServletResponse res)
			    throws IOException, ServletException{

			 }
}
