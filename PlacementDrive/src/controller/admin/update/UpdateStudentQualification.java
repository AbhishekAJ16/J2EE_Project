package controller.admin.update;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentQualification;
import operations.Validations;

/**
 * Servlet implementation class UpdateStudentQualification
 */
@WebServlet("/admin/updatestudentqual.do")
public class UpdateStudentQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String passingyear = request.getParameter("passingyear");
		String percentage = request.getParameter("percentage");
		String qualificationid = request.getParameter("qualificationid");
		String universityboard = request.getParameter("universityboard");
		String message = "";
		if (studentid != null && passingyear != null && qualificationid != null && universityboard != null) {
			studentid = studentid.trim();
			passingyear = passingyear.trim();
			percentage = percentage.trim();
			qualificationid = qualificationid.trim();
			universityboard = universityboard.trim();
			if (Validations.isEmpty(studentid) || Validations.isEmpty(passingyear) || Validations.isEmpty(percentage)
					|| Validations.isEmpty(qualificationid)) {
				message = "Please fill all boxes";
			} else if ((!Validations.onlyCharacter(universityboard))) {
				message = "Please enter character values in universityboard";
			} else if ((!Validations.isNumber(studentid)) || (!Validations.isNumber(qualificationid))) {
				message = "Please enter numeric value in productid box and subcategory box.";
			} else {
				StudentInfo si = HibernateViewUtil.getStudent(Integer.parseInt(studentid));
				QualificationInfo qi = HibernateViewUtil.getQualification(Integer.parseInt(qualificationid));
				StudentQualification record = HibernateViewUtil.getStudentQual(sqid);
				if (record != null) {
					record.setStudent(si);
					record.setQualification(qi);
					record.setPassingyear(Integer.parseInt(passingyear));
					record.setPercentage(Float.parseFloat(percentage));
					if (HibernateUtil.updateRecord(record)) {
						message = "Student Qualification  record is updated in system database";
					} else {
						if (HibernateUtil.getErrormessage().contains("NonUniqueObjectException")) {
							message = "Please Enter unique values in s as it is a primary key.";
						} else {
							message = "Error : " + HibernateUtil.getErrormessage();
						}
					}
				} else {
					message = "There is no record for updation.";
				}
			}
		}

		else {
			message = "Not enough parameter supplied";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewstudentqualification.do");
		rd.forward(request, response);
	}

}
