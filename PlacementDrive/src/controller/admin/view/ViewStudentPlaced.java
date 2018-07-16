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
import model.to.PlacementCriteria;
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentPlaced;

/**
 * Servlet implementation class ViewStudentPlaced
 */
@WebServlet("/admin/viewstudentplaced.do")
public class ViewStudentPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentPlaced> studentplaced = HibernateViewUtil.getAllStudentPlaced();
		if(studentplaced!=null && studentplaced.size() > 0 ){
			request.setAttribute("studentplaced", studentplaced);
		}
		List<PlacementInfo> placements = HibernateViewUtil.getAllPlacements();
		if(placements!=null && placements.size() > 0 ){
			request.setAttribute("placements", placements);
		}
		List<StudentInfo> studentinfo = HibernateViewUtil.getAllStudents();
		if(studentinfo!=null && studentinfo.size() > 0 ){
			request.setAttribute("studentinfo", studentinfo);
		}
			RequestDispatcher rd = request.getRequestDispatcher("viewstudentplaced.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


