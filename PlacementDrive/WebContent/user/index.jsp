<%
if(session.getAttribute("user")==null){
	response.sendRedirect("../login.jsp");
	
}
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires",0);
response.setHeader("Cache-Control","no-store");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("lastlogin")!=null){
	out.println("<h1> YOUR LAST VISIT IS ON : " + session.getAttribute("lastlogin") + "</h1>");
}else{
	out.println("<h1>WELCOME!!! FOR THE FIRST TIME VISIT IN OUR WEB SITE</h1>");
	
}

%>
<h1><a href="signout.jsp">Sign Out</a></h1>
</body>
</html>