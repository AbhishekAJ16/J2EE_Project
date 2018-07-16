
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<title>Education Time | Full Width</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
<style>
#container .clear{
height:500%;
}
</style>
</head>
<body id="top">
<%@include file="header.jsp" %>
<div class="wrapper row4">
  <div id="container" class="clear"style="width:100%;overflow:visible;background-color:black;">
  <h1 style="overflow: visible;"> WELCOME ADMIN</h1>
  <%
if(session.getAttribute("lastlogin")!=null){
	out.println("<h1> YOUR LAST VISIT : " + session.getAttribute("lastlogin") + "</h1>");
}else{
	out.println("<h1>WELCOME!!! FOR THE FIRST TIME VISIT IN OUR WEB SITE</h1>");
	
}
  %>
  
  </div>
  <img src="j2.jpg" alt="sorry" height="550px" width="1350px"/>
</div>
<%@include file="footer.jsp" %>
</body>
</html>