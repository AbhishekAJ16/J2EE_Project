<%@page import="model.dao.HibernateUtil"%>
<%@page import="model.to.LoginInfo"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Placement Website</title>
</head>
<body style="background-image:url('a2.jpg');background-size:100% 500%;background-repeat:no-repeat; ">
<h1 style="color:white;">WELCOME IN JMIT PLACEMENT WEBSITE</h1><voideo width="1500" height="500" controls style="opacity:1.0">
<source src="msd.mp4"  type="video/mp4">
</video>

<h1> <a href="login.jsp"  style="color:white;">Click Here To Login </a></h1>

<%--

LoginInfo login=new LoginInfo();
login.setUsername("ram");
login.setPassword("ram");
login.setEmailid("aj16abhishekaggarwal@gmail.com");
login.setRolename("user");
login.setSq("what is your name2?");
login.setSans("ram");
HibernateUtil.insertRecord(login);

--%>
</body>
</html>