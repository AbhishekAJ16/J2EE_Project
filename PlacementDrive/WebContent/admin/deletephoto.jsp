<%@page import="java.io.File"%>
<%@page import="model.dao.HibernateUtil"%>
<%@page import="model.dao.HibernateViewUtil"%>
<%@page import="model.to.StudentPhoto"%>
<%@page import="operations.Validations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String message = "";
if(request.getParameter("photoid")!=null){
	String photoid = request.getParameter("photoid").trim();
	if(Validations.isEmpty(photoid)){
		message = "Please Provide Any Photo ID";
	}else if( Validations.isNumber(photoid)){
		int pid = Integer.parseInt(photoid);
		StudentPhoto record = HibernateViewUtil.getStudentPhoto(pid);
		if(record!=null){
			String path = "/stuphoto/" + record.getPhotoid() + "." + record.getPhotoextname();
			if(HibernateUtil.deleteRecord(record)){
				message = "Student Photo is Removed From Database";
				path = application.getRealPath(path);
				File file = new File(path);
				if(file.exists()){
					file.delete();
				}
			}else{
				message = "Photo does not removed due to " + HibernateUtil.getErrormessage();
			}
		}else{
			message = "There is No Photo For This ID";
		}
	}else{
		message = "Photo ID must be a Number";
	}
}else{
	message = "Not Enough Values Passed";
}
request.setAttribute("message", message);
RequestDispatcher rd = request.getRequestDispatcher("viewstudentphoto.jsp");
rd.forward(request,response);
%>