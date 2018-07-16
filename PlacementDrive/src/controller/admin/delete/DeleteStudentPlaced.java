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
import model.to.PlacementCriteria;
import model.to.StudentPlaced;
import operations.Validations;

/**
 * Servlet implementation class DeleteStudentPlaced
 */
@WebServlet("/admin/deletestudentplaced.do")
public class DeleteStudentPlaced extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spid = request.getParameter("spid");
		String message = "";
		if (spid != null) {
			spid = spid.trim();

			if (Validations.isEmpty(spid)) {
				message = "Please provide some value for spid.";
			}else if (spid.contains(",")) {
				String values[] = spid.split(",");
				for (String value : values) {
					value=value.trim();
					if (Validations.isNumber(value)) {
						StudentPlaced record = HibernateViewUtil.getStudentPlaced(Integer.parseInt(value));
						if (record != null) {
							if (HibernateUtil.deleteRecord(record)) {
								message += "Student Placed  with spid : ( " + value + " ) is removed from the system.<br/>";
							} else {
								message += "Student Placed  with spid : ( " + value + " ) is not removed due to "
										+ HibernateUtil.getErrormessage() + "</br>";
							}
						} else {
							message += "There is no such spid : " + value + "<br/>";
						}
					} else {
						message += value + "is not a numeric value<br/>";
					}
				}
			} else if (Validations.isNumber(spid)) {
				StudentPlaced record = HibernateViewUtil.getStudentPlaced(Integer.parseInt(spid));
				if (record != null) {
					if (HibernateUtil.deleteRecord(record)) {
						message += "Student Placed with spid : ( " + spid + " ) is removed from the system.";
					} else {
						message += "Student Placed with spid : ( " + spid + " ) is not removed due to "
								+ HibernateUtil.getErrormessage();
					}
				} else {
					message += "There is no such spid : " + spid;
				}
			} else {
				message = "Please give numeric type spid.";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewstudentplaced.do");
		rd.forward(request, response);
	}

	}


