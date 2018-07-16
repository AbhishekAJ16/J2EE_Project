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
import model.to.BranchInfo;
import model.to.QualificationInfo;

/**
 * Servlet implementation class ViewQualifications
 */
@WebServlet("/admin/viewqualification.do")
public class ViewQualifications extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QualificationInfo> qualifications = HibernateViewUtil.getAllQualifications();
		if(qualifications!=null && qualifications.size() > 0 ){
			request.setAttribute("qualifications", qualifications);
		}
			RequestDispatcher rd = request.getRequestDispatcher("viewqualifications.jsp");
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
