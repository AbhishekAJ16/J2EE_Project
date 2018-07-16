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
			<h1 align="center">Branch Details</h1>
			<%
				if(request.getAttribute("message")!=null){
					out.println("<h1 align=\"center\">" + request.getAttribute("message") + "</h1>");
				}
			%>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">
				<tr>
					<th align="left">Branch ID</th>
					<th align="left">Branch Name</th>
					<th align="left">Description</th>
					<th align="left">Total Sem</th>
					<th colspan="2" align="center">Operations</th>
				</tr>
				<%
				String branchid = request.getParameter("branchid1")!=null ? request.getParameter("branchid1"):"";
					if (request.getAttribute("branches") != null) {
						List<BranchInfo> branches = (List<BranchInfo>) request.getAttribute("branches");
						for (BranchInfo bi : branches) {
							out.println("<tr>");
							if(branchid.equals(bi.getBranchid())){
								out.println("<form method=\"post\" action=\"updatebranch.do\">");
								out.println("<td><input type=\"text\" readonly name=\"branchid\" value=\"" + bi.getBranchid() + "\"></td>");
								out.println("<td><input type=\"text\" name=\"branchname\" value=\"" + bi.getBranchname() + "\"></td>");
								out.println("<td><input type=\"text\" name=\"description\" value=\"" + bi.getDescription() + "\"></td>");
								out.println("<td><input type=\"text\" name=\"totalsem\" value=\"" + bi.getTotalsem() + "\"></td>");
								out.println("<td colspan=\"2\" align=\"center\"> <input type=\"submit\" value=\"Update This Record\"></td>");
								out.println("</form>");
							}else{
							out.println("<td>" + bi.getBranchid() + "</td>");
							out.println("<td>" + bi.getBranchname() + "</td>");
							out.println("<td>" + bi.getDescription() + "</td>");
							out.println("<td>" + bi.getTotalsem() + "</td>");
							String bvalue = URLEncoder.encode(bi.getBranchid());
							out.println(
									"<td><a onclick=\"return confirm('Are You SureTo Delete This Record?')\" href=\"deletebranch.do?branchid="
											+ bvalue + "\">Delete This Record</a> </td>");
							
							out.println(
									"<td><a href=\"viewbranch.do?branchid1="
											+ bvalue + "\">Edit This Record</a> </td>");
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