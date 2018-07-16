<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="wrapper row4">
		<div id="container" class="clear">
			<form method="post" action="uploadstudentphoto.do"
				enctype="multipart/form-data">
				<table cellpadding="10" cellspacing="10" align="center">
					<tr>
						<td><label for="studentid">Choose Any Student : </label></td>
						<td><select name="studentid" id="studentid">
						<option value="">Choose Any Student</option>
								<c:forEach var="item" items="${students }">
									<c:choose>
										<c:when test="${param.studentid == item.studentid }">
										</c:when>
										<c:otherwise>
											<option value="${item.studentid }"selected>${item.studentname}
										</c:otherwise>

									</c:choose>

									</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td><label for="photo">Choose Any Photo : </label></td>
						<td><input type="file" name="photo" id="photo" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Upload Photo For Student" /></td>
					</tr>
				</table>
			</form>
			<h1 align="center">${message }</h1>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>