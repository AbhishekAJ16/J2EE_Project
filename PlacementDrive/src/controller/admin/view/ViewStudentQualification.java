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
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentQualification;

/**
 * Servlet implementation class ViewStudentQualification
 */
@WebServlet("/admin/viewstudentqualification.do")
public class ViewStudentQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentQualification> studentqual=HibernateViewUtil.getAllStudentQual();
		if(studentqual!=null && studentqual.size()>0){
			request.setAttribute("studentqual", studentqual);
		}
		List<StudentInfo> student=HibernateViewUtil.getAllStudents();
		if(student!=null && student.size()>0){
			request.setAttribute("student", student);
		}
		List<QualificationInfo> qual=HibernateViewUtil.getAllQualifications();
		if(qual!=null && qual.size()>0){
			request.setAttribute("qual", qual);
		}
		RequestDispatcher rd=request.getRequestDispatcher("viewstudentqualification.jsp");
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
