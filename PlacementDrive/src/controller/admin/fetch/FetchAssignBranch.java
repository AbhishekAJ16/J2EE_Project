package controller.admin.fetch;

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
import model.to.StudentInfo;

/**
 * Servlet implementation class FetchAssignCourse
 */
@WebServlet("/admin/fetchassignbranch.do")
public class FetchAssignBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BranchInfo> branches = HibernateViewUtil.getAllBranch();
		List<StudentInfo> students = HibernateViewUtil.getAllStudents();
		if(branches!=null && branches.size() > 0){
			request.setAttribute("branches",branches);
		}
		if(students!=null && students.size() > 0){
			request.setAttribute("students", students);
		}
		RequestDispatcher rd = request.getRequestDispatcher("assignbranch.jsp");
		rd.forward(request, response);
	}
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
