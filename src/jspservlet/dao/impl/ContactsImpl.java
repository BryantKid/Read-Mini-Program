package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.dao.ContactsDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Contacts;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ContactsImpl implements ContactsDAO {
	public static JSONArray jsonArray;
	public JSONObject jsonObject;
	
	public void add(Contacts contacts) throws Exception{
		   PreparedStatement pstmt = null;
		   DBConnect dbc = null;
		   String sql = "INSERT INTO infor (name,phonenumber) VALUES (?,?);";
		   try{
			   
			   dbc = new DBConnect();
			   pstmt = dbc.getConnection().prepareStatement(sql);
			   pstmt.setString(1, contacts.getContactsname());
			   pstmt.setString(2, contacts.getPhonenumber());			  
			   pstmt.executeUpdate();
			   
		   } catch(SQLException e){
			   System.out.println(e.getMessage());
		   } finally{
			   
			   dbc.close();
		   }
		 
	   }
	
	
	
	public void delete(Contacts contacts) throws Exception {
		
		
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        
        try{        
            dbc = new DBConnect() ;   

             
            String sql= "delete from infor where pk='"+contacts.getKey()+"'";
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
    
            
            pstmt.executeUpdate();
             pstmt.close() ; 
           
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            dbc.close() ;   
        }   
}
	


	public ArrayList<Contacts> queryByContactsNature(String i ,Contacts contacts) throws Exception {
		ArrayList<Contacts> list = new ArrayList<Contacts> () ;
		
		if(i=="0"){
			jsonArray =new JSONArray();
			jsonObject =new JSONObject();
			String sql = "select * from infor where name like ? or phonenumber like ?";
	        PreparedStatement pstmt = null ;   
	        DBConnect dbc = null;   
	  
	        try{   
	            dbc = new DBConnect() ;   
	            pstmt = dbc.getConnection().prepareStatement(sql) ; 
	            pstmt.setString(1,'%'+contacts.getNature()+'%') ; 
	            pstmt.setString(2,'%'+contacts.getNature()+'%') ; 
	            ResultSet rs = pstmt.executeQuery();
	            while(rs.next()){  
	            	
	            	jsonObject.put("name",rs.getString("name"));
	            	jsonObject.put("phonenumber",rs.getString("phonenumber"));
	            	//jsonObject.put("pk",rs.getString("pk"));
	            	
	            	jsonArray.add(jsonObject);
	            }   
	            rs.close() ; 
	            pstmt.close() ;   
	        }catch (SQLException e){   
	            System.out.println(e.getMessage());   
	        }finally{   
	            dbc.close() ;   
	        }  
	        
		
		}else if(i=="1"){
			String sql = "select * from infor where pk = ?";
			
	        PreparedStatement pstmt = null ;   
	        DBConnect dbc = null;   
	        try{   
	            dbc = new DBConnect() ;   
	            pstmt = dbc.getConnection().prepareStatement(sql) ; 
	            pstmt.setInt(1,contacts.getKey()) ; 
	            ResultSet rs = pstmt.executeQuery();
	            System.out.println(contacts.getKey());
	            while(rs.next()){  
	            	
	            	Contacts ct = new Contacts();
	            	ct.setContactsname(rs.getString("name"));
	            	ct.setPhonenumber(rs.getString("phonenumber"));
	            	ct.setKey(Integer.parseInt(rs.getString("pk")));
	            	list.add(ct);
	            }   
	            rs.close() ; 
	            pstmt.close() ;   
	        }catch (SQLException e){   
	            System.out.println(e.getMessage());   
	        }finally{   
	            dbc.close() ;   
	        }  }
			
			
			else {
				String sql = "select * from infor";
				
		        PreparedStatement pstmt = null ;   
		        DBConnect dbc = null;   
		        try{   
		            dbc = new DBConnect() ;   
		            pstmt = dbc.getConnection().prepareStatement(sql) ; 
		            ResultSet rs = pstmt.executeQuery();
		            while(rs.next()){  
		            	
		            	Contacts ct = new Contacts();
		            	ct.setContactsname(rs.getString("name"));
		            	ct.setPhonenumber(rs.getString("phonenumber"));
		            	ct.setKey(Integer.parseInt(rs.getString("pk")));
		            	list.add(ct);
		            }   
		            rs.close() ; 
		            pstmt.close() ;   
		        }catch (SQLException e){   
		            System.out.println(e.getMessage());   
		        }finally{   
		            dbc.close() ;   
		        }  }
			return list; 
			}
	
	
	public void modify(Contacts contacts) throws Exception {
		
		
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null;  
        
        try{   
            dbc = new DBConnect() ;   
         
             
            System.out.println(contacts.getContactsname());
            System.out.println(contacts.getPhonenumber());
            String sql1= "UPDATE infor SET name = '"+contacts.getContactsname()+"' , phonenumber = '"+contacts.getPhonenumber()+"' where pk='"+contacts.getKey()+"'";
            pstmt = dbc.getConnection().prepareStatement(sql1) ; 
            
            pstmt.executeUpdate();
             pstmt.close() ; 
           
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            dbc.close() ;   
        }   
}
}



