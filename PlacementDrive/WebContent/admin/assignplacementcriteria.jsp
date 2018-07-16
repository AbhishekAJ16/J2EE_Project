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
	%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<form method="post" action="assignplacementcriteria.do">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="placementid">Choose Any Placement Id : </label></td>
					<td>
					<select name="placementid" id="placementid">
					<c:forEach var="item" items="${placements }">
					<option value="${item.placementid }">${item.placementid}[${item.packages}]</option>
					</c:forEach>
					</select>
					</td>
					</tr>
                    <tr>
						<td><label for="qualificationid">Choose Any Qualification : </label></td>
					<td>
					<select name="qualificationid" id="qualificationid">
					<c:forEach var="item" items="${qualifications }">
					<option value="${item.qualificationid }">${item.qualificationid}[${item.qualificationname}]</option>
					</c:forEach>
					</select>
					</td>
					</tr>

					<tr>
						<td><label for="percentage">Enter Student Percentage :
						</label></td>
						<td><input type="text" name="percentage" id="percentage"
							value="${param.percentage}" /></td>

					</tr>
					<tr>
					<td align="center">
					<input type="submit" value="add placement criteria>"></input>
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