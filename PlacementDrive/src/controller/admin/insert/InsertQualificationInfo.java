package controller.admin.insert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.to.CompanyInfo;
import model.to.QualificationInfo;
import operations.Validations;

/**
 * Servlet implementation class InsertQualificationInfo
 */
@WebServlet("/admin/insertqualification.do")
public class InsertQualificationInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qualificationname = request.getParameter("qualificationname");
		String description = request.getParameter("description");
		String message="";
		if(qualificationname!=null && description!=null){
			qualificationname=qualificationname.trim();
			description=description.trim();
			if(Validations.isEmpty(qualificationname) || Validations.isEmpty(description)){
			message="please fill all boxes";	
			}else {
				QualificationInfo record = new QualificationInfo();
					record.setQualificationname(qualificationname);
					record.setDescription(description);
					
					if(HibernateUtil.insertRecord(record)){
						message = "Qualification Record Is Added In System Database";
					}else{
						message="Error : " + HibernateUtil.getErrormessage();
					}
				}}else{
			message+="Not Enough Parameter Supplied";
		}
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("addqualification.jsp");
		rd.forward(request,response);
	}


}
