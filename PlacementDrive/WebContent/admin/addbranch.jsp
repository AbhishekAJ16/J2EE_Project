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
</head>
<body id="top">
	<%@include file="header.jsp"%>
	<div class="wrapper row4">
		<div id="container" class="clear">

			<%
				String branchid = request.getParameter("branchid") != null ? request.getParameter("branchid") : "";
				String branchname = request.getParameter("branchname") != null ? request.getParameter("branchname") : "";
				String description = request.getParameter("description") != null ? request.getParameter("description") : "";
				String totalsem = request.getParameter("totalsem") != null ? request.getParameter("totalsem") : "";
			%>
			<form method="post" action="insertbranch.do">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="branchid">Enter Branch Id : </label></td>
						<td><input type="text" name="branchid" id="branchid"
							value="<%=branchid%>" /></td>

					</tr>
					<tr>
						<td><label for="branchname">Enter Branch Name : </label></td>
						<td><input type="text" name="branchname" id="branchname"
							value="<%=branchname%>" /></td>
					</tr>

					<tr>
						<td><label for="description">Enter Description : </label></td>
						<td><input type="text" name="description" id="description"
							value="<%=description%>" /></td>

					</tr>
					<tr>
						<td><label for="totalsem">Enter Total Sem : </label></td>
						<td><input type="text" name="totalsem" id="totalsem"
							value="<%=totalsem%>" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Add Branch Details" /></td>
					</tr>
				</table>
			</form>
			<%
				if (request.getAttribute("message") != null) {
					out.println("<h1 align=\"center\">" + request.getAttribute("message") + "</h1>");
				}
			%>
		</div>
	</div>
	<%@include file="footer.jsp"%>