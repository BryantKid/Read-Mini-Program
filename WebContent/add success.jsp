<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add success.jsp' starting page</title>
    
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
       
    <form action="./all" method="get"><input type="hidden" name="all" value="@@@">
    <div id="header">
    	<h1><a href="index.jsp">HOME</a></h1>
    </div>
    <div id="section">
    Add linkman successfully !<br><br><br>
    <input type="submit" value="view all linkman">
    </div>
    </form><br>
  </body>
</html>
