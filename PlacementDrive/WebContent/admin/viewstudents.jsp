<%@page import="java.net.URLEncoder"%>
<%@page import="model.to.BranchInfo"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript">
	function check(frm) {
		var allchecks = document.getElementsByName("studid");
		if (allchecks.length > 0) {
			count = 0;
			var studentids = "";
			for (i = 0; i < allchecks.length; i++) {
				if (allchecks[i].checked) {
					studentids += allchecks[i].value + ",";
				    count++;
				}
			}
			if(count==0){
				alert("Nothing Is Selected");
			}else{
				var result = confirm("Are You Sure To Remove This Record?");
				if(result){
					studentids = studentids.substring(0,studentids.length-1);
                    //alert(studentids);
                    document.getElementById("studentids").value = studentids;
                    frm.submit();
				}
			}
		
		}
	}
</script>
</head>
<body id="top">
	<%@include file="header.jsp"%>
	<div class="wrapper row4">
		<div id="container" class="clear">
			<h1 align="center">Student Details</h1>
			<h1 align="center">${message }</h1>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">
				<tr>
					<th>Select</th>
					<th align="left">Student Id</th>
					<th align="left">Student Name</th>
					<th align="left">Date Of Birth</th>
					<th align="left">Contact No</th>
					<th align="left">Gender</th>
					<th align="left">Father Name</th>
					<th align="left">Session Begin Year</th>
					<th align="left">Session End Year</th>
					<th align="left">Current Percentage</th>
					<th align="left">No Of Backlogs</th>
				</tr>
				<c:choose>
					<c:when test="${students!=null }">
						<c:forEach var="item" items="${students}">
							<tr>
								<td><input type="checkbox" name="studid"
									value="${item.studentid}" /></td>
								<td>${item.studentid}</td>
								<td>${item.studentname}</td>
								<td>${item.dob}</td>
								<td>${item.contactno}</td>
								<td>${item.gender}</td>
								<td>${item.fathername}</td>
								<td>${item.sessionbeginyear}</td>
								<td>${item.sessionendyear}</td>
								<td>${item.currentpercentage}</td>
								<td>${item.noofbacklog}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="11" align="center">There Is No Record</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr>
					<td colspan="11" align="center">
						<form method="post" action="deletestudents.do">
							<input type="hidden" name="studentids" id="studentids" /> <input
								type="button" value="Delete Selected Records"
								onclick="check(this.form)" />
						</form>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>