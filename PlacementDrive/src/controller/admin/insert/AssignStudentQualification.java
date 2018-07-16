package controller.admin.insert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.BranchInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentQualification;
import operations.Validations;

/**
 * Servlet implementation class AssignStudentQualification
 */
@WebServlet("/admin/assignstudentqualification.do")
public class AssignStudentQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentid = request.getParameter("studentid");
		String qualificationid = request.getParameter("qualificationid");
		String percentage = request.getParameter("percentage");
		String passingyear = request.getParameter("passingyear");
		String universityboard = request.getParameter("universityboard");
		String message = "";
		if (studentid != null && qualificationid != null && percentage != null && passingyear != null
				&& universityboard != null) {
			studentid = studentid.trim();
			qualificationid = qualificationid.trim();
			passingyear = passingyear.trim();
			percentage = percentage.trim();
			universityboard = universityboard.trim();

			if (Validations.isEmpty(studentid) || Validations.isEmpty(qualificationid)
					|| Validations.isEmpty(passingyear) || Validations.isEmpty(percentage)
					|| Validations.isEmpty(universityboard)) {
				message = "Please Fill All Boxes";
			} else if (Validations.isNumber(studentid)) {
				QualificationInfo qi = HibernateViewUtil.getQualification(Integer.parseInt(qualificationid));
				StudentInfo si = HibernateViewUtil.getStudent(Integer.parseInt(studentid));
				if (qi == null || si == null) {
					message = "There Is No Record For Branch or Student";
				} else {
					StudentQualification record=new StudentQualification();
					record.setStudent(si);
					record.setQualification(qi);
					record.setPassingyear(Integer.parseInt(passingyear));
					record.setPercentage(Integer.parseInt(percentage));
					record.setUniversityboard(universityboard);
					if(HibernateUtil.insertRecord(record)){
						message="Record is entered.";
					}else{
						message="Failure due to:" + HibernateUtil.getErrormessage();
					}
				}
			} else {
				message = "StudentId Must Be An Integer";
			}
		} else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("fetchstudentqualification.do");
		rd.forward(request, response);

	}

}
