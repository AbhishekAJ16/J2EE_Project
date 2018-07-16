package controller.admin.insert;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.BranchInfo;
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class AssignBranch
 */
@WebServlet("/admin/assignbranch.do")
public class AssignBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String branchid = request.getParameter("branchid");
		String startdate = request.getParameter("startdate");
		String message = "";
		if (studentid != null && branchid != null && startdate != null) {
			studentid = studentid.trim();
			branchid = branchid.trim();
			startdate = startdate.trim();
			if (Validations.isEmpty(studentid) || Validations.isEmpty(branchid) || Validations.isEmpty(startdate)) {
				message = "Please Fill All Boxes";
			}else if(Validations.isNumber(studentid)){
				BranchInfo bi = HibernateViewUtil.getBranch(branchid);
				StudentInfo si = HibernateViewUtil.getStudent(Integer.parseInt(studentid));
				if(bi==null || si==null){
					message = "There Is No Record For Branch or Student";
				}else{
					
					
					
					
					
				}
			}else{
				message="StudentId Must Be An Integer";
			} 
			} else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("fetchassignbranch.do");
		rd.forward(request, response);
	}

}
