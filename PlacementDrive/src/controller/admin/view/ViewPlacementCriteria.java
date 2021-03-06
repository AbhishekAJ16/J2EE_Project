package controller.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateViewUtil;
import model.to.PlacementCriteria;
import model.to.PlacementInfo;
import model.to.QualificationInfo;

/**
 * Servlet implementation class ViewPlacementCriteria
 */
@WebServlet("/admin/viewplacementcriteria.do")
public class ViewPlacementCriteria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PlacementCriteria> placementcriteria = HibernateViewUtil.getAllPlacementCriterias();
		if(placementcriteria!=null && placementcriteria.size() > 0 ){
			request.setAttribute("placementcriteria", placementcriteria);
		}
		List<PlacementInfo> placements = HibernateViewUtil.getAllPlacements();
		if(placements!=null && placements.size() > 0 ){
			request.setAttribute("placements", placements);
		}
		List<QualificationInfo> qualifications = HibernateViewUtil.getAllQualifications();
		if(qualifications!=null && qualifications.size() > 0 ){
			request.setAttribute("qualifications", qualifications);
		}
			RequestDispatcher rd = request.getRequestDispatcher("viewplacementcriteria.jsp");
		rd.forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
