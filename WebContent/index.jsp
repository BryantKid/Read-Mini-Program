<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
#welcome,#wish{
	font-size:35px;
	color:Plum;
	text-align:center;
}
#section {
    background-color:#eeeeee;
    height:100px;
    width:200px;
    float:left;
    padding:5px;	      
}
#main{
	float:left;
	width:1200px;
	height:200px;
    float:left;
     text-align:center;
}

#footer {
    height:100px;
    background-color:MistyRose;   
    clear:both;
    text-align:center;
   padding:5px;	 	 
}

   </style>
   
   
   <script type="text/javascript">
function showinfor(str)
{
var xmlhttp;    
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    var jsonArray=eval("("+xmlhttp.responseText+")");
   
    var string ="<table border='1' align='center'>"
   	if(jsonArray.length!=0){
   		var str="<tr>"+"<td>"+"Name"+"</td>"+"<td>"+"phone Number"+"</td>"+"</tr>";
   	   	string+=str;
   	}
    for (var i=0;i<jsonArray.length;i++){
    string +="<tr>";
     for(var j in jsonArray[i]){
       string +="<td>";
       string +=jsonArray[i][j];
       string +="</td>";
     }
    string +="</tr>";
    }
    string +="</table>"
    
    document.getElementById("txtHint").innerHTML=string;
    }
  }
xmlhttp.open("GET","./search?nature="+str,true);
xmlhttp.send();
}
</script>
  </head>
  
  <body>

    <div id="header">
    <br>
    <h1><a href="index.jsp">HOME</a></h1>
    <br>
    <br>
    </div>
    
	<div id="section">
	<br>
    <form action="add.jsp" method="get">
    <input type="submit" value="Add New Contacts">
    </form>
    
    <form action="./all" method="get">
    <input type="submit" value="Veiw All Contacts ">
    </form><br>
     </div>
    <div id="main">
    <h1 id="welcome">Welcome to JiangChengling's Address Book<*\^-^/*></h1>
    <h2 id = "wish">Wish you happy everyday~</h2>
    </div>
    <form>
     <div id="footer">
     <p><--Enter anything to search--></p>
    Search:<input type="text" name="nature" onkeyup="showinfor(this.value)">
    </div>
    </form>
    <br>
    <div id="txtHint">infomation</div>
   
  </body>
</html>
