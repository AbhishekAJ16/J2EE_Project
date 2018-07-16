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
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class DeleteStudents
 */
@WebServlet("/admin/deletestudents.do")
public class DeleteStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "";
		String studentids = request.getParameter("studentids");
		System.out.println("abhishek");
		if (studentids != null) {
			studentids = studentids.trim();
			if (Validations.isEmpty(studentids)) {
				message = "Please Enter Some Value";
			} else if (studentids.contains(",")) {
				String values[] = studentids.split(",");
				for (String value : values) {
					value=value.trim();
					if (Validations.isNumber(value)) {
						StudentInfo record = HibernateViewUtil.getStudent(Integer.parseInt(value));
						if (record != null) {
							if (HibernateUtil.deleteRecord(record)) {
								message = "Student With Id : ( " + studentids
										+ " ) Is Removed From System Data Base </br>";
							} else {
								message = "Student With Id : ( " + studentids
										+ " ) Is Not Removed From System Data Base Due To "
										+ HibernateUtil.getErrormessage() + "/br>";

							}
						} else {
							message = "There Is No Such Student Id " + studentids + "</br>";
						}
					} else {
						message += value + "Is Not Numeric </br> ";
					}
				}
			} else if (Validations.isNumber(studentids)) {
				StudentInfo record = HibernateViewUtil.getStudent(Integer.parseInt(studentids));
				if (record != null) {
					if (HibernateUtil.deleteRecord(record)) {
						message = "Student With Id : ( " + studentids + " ) Is Removed From System Data Base ";
					} else {
						message = "Student With Id : ( " + studentids
								+ " ) Is Not Removed From System Data Base Due To " + HibernateUtil.getErrormessage();

					}
				} else {
					message = "There Is No Such Student Id " + studentids;
				}
			} else {
				message = "Please Give Numeric Student Id";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewstudents.do");
		rd.forward(request, response);
	}

}
