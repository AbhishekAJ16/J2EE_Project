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

/**
 * Servlet implementation class ViewBranchDetails
 */
@WebServlet("/admin/viewbranch.do")
public class ViewBranchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<BranchInfo> branches = HibernateViewUtil.getAllBranch();
	if(branches!=null && branches.size() > 0 ){
		request.setAttribute("branches", branches);
	}
		RequestDispatcher rd = request.getRequestDispatcher("viewbranches.jsp");
	rd.forward(request,response);
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
