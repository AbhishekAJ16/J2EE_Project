<%@page import="model.to.QualificationInfo"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.to.BranchInfo"%>
<%@page import="java.util.List"%>
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
			<h1 align="center">Qualification Details</h1>
			<%
				if (request.getAttribute("message") != null) {
					out.println("<h1 align=\"center\">" + request.getAttribute("message") + "</h1>");
				}
			%>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">
				<tr>
					<th align="left">Qualification ID</th>
					<th align="left">Qualification Name</th>
					<th align="left">Description</th>
					<th colspan="2" align="center">Operations</th>
				</tr>
				<%
					String qualificationid = request.getParameter("qualification1") != null
							? request.getParameter("qualification1") : "";
					if (request.getAttribute("qualifications") != null) {
						List<QualificationInfo> qualifications = (List<QualificationInfo>) request
								.getAttribute("qualifications");
						for (QualificationInfo qi : qualifications) {
							out.println("<tr>");
							System.out.println(qi.getQualificationid() + "\t" + qualificationid);
							if (qualificationid.equals(String.valueOf(qi.getQualificationid()))) {
								out.println("<form method=\"post\" action=\"updatequalification.do\">");
								out.println("<td><input type=\"text\" readonly name=\"qualificationid\" value=\""
										+ qi.getQualificationid() + "\"></td>");
								out.println("<td><input type=\"text\" name=\"qualificationname\" value=\""
										+ qi.getQualificationname() + "\"></td>");
								out.println("<td><input type=\"text\" name=\"description\" value=\"" + qi.getDescription()
										+ "\"></td>");
								out.println(
										"<td colspan=\"2\" align=\"center\"> <input type=\"submit\" value=\"Update This Record\"></td>");
								out.println("</form>");
							} else {
								out.println("<td>" + qi.getQualificationid() + "</td>");
								out.println("<td>" + qi.getQualificationname() + "</td>");
								out.println("<td>" + qi.getDescription() + "</td>");
								String qvalue = URLEncoder.encode(String.valueOf(qi.getQualificationid()));
								out.println(
										"<td><a onclick=\"return confirm('Are You Sure To Delete This Record?')\" href=\"deletequalification.do?qualificationid="
												+ qvalue + "\">Delete This Record</a> </td>");

								out.println(
										"<td><a onclick=\"return confirm('Are You Sure To Delete This Record?')\" href=\"viewqualification.do?qualification1="
												+ qvalue + "\">Edit This Record</a> </td>");
							}
							out.println("<tr>");
						}
					} else {
						out.println("<tr>");
						out.println("<td colspan=\"6\" align=\"center\">there is no record </tr>");
						out.println("<tr>");
					}
				%>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>