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
		var allchecks = document.getElementsByName("placeid");
		if (allchecks.length > 0) {
			count = 0;
			var placementids = "";
			for (i = 0; i < allchecks.length; i++) {
				if (allchecks[i].checked) {
					placementids += allchecks[i].value + ",";
				    count++;
				}
			}
			if(count==0){
				alert("Nothing Is Selected");
			}else{
				var result = confirm("Are You Sure To Remove This Record?");
				if(result){
					placementids = placementids.substring(0,placementids.length-1);
                    //alert(placementids);
                    document.getElementById("placementids").value = placementids;
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
			<h1 align="center">Placement Details</h1>
			<h1 align="center">${message }</h1>
			<table cellpadding="10" align="center" border="1" rules="all"
				cellspacing="10">
				<tr>
					<th>Select</th>
					<th align="left">Placement Id</th>
					<th align="left">Drive Date</th>
					<th align="left">Job Description</th>
					<th align="left">Package</th>
					<th align="left">Allowed Backlogs</th>
					</tr>
				<c:choose>
					<c:when test="${placements!=null }">
						<c:forEach var="item" items="${placements}">
							<tr>
								<td><input type="checkbox" name="placeid"
									value="${item.placementid}" /></td>
								<td>${item.placementid}</td>
								<td>${item.drivedate}</td>
								<td>${item.jobdescription}</td>
								<td>${item.packages}</td>
								<td>${item.allowedbacklog}</td>
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
						<form method="post" action="deleteplacements.do">
							<input type="hidden" name="placementids" id="placementids" /> <input
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