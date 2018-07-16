<%@page import="java.net.URLEncoder"%>
<%@page import="model.to.BranchInfo"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN"
	dir="ltr">
<script type="text/javascript">
	function check(frm) {
		var allchecks = document.getElementsByName("studentids");
		if (allchecks.length > 0) {
			var count = 0;
			var studids = "";
			for (i = 0; i < allchecks.length; i++) {
				if (allchecks[i].checked) {
					studids += allchecks[i].value + ",";
					count++;
				}
			}
			if (count == 0) {
				alert("Nothing is selected");
			} else {
				if (count == 1) {
					var result = confirm("Are you sure you want to delete this record? ");
				} else {
					var result = confirm("Are you sure you want to delete these records? ");
				}
				if (result) {
					studids = studids.substring(0, studids.length - 1);
					document.getElementById("studids").value = studids;
					frm.submit();
				}
			}
		}
	}
</script>
<head profile="http://gmpg.org/xfn/11">
<title>Education Time | Full Width</title>
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="reveal.css" />
<script type="text/javascript" src="jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="jquery.reveal.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="imagetoolbar" content="no" />
<link rel="stylesheet" href="styles/layout.css" type="text/css" />
<script type="text/javascript">
	function setvalues(sqid, studentid, qualificationid, passingyear,
			percentage, universityboard) {
		$("#sqid").val(sqid);
		$("#studentid").val(studentid);
		$("#qualificationid").val(qualificationid);
		$("#passingyear").val(passingyear);
		$("#percentage").val(percentage);
		$("#universityboard").val(universityboard);
	}
</script>
</head>
<body id="top">
	<%@include file="header.jsp"%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<h1 align="center">Student Qualification Details</h1>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">
				<tr>
					<th align="left">Select</th>
					<th align="left">SQ ID</th>
					<th align="left">Student ID</th>
					<th align="left">Qualification ID</th>
					<th align="left">Passing Year</th>
					<th align="left">Percentage
						<th align="left">University Board</th>
				<c:choose>
					<c:when test="${studentqual!=null }">
						<c:forEach var="item" items="${studentqual }">
							<tr>
								<td><input type="checkbox" name="studentids"
									value=" ${item.sqid } " /></td>
								<td>${item.sqid }</td>
								<td>${item.student.studentid }</td>
								<td>${item.qualification.qualificationid }</td>
								<td>${item.passingyear }</td>
								<td>${item.percentage }</td>
								<td>${item.universityboard }</td>
								<td style="color: #3498db";><a href="#"
									data-reveal-id="myModal"
									onclick="setvalues('${item.sqid}','${item.student.studentid}','${item.qualification.qualificationid}','${item.passingyear}','${item.percentage}','${item.universityboard}')"></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="8" align="center">There is no record.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
			<br /> <br /> <br />
			<table>
				<c:if test="${studentqual!=null }">
					<tr>
						<td width="1200px" align="center">
							<form method="post" action="deletestudentqual.do">
								<input type="hidden" name="studids" id="studids" /> <input
									type="button" value="Delete selected records"
									onclick="check(this.form)" />
							</form>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>

	
			<%@include file="footer.jsp"%>
</body>
</html>