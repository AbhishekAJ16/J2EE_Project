package controller.admin.update;

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
import model.to.QualificationInfo;
import operations.Validations;

/**
 * Servlet implementation class UpdateQualificationInfo
 */
@WebServlet("/admin/updatequalification.do")
public class UpdateQualificationInfo extends HttpServlet {
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
		String qualificationid = request.getParameter("qualificationid");
		String qualificationname = request.getParameter("qualificationname");
		String description = request.getParameter("description");
		String message="";
		if(qualificationid!=null && qualificationname!=null && description!=null){
			qualificationid=qualificationid.trim();
			qualificationname=qualificationname.trim();
			description=description.trim();
			if(Validations.isEmpty(qualificationid) || Validations.isEmpty(qualificationname) || Validations.isEmpty(description)){
			message="please fill all boxes";	
			}
					QualificationInfo record = HibernateViewUtil.getQualification(Integer.parseInt(qualificationid));
					if(record!=null){
					record.setQualificationid(Integer.parseInt(qualificationid));
					record.setQualificationname(qualificationname);
					record.setDescription(description);
					if(HibernateUtil.updateRecord(record)){
						message = "Branch Record Is Updated In System Database";
					}else{
						message="Error : " + HibernateUtil.getErrormessage();
					}}else{
						message="There Is No Record For Updation";
					}
				
			
		}else{
			message+="Not Enough Parameter Supplied";
		}
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("viewbranch.do");
		rd.forward(request,response);

	}

}
