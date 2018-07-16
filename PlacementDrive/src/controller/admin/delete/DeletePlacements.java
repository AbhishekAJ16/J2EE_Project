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
import model.to.PlacementInfo;
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class DeletePlacements
 */
@WebServlet("/admin/deleteplacements.do")
public class DeletePlacements extends HttpServlet {
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
		String message = "";
		String placementids = request.getParameter("placementids");
		if (placementids != null) {
			placementids = placementids.trim();
			if (Validations.isEmpty(placementids)) {
				message = "Please Enter Some Value";
			} else if (placementids.contains(",")) {
				String values[] = placementids.split(",");
				for (String value : values) {
					value=value.trim();
					if (Validations.isNumber(value)) {
						PlacementInfo record = HibernateViewUtil.getPlacement(Integer.parseInt(value));
						if (record != null) {
							if (HibernateUtil.deleteRecord(record)) {
								message = "Placement With Id : ( " + placementids
										+ " ) Is Removed From System Data Base </br>";
							} else {
								message = "Placement With Id : ( " + placementids
										+ " ) Is Not Removed From System Data Base Due To "
										+ HibernateUtil.getErrormessage() + "/br>";

							}
						} else {
							message = "There Is No Such Student Id " + placementids + "</br>";
						}
					} else {
						message += value + "Is Not Numeric </br> ";
					}
				}
			} else if (Validations.isNumber(placementids)) {
				PlacementInfo record = HibernateViewUtil.getPlacement(Integer.parseInt(placementids));
				if (record != null) {
					if (HibernateUtil.deleteRecord(record)) {
						message = "Placement With Id : ( " + placementids + " ) Is Removed From System Data Base ";
					} else {
						message = "Placement With Id : ( " + placementids
								+ " ) Is Not Removed From System Data Base Due To " + HibernateUtil.getErrormessage();

					}
				} else {
					message = "There Is No Such Placement Id " + placementids;
				}
			} else {
				message = "Please Give Numeric Placement Id";
			}
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewplacements.do");
		rd.forward(request, response);
}

}
