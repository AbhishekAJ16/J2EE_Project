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
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;

/**
 * Servlet implementation class FetchStudentPlaced
 */
@WebServlet("/admin/fetchstudentplaced.do")
public class FetchStudentPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentInfo> students = HibernateViewUtil.getAllStudents();
		List<PlacementInfo> placements = HibernateViewUtil.getAllPlacements();
		if(students!=null && students.size() > 0){
			request.setAttribute("students",students);
		}
		if(placements!=null && placements.size() > 0){
			request.setAttribute("placements",placements);
		}
		RequestDispatcher rd = request.getRequestDispatcher("assignstudentplaced.jsp");
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
