package controller.admin.insert;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class InsertStudentInfo
 */
@WebServlet("/admin/insertstudent.do")
public class InsertStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String contactno = request.getParameter("contactno");
	String dob = request.getParameter("dob");
	String gender = request.getParameter("gender");
	String fathername = request.getParameter("fathername");
	String sessionbeginyear = request.getParameter("sessionbeginyear");
	String sessionendyear = request.getParameter("sessionendyear");
	String currentpercentage= request.getParameter("currentpercentage");
	String noofbacklog = request.getParameter("noofbacklog");
	String message="";
	  if(name!=null && contactno!=null && dob!=null && gender!=null && fathername!=null && sessionbeginyear!=null && sessionendyear!=null && currentpercentage!=null && noofbacklog!=null)
	{
		name=name.trim();
		contactno=contactno.trim();
		dob=dob.trim();
		gender=gender.trim();
		fathername=fathername.trim();
		sessionbeginyear=sessionbeginyear.trim();
		sessionendyear=sessionendyear.trim();
		currentpercentage=currentpercentage.trim();
		noofbacklog=noofbacklog.trim();
		if(Validations.isEmpty(name) || Validations.isEmpty(contactno) || Validations.isEmpty(dob) || Validations.isEmpty(gender) || Validations.isEmpty(fathername) || Validations.isEmpty(sessionbeginyear) || Validations.isEmpty(sessionendyear) || Validations.isEmpty(currentpercentage) || Validations.isEmpty(noofbacklog) )
		  {
			message="Please Fill All Boxes";
		  }else if(Validations.validContactNo(contactno))
			       {
			if(Validations.validDate(dob))
			           {
				Date dateofbirth = Date.valueOf(dob);
				StudentInfo record = new StudentInfo();
				record.setContactno(contactno);
				record.setDob(dateofbirth);
				record.setCurrentpercentage(Float.parseFloat(currentpercentage));
				record.setFathername(fathername);
				record.setGender(gender);
				record.setNoofbacklog(Integer.parseInt(noofbacklog));
				record.setSessionbeginyear(Integer.parseInt(sessionbeginyear));
				record.setSessionendyear(Integer.parseInt(sessionendyear));
				record.setStudentname(name);
				if(HibernateUtil.insertRecord(record)){
                message = "Record Is Added In System Database";					
				}else{
					message="Insertion Failure Due To : " + HibernateUtil.getErrormessage();
				}
				       }else{
				        message="Invalid Date Of Birth";
				            }        
				       }else{
		                message = "Invalid Contact No";
				         }
	   }  else{   
		   message = "Not Enough Values Supplied";
	        }
    request.setAttribute("message",message);
	RequestDispatcher rd = request.getRequestDispatcher("addstudents.jsp");
	rd.forward(request,response);
}
}
