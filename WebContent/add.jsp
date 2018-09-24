<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Add.jsp' starting page</title>
  
	<style>
     #header {
    background-image:url('titlePicture.jpg');
    background-size:100%;
    text-align:center;
    height:150px;
    padding:5px;
}
#section {
    height:300px;
    background-color:MistyRose;   
    clear:both;
    text-align:center;
   padding:5px;	 	 
}

  
   </style>

  </head>
  
  <body>
    
    <form action="./add" method="get"> 
     
    <div id="header">
    <br>
    	<h1><a href="index.jsp">HOME</a></h1>
    <br>
    <br>
    </div>
    
    <div id="section">
    <br>
    <br>
    <p><--Add New Contents--></p>
    <br>
    
    Name:<input type="text" name="name" value="Please enter name."><br><br>
    Phone Number:<input type="text" name="phonenumber" value="Enter phone number"><br><br>
    <input type="submit" value="ADD">
    </div>
    </form><br>
  </body>
</html>
