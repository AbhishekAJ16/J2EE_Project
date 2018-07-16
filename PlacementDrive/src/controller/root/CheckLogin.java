package controller.root;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.LoginInfo;
import operations.Validations;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet("/checklogin.do")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String message = "";
		boolean invalid = true;
		if (uname != null && upass != null) {
			if (Validations.isEmpty(uname) || Validations.isEmpty(upass)) {
				message = "Please Fill All The Boxes";
			} else {
				LoginInfo login = HibernateViewUtil.getLogin(uname);
				if (login != null) {
					if (login.getPassword().equals(upass)) {
						if (login.getRolename() != null) {
							if (login.getRolename().equalsIgnoreCase("admin")) {
								HttpSession session = request.getSession();
								session.setAttribute("admin", uname);
								invalid = false;
								session.setAttribute("lastlogin", login.getLastlogin());
								login.setLastlogin(new Timestamp(new java.util.Date().getTime()));
								HibernateUtil.updateRecord(login);
								response.sendRedirect("admin/index.jsp");
							} else {
								if (login.getRolename().equalsIgnoreCase("user")) {
									HttpSession session = request.getSession();
									session.setAttribute("user", uname);
									invalid = false;
									session.setAttribute("lastlogin", login.getLastlogin());
									login.setLastlogin(new Timestamp(new java.util.Date().getTime()));
									HibernateUtil.updateRecord(login);
									response.sendRedirect("user/index.jsp");

								} else {
									message = "Insufficient Privileges To This User Contact Admininstrator";
								}
							}
						} else {
							message = "Role Name Is Not Defined ";
						}
					} else {
						message = "Invalid Username And Password";
					}
				}

				else {
					message = "Invalid Username And Password";
				}

			}

		} else {
			message = "Please Fill Both The Boxes";
		}
		if (invalid) {
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
