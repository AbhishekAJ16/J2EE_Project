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
import model.to.BranchInfo;
import operations.Validations;

/**
 * Servlet implementation class DeleteBranch
 */
@WebServlet("/admin/deletebranch.do")
public class DeleteBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String branchid = request.getParameter("branchid");
		String message = "";
		if (branchid != null) {
			branchid = branchid.trim();
			if (Validations.isEmpty(branchid)) {
				message = "Please Provide Some Value For BranchId";
			} else {
				BranchInfo record = HibernateViewUtil.getBranch(branchid);
                if(record==null){
                	message = "There Is No Record For This Branch ID";
                }else
                	if(HibernateUtil.deleteRecord(record)){
                		message = "Record Is Remove From System Database";
                	}else{
                		message = "Failure Due To : " + HibernateUtil.getErrormessage();
                	}
                
			}
		} else {
			message = "Not Enough Value Supplied";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("viewbranch.do");
		rd.forward(request, response);
	}

}
