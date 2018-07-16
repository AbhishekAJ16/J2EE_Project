package controller.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateViewUtil;
import model.to.CompanyInfo;
import model.to.QualificationInfo;

/**
 * Servlet implementation class ViewCompany
 */
@WebServlet("/admin/viewcompany.do")
public class ViewCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CompanyInfo> companies = HibernateViewUtil.getAllCompanies();
		if(companies!=null && companies.size() > 0 ){
			request.setAttribute("companies", companies);
		}
			RequestDispatcher rd = request.getRequestDispatcher("viewcompany.jsp");
		rd.forward(request,response);
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
