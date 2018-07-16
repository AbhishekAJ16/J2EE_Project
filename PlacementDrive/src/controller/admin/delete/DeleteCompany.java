package controller.admin.delete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.CompanyInfo;
import model.to.QualificationInfo;
import operations.Validations;

/**
 * Servlet implementation class DeleteCompany
 */
@WebServlet("/admin/deletecompany.do")
public class DeleteCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyid = request.getParameter("companyid");
		String message = "";
		if (companyid != null) {
			companyid = companyid.trim();
			if (Validations.isEmpty(companyid)) {
				message = "Please Provide Some Value For CompanyId";
			} else {
				CompanyInfo record = HibernateViewUtil.getCompany(Integer.parseInt(companyid));
                if(record==null){
                	message = "There Is No Record For This Company ID";
                }else
                	if(HibernateUtil.deleteRecord(record)){
                		message = "Record Is Remove From System Database";
                	}else{
                		message = "Failure Due To : " + HibernateUtil.getErrormessage();
                	}
                
			}
		} else {
			message = "Not Enough Value Supplied";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewcompany.do");
		rd.forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
