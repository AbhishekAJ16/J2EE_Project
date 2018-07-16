<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN"
	dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<title>Education Time | Full Width</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
<script type="text/javascript" src="js/calendarDateInput.js"></script>
</head>
<body id="top">
	<%@include file="header.jsp"%>
	<%
	Calendar cal = Calendar.getInstance();
	String datevalue = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
	String dob = request.getParameter("dob")!=null ? request.getParameter("dob") : datevalue;
	pageContext.setAttribute("dob",dob);
	%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<form method="post" action="insertstudent.do">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="name">Enter Student Name : </label></td>
						<td><input type="text" name="name" id="name"
							value="${param.name }" /></td>

					</tr>
					<tr>
						<td>Choose Date Of Birth :</td>
						<td>
						<script type="text/javascript">DateInput("dob",true,"YYYY-MM-DD",'${dob}')</script>
						</td>

					</tr>
					<tr>
						<td><label for="contactno">Enter Student Contact No :
						</label></td>
						<td><input type="text" name="contactno" id="contactno"
							value="${param.contactno}" /></td>

					</tr>
					<tr>
						<td><label for="gender" value="${param.gender}">Enter Student Gender : </label></td>
					<td>
						<input type="radio" name="gender" value="male" id="r1"/>
		                <label for="r1">male</label>
		                <input type="radio" name="gender" value="female" id="r2"/>
		                <label for="r2">female</label>
		                </td>
					<tr>
						<td><label for="fathername">Enter Student Father Name
								: </label></td>
						<td><input type="text" name="fathername" id="fathername"
							value="${param.fathername }" /></td>

					</tr>
					<tr>
						<td><label for="sessionbeginyear">Enter Student
								Session Begin Year : </label></td>
						<td><input type="text" name="sessionbeginyear"
							id="sessionbeginyear" value="${param.sessionbeginyear}" /></td>

					</tr>
					<tr>
						<td><label for="sessionendyear">Enter Student Session
								End Year : </label></td>
						<td><input type="text" name="sessionendyear"
							id="sessionendyear" value="${param.sessionendyear}" /></td>

					</tr>
					<tr>
						<td><label for="currentpercentage">Enter Student
								Current Percentage : </label></td>
						<td><input type="text" name="currentpercentage"
							id="currentpercentage" value="${param.currentpercentage}" /></td>

					</tr>
					<tr>
						<td><label for="noofbacklog">Enter Student No Of
								Backlog : </label></td>
						<td><input type="text" name="noofbacklog" id="noofbacklog"
							value="${param.noofbacklog}" /></td>

					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Add Student Details" /></td>
					</tr>
				</table>
			</form>
	       <h1 align="center">${message }</h1>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	</body>
	</html>