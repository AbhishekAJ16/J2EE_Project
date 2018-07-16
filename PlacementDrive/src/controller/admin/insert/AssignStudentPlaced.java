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
import model.to.PlacementCriteria;
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentPlaced;
import operations.Validations;

/**
 * Servlet implementation class AssignStudentPlaced
 */
@WebServlet("/admin/assignstudentplaced.do")
public class AssignStudentPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentid = request.getParameter("studentid");
		String placementid = request.getParameter("placementid");
		String placementdate = request.getParameter("placementdate");
		String message = "";
		if (studentid != null && placementid != null && placementdate != null) {
			studentid = studentid.trim();
			placementid = placementid.trim();
			placementdate = placementdate.trim();
			if (Validations.isEmpty(studentid) || Validations.isEmpty(placementid)
					|| Validations.isEmpty(placementdate)) {
				message = "Please Fill All Boxes";
			} else if (Validations.isNumber(studentid)) {
				PlacementInfo pi = HibernateViewUtil.getPlacement(Integer.parseInt(placementid));
				StudentInfo si = HibernateViewUtil.getStudent(Integer.parseInt(studentid));
				if (pi == null || si == null) {
					message = "There Is No Record For Branch or Student";
				} else {
					Date db = Date.valueOf(placementdate);
					StudentPlaced record = new StudentPlaced();
					record.setStudent2(si);
					record.setPlacement1(pi);
					record.setPlacementdate((db));
					if (HibernateUtil.insertRecord(record)) {
						message = "Qualification Id is assigned to Placement Criteria";
					} else {
						message = "Insertion Failure Due to " + HibernateUtil.getErrormessage();
					}

				}
			} else {
				message = "StudentId Must Be An Integer";
			}
		} else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("fetchstudentplaced.do");
		rd.forward(request, response);

	}

}
