package controller.admin.insert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.to.BranchInfo;
import model.to.CompanyInfo;
import operations.Validations;

/**
 * Servlet implementation class InsertCompanyInfo
 */
@WebServlet("/admin/insertcompany.do")
public class InsertCompanyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyname = request.getParameter("companyname");
		String description = request.getParameter("description");
		String message="";
		if(companyname!=null && description!=null){
			companyname=companyname.trim();
			description=description.trim();
			if(Validations.isEmpty(companyname) || Validations.isEmpty(description)){
			message="please fill all boxes";	
			}else {
					CompanyInfo record = new CompanyInfo();
					record.setCompanyname(companyname);
					record.setDescription(description);
					
					if(HibernateUtil.insertRecord(record)){
						message = "Company Record Is Added In System Database";
					}else{
						message="Error : " + HibernateUtil.getErrormessage();
					}
				}}else{
			message+="Not Enough Parameter Supplied";
		}
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
		rd.forward(request,response);
	}

}


