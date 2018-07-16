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
import model.to.PlacementCriteria;
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class AssignPlacementCriteria
 */
@WebServlet("/admin/assignplacementcriteria.do")
public class AssignPlacementCriteria extends HttpServlet {
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
		String placementid = request.getParameter("placementid");
		String qualificationid = request.getParameter("qualificationid");
		String percentage = request.getParameter("percentage");
		String message = "";
		if (placementid != null && qualificationid != null && percentage != null) {
			placementid = placementid.trim();
			qualificationid = qualificationid.trim();
				percentage = percentage.trim();
			if (Validations.isEmpty(placementid) || Validations.isEmpty(qualificationid) || Validations.isEmpty(percentage)) {
				message = "Please Fill All Boxes";
			}else if(Validations.isNumber(placementid)){
				QualificationInfo qi = HibernateViewUtil.getQualification(Integer.parseInt(qualificationid));
				PlacementInfo pi = HibernateViewUtil.getPlacement(Integer.parseInt(placementid));
				if(pi==null || qi==null){
					message = "There Is No Record For Placement Criteria";
				}else{
                    PlacementCriteria record = new PlacementCriteria();
					record.setPercentage(Integer.parseInt(percentage));
					record.setPlacement(pi);
					record.setQualification1(qi);
					record.setPlacement(pi);
					if(HibernateUtil.insertRecord(record)){
						message="Qualification Id is assigned to Placement Criteria";
					}else{
						message="Insertion Failure Due to " + HibernateUtil.getErrormessage(); 
					}
				}
			}else{
				message="PlacementId Must Be An Integer";
			} 
			} else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("fetchplacementcriteria.do");
		rd.forward(request, response);

	}

}
