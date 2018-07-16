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
import model.to.QualificationInfo;
import model.to.StudentInfo;

/**
 * Servlet implementation class FetchStudentQualification
 */
@WebServlet("/admin/fetchstudentqualification.do")
public class FetchStudentQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<StudentInfo> students = HibernateViewUtil.getAllStudents();
		List<QualificationInfo> qualifications = HibernateViewUtil.getAllQualifications();
		if (students != null && students.size() > 0) {
			request.setAttribute("students", students);
		}
		if (qualifications != null && qualifications.size() > 0) {
			request.setAttribute("qualifications", qualifications);
		}
		RequestDispatcher rd = request.getRequestDispatcher("assignstudentqualification.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}