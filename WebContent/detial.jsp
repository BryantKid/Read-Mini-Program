<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.util.ArrayList,jspservlet.vo.Contacts"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% ArrayList<Contacts> list = (ArrayList<Contacts>)session.getAttribute("list");
	 String name;
	 String phonenumber;
     int key;
    %>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detial.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
   #header {
    background-image:url('titlePicture.jpg');
    background-size:100%;
    height:150px;
    text-align:center;
    padding:5px;
}
   #section {
    text-align:center;
     padding:50px 50px;
     height:800px;
     background-color:MistyRose;	 
}
   </style>
  </head>
  
  <body>
     <div id="header"> 
    	<h1><a href="index.jsp">HOME</a></h1>
     </div>
     <div id="section">
            <%for(int i=0;i<list.size();i++){
    Contacts ct =list.get(i);
    name = ct.getContactsname();
    phonenumber = ct.getPhonenumber();
    key = ct.getKey();
    %>
    
             <form method="get" action="./modify">
                <input name="key" type="hidden" id="hiddenField2" value="<%=key %>" />
                 Name:<input type="text" name="name" value="<%=name %>"><br>
                 Phone Number:<input type="text" name="phonenumber" value="<%=phonenumber %>"><br><br><br>
                  <input type="submit"  value="Modify" />
                </form>
                <form method="get" action="./delete">
                <input name="key" type="hidden" id="hiddenField" value="<%=key %>" />
                 <input type="submit"  value="Delete" />
                </form>
                 
       <%} %>
       </div>
  </body>
</html>
