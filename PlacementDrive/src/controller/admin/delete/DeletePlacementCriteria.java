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
import operations.Validations;

/**
 * Servlet implementation class DeletePlacementCriteria
 */
@WebServlet("/admin/deleteplacementcriteria.do")
public class DeletePlacementCriteria extends HttpServlet {
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
		String srno = request.getParameter("srno");
		String message = "";
		if (srno != null) {
			srno = srno.trim();

			if (Validations.isEmpty(srno)) {
				message = "Please provide some value for srno.";
			}else if (srno.contains(",")) {
				String values[] = srno.split(",");
				for (String value : values) {
					value=value.trim();
					if (Validations.isNumber(value)) {
						PlacementCriteria record = HibernateViewUtil.getPlacementCriteria(Integer.parseInt(value));
						if (record != null) {
							if (HibernateUtil.deleteRecord(record)) {
								message += "Placement Criteria with srno : ( " + value + " ) is removed from the system.<br/>";
							} else {
								message += "Placement Criteria with srno : ( " + value + " ) is not removed due to "
										+ HibernateUtil.getErrormessage() + "</br>";
							}
						} else {
							message += "There is no such srno : " + value + "<br/>";
						}
					} else {
						message += value + "is not a numeric value<br/>";
					}
				}
			} else if (Validations.isNumber(srno)) {
				PlacementCriteria record = HibernateViewUtil.getPlacementCriteria(Integer.parseInt(srno));
				if (record != null) {
					if (HibernateUtil.deleteRecord(record)) {
						message += "Placement Criteria with srno : ( " + srno + " ) is removed from the system.";
					} else {
						message += "Placement Criteria with srno : ( " + srno + " ) is not removed due to "
								+ HibernateUtil.getErrormessage();
					}
				} else {
					message += "There is no such srno : " + srno;
				}
			} else {
				message = "Please give numeric type srno.";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewplacementcriteria.do");
		rd.forward(request, response);
	}

	}


