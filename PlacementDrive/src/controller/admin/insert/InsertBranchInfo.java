package controller.admin.insert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.HibernateUtil;
import model.to.BranchInfo;
import operations.Validations;

/**
 * Servlet implementation class InsertBranchInfo
 */
@WebServlet("/admin/insertbranch.do")
public class InsertBranchInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String branchid = request.getParameter("branchid");
		String branchname = request.getParameter("branchname");
		String description = request.getParameter("description");
		String totalsem = request.getParameter("totalsem");
		String message="";
		if(branchid!=null && branchname!=null && description!=null && totalsem!=null){
			branchid=branchid.trim();
			branchname=branchname.trim();
			description=description.trim();
			totalsem=totalsem.trim();
			if(Validations.isEmpty(branchid) || Validations.isEmpty(branchname) || Validations.isEmpty(description) || Validations.isEmpty(totalsem)){
			message="please fill all boxes";	
			}else if(Validations.isNumber(totalsem)){
				int sem=Integer.parseInt(totalsem);
				if(sem>0){
					BranchInfo record = new BranchInfo();
					record.setBranchid(branchid);
					record.setBranchname(branchname);
					record.setDescription(description);
					record.setTotalsem(sem);
					if(HibernateUtil.insertRecord(record)){
						message = "Branch Record Is Added In System Database";
					}else{
						message="Error : " + HibernateUtil.getErrormessage();
					}
				}else{
					message="Total sem Must Be A Positive Value";
				}
			}else{
				message="Totalsem Must Be A Integer";
			}
		}else{
			message+="Not Enough Parameter Supplied";
		}
		request.setAttribute("message",message);
		RequestDispatcher rd = request.getRequestDispatcher("addbranch.jsp");
		rd.forward(request,response);
	}

}
