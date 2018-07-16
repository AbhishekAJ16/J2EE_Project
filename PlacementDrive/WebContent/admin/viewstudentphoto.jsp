<%@page import="model.dao.HibernateViewUtil"%>
<%@page import="model.to.StudentPhoto"%>
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
			<h1 align="center">Student Photo Details</h1>
			<%
				if (request.getAttribute("message") != null) {
					out.println("<h1 align=\"center\">" + request.getAttribute("message") + "</h1>");
				}
			%>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">

				<%
					List<StudentPhoto> photos = HibernateViewUtil.getAllStudentPhoto();
					if (photos != null && photos.size() > 0) {
						int i = 0;
						for (StudentPhoto photo : photos) {
							if (i == 0) {
								out.println("<tr>");
							}
							out.println("<td>");
							String path = "../stuphoto/" + photo.getPhotoid() + "." + photo.getPhotoextname();
							out.println("<img src=\"" + path + "\" width=\"100px\" height=\"100px\"/><br/><br/>");
							out.println(photo.getStudent1().getStudentname() + "'s Photo<br/>");
							out.println(
									"<a onclick=\"return confirm('Are You Sure To Remove This Photo?')\" href=\"deletephoto.jsp?photoid="
											+ photo.getPhotoid() + "\">[ Delete This Photo ]</a><br/><br/>");
							out.println("<a href=\"downloadphoto.do?photoid=" + photo.getPhotoid()
									+ "\">[ Download This Photo ]</a>");
							out.println("</td>");
							i++;
							if (i == 3) {
								out.println("</tr>");
								i = 0;
							}
						}
						if (i != 0) {
							out.println("</tr>");
						}
					} else {
						out.println("<tr><td colspan=\"3\" align=\"center\">There is No Photo</td></tr>");
					}
				%>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>