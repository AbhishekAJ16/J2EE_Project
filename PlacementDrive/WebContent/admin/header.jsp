
<%
	if (session.getAttribute("admin") == null) {
		response.sendRedirect("../login.jsp");

	}
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="wrapper row1">
	<div id="header" class="clear">
		<div class="fl_left">
			<h1>
				<a href="index.jsp">JMIT PLACEMENT DRIVE</a>
			</h1>
			<h2>PLACEMENT WEBSITE</h2>
		</div>
	</div>
</div>
<div class="wrapper row2">
	<div id="topnav">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="#">Branches</a>
				<ul>
					<li><a href="addbranch.jsp">Add New Branch</a></li>
					<li><a href="viewbranch.do">View Branches</a></li>
				</ul></li>
			<li><a href="#">Students</a>
				<ul>
					<li><a href="addstudents.jsp">Add New Student</a></li>
					<li><a href="viewstudents.do">View Students</a></li>
				</ul></li>
			<li><a href="#">Companies</a>
				<ul>
					<li><a href="addcompany.jsp">Add New Company</a></li>
					<li><a href="viewcompany.do">View companies</a></li>
				</ul></li>
			<li><a href="#">Qualification</a>
				<ul>
					<li><a href="addqualification.jsp">Add qualification</a></li>
					<li><a href="viewqualification.do">View qualification</a></li>
				</ul></li>
			<li><a href="#">Student Qualification</a>
				<ul>
					<li><a href="fetchstudentqualification.do">Add Student
							qualification</a></li>
					<li><a href="viewstudentqualification.do">View Student
							qualification</a></li>
				</ul></li>
			<li><a href="#">Placement Information</a>
				<ul>
					<li><a href="fetchplacementinfo.do">Add Placement
							Information</a></li>
					<li><a href="viewplacements.do">View Placement Information</a></li>
				</ul></li>

			<li><a href="#">Placement Criteria</a>
				<ul>
					<li><a href="fetchplacementcriteria.do">Add Placement
							Criteria</a></li>
					<li><a href="viewplacementcriteria.do">View Placement
							Criteria</a></li>
				</ul></li>

			<li><a href="#">Student Placed</a>
				<ul>
					<li><a href="fetchstudentplaced.do">Add Student Placed</a></li>
					<li><a href="viewstudentplaced.do">View Student Placed</a></li>
				</ul></li>

			<li><a href="#">Choose Photos</a>
				<ul>
					<li><a href="fetchstudentforphoto.do">Upload Student Photo</a></li>
					<li><a href="viewstudentphoto.jsp">View Student Photo</a></li>
				</ul></li>


			<li class="last"><a href="signout.jsp">Sign Out</a></li>
		</ul>
		<div class="clear"></div>
	</div>
</div>
