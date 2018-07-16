<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		String datevalue = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DATE);
		String startdate = request.getParameter("startdate") != null
				? request.getParameter("startdate")
				: datevalue;
		pageContext.setAttribute("startdate", startdate);
	%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<form method="post" action="assignbranch.do">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="studentid">Choose Any Student : </label></td>
					<td>
					<select name="studentid" id="studentid">
					<c:forEach var="item" items="${students }">
					<option value="${item.studentid }">${item.studentname} </option>
					</c:forEach>
					</select>
					</td>
					</tr>
					<tr>
					<tr>
						<td><label for="branchid">Choose Any Branch : </label></td>
					<td>
					<select name="branchid" id="branchid">
					<c:forEach var="item" items="${branches }">
					<option value="${item.branchid }">${item.branchname } [${item.totalsem}] [${item.description}]</option>
					</c:forEach>
					</select>
					</td>
					</tr>
						<td>Choose Branch Start Date :</td>
						<td><script type="text/javascript">
							DateInput("startdate", true, "YYYY-MM-DD", '${startdate}')
						</script>
						</td>

					</tr>
									</table>
			</form>
			<h1 align="center">${message }</h1>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>