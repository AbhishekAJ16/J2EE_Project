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
		String drivedate = request.getParameter("drivedate") != null
				? request.getParameter("drivedate")
				: datevalue;
		pageContext.setAttribute("drivedate", drivedate);
	%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<form method="post" action="assignplacementinfo.do">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="companyid">Choose Any Company : </label></td>
					<td>
					<select name="companyid" id="companyid">
					<c:forEach var="item" items="${companies }">
					<option value="${item.companyid }">${item.companyid}[${item.companyname}] </option>
					</c:forEach>
					</select>
					</td>
					</tr>
					<tr>
							<td>Choose Drive Date :</td>
						<td><script type="text/javascript">
							DateInput("drivedate", true, "YYYY-MM-DD", '${drivedate}')
						</script>
						</td>

					</tr>
					
					<tr>
						<td><label for="jobdescription">Enter Job Description :
						</label></td>
						<td><input type="text" name="jobdescription" id="jobdescription"
							value="${param.jobdescription}" /></td>

					</tr>
					<tr>
						<td><label for="packages">Enter Package :
						</label></td>
						<td><input type="text" name="packages" id="packages"
							value="${param.packages}" /></td>

					</tr>					

	<tr>
						<td><label for="allowedbacklog">Enter No of Allowed Backlogs :
						</label></td>
						<td><input type="text" name="allowedbacklog" id="allowedbacklog"
							value="${param.allowedbacklog}" /></td>

					</tr>

					<tr>
					<td align="center">
					<input type="submit" value="add Placement Info"></input>
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