package controller.admin.insert;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.CompanyInfo;
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import operations.Validations;

/**
 * Servlet implementation class AssignPlacementInfo
 */
@WebServlet("/admin/assignplacementinfo.do")
public class AssignPlacementInfo extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyid = request.getParameter("companyid");
		String drivedate = request.getParameter("drivedate");
		String jobdescription = request.getParameter("jobdescription");
		String packages = request.getParameter("packages");
		String allowedbacklog = request.getParameter("allowedbacklog");
		String message = "";
		if (companyid != null && drivedate != null && jobdescription != null && allowedbacklog!= null && packages != null) {
			companyid = companyid.trim();
			packages=packages.trim();
			drivedate = drivedate.trim();
			jobdescription = jobdescription.trim();
			allowedbacklog = allowedbacklog.trim();
			if (Validations.isEmpty(companyid) || Validations.isEmpty(packages) || Validations.isEmpty(drivedate) || Validations.isEmpty(jobdescription) || Validations.isEmpty(allowedbacklog)) {
				message = "Please Fill All Boxes";
			}else if(Validations.isNumber(companyid) || Validations.isNumber(packages)){
			CompanyInfo ci = HibernateViewUtil.getCompany(Integer.parseInt(companyid));	
			if(ci==null){
					message = "There Is No Record For Placement";
				}else{
					Date db = Date.valueOf(drivedate);
					PlacementInfo record = new PlacementInfo();
					record.setJobdescription(jobdescription);
					record.setAllowedbacklog(Integer.parseInt(allowedbacklog));
					record.setCompany(ci);
					record.setPackages(Float.valueOf(packages));
					record.setDrivedate(db);
					if(HibernateUtil.insertRecord(record)){
						message="Company Id is assigned to Placement info";
					}else{
						message="Insertion Failure Due to " + HibernateUtil.getErrormessage(); 
					}
					
					
					
					
				}
			}else{
				message="CompanyId Must Be An Integer";
			} 
			} else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);

		RequestDispatcher rd = request.getRequestDispatcher("fetchplacementinfo.do");
		rd.forward(request, response);

	}
}
