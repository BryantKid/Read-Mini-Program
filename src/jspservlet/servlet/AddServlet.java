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

public class AddServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{
		Contacts contacts = new Contacts();
		contacts.setContactsname(req.getParameter("name"));
		contacts.setPhonenumber(req.getParameter("phonenumber"));
		ContactsDAO dao = new ContactsImpl();		
			HttpSession session = req.getSession();
			session.setAttribute("name",contacts.getContactsname());
			try {
				dao.add(contacts);
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			res.sendRedirect("./add success.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException{

		}
		
	}