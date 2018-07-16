package controller.admin.update;

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
 * Servlet implementation class UpdateCompany
 */
@WebServlet("/admin/updatecompany.do")
public class UpdateCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String companyid = request.getParameter("companyid");
		String companyname = request.getParameter("companyname");
		String description = request.getParameter("description");
		String message = "";
		if (companyid != null && companyname != null && description != null) {
			companyid = companyid.trim();
			companyname = companyname.trim();
			description = description.trim();
			if (Validations.isEmpty(companyid) || Validations.isEmpty(companyname)
					|| Validations.isEmpty(description)) {
				message = "please fill all boxes";
			} else {
				CompanyInfo record = HibernateViewUtil.getCompany(Integer.parseInt(companyid));
				if (record != null) {
					record.setCompanyid(Integer.parseInt(companyid));
					record.setCompanyname(companyname);
					record.setDescription(description);
					if (HibernateUtil.updateRecord(record)) {
						message = "Branch Record Is Updated In System Database";
					} else {
						message = "Error : " + HibernateUtil.getErrormessage();
					}
				} else {
					message = "There Is No Record For Updation";
				}
			}
		} else {
			message += "Not Enough Parameter Supplied";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewcompany.do");
		rd.forward(request, response);

	}

}
