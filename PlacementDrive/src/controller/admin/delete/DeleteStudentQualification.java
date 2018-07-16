package controller.admin.delete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.StudentQualification;
import operations.Validations;

/**
 * Servlet implementation class DeleteStudentQualification
 */
@WebServlet("/admin/deletestudentqual.do")
public class DeleteStudentQualification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studqualids = request.getParameter("studqualids");
		String message = "";
		if (studqualids != null) {
			studqualids = studqualids.trim();
			if (Validations.isEmpty(studqualids)) {
				message = "Please provide some value for SQID.";
			}else if (studqualids.contains(",")) {
				String values[] = studqualids.split(",");
				for (String value : values) {
					value=value.trim();
					if (Validations.isNumber(value)) {
						StudentQualification record = HibernateViewUtil.getStudentQual((value));
						if (record != null) {
							if (HibernateUtil.deleteRecord(record)) {
								message += "StudentQualification with sqid : ( " + value + " ) is removed from the system.<br/>";
							} else {
								message += "StudentQualification with sqid : ( " + value + " ) is not removed due to "
										+ HibernateUtil.getErrormessage() + "</br>";
							}
						} else {
							message += "There is no such sqid : " + value + "<br/>";
						}
					} else {
						message += value + "is not a numeric value<br/>";
					}
				}
			} else if (Validations.isNumber(studqualids)) {
				StudentQualification record = HibernateViewUtil.getStudentQual((studqualids));
				if (record != null) {
					if (HibernateUtil.deleteRecord(record)) {
						message += "StudentQualification with sqid : ( " + studqualids + " ) is removed from the system.";
					} else {
						message += "StudentQualification with sqid : ( " + studqualids + " ) is not removed due to "
								+ HibernateUtil.getErrormessage();
					}
				} else {
					message += "There is no such sqid : " + studqualids;
				}
			} else {
				message = "Please give numeric type sqid.";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewstudentqualification.do");
		rd.forward(request, response);
	}

}
