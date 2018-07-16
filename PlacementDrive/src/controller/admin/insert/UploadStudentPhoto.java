package controller.admin.insert;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dao.HibernateUtil;
import model.dao.HibernateViewUtil;
import model.to.StudentInfo;
import model.to.StudentPhoto;

/**
 * Servlet implementation class UploadStudentPhoto
 */
@WebServlet("/admin/uploadstudentphoto.do")
@MultipartConfig
public class UploadStudentPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "";
		Part photopart = request.getPart("photo");
		Part studentidpart = request.getPart("studentid");
		if (photopart != null && studentidpart != null) {
			InputStream photostream = photopart.getInputStream();
			InputStream studentidstream = studentidpart.getInputStream();
			Scanner sc = new Scanner(studentidstream);
			if (sc.hasNextInt() && photostream instanceof FileInputStream) {
				int studentid = sc.nextInt();
				/*
				 * Collection <String> headers = photopart.getHeaderNames();
				 * if(headers!=null){ for(String headername : headers){ message
				 * += headername + " : " + photopart.getHeader(headername) +
				 * "<br/>";
				 * 
				 * }
				 * 
				 * }
				 */
				String photoname = photopart.getHeader("content-disposition");
				photoname = photoname.substring(photoname.lastIndexOf("=") + 1);
				photoname = photoname.replace("\"", "");
				System.out.println(photoname);
				 String extname = photoname.substring(photoname.lastIndexOf('.')+1);
				String extensions = "jpg,jpeg,png,gif,bmp";
				
				if (extensions.contains(extname.toLowerCase())) {
					StudentInfo si = HibernateViewUtil.getStudent(studentid);
					if (si != null) {
						StudentPhoto record = new StudentPhoto();
						record.setPhotoextname(extname);
						record.setPhotoname(photoname);
						record.setStudent1(si);
						record.setPhotosize(photostream.available());
						record.setPhototype(photopart.getContentType());
						if (HibernateUtil.insertRecord(record)) {
							message = "Student Photo Is Uploaded";
							int photoid = record.getPhotoid();
							String path = "/stuphoto/" + photoid + "." + extname;
							path = getServletContext().getRealPath(path);
							FileOutputStream fout = new FileOutputStream(path);
							int data = photostream.read();
							while (data != -1) {
								fout.write(data);
								data = photostream.read();
							}
							fout.close();
						} else {
							message = "Upload Failure Due To " + HibernateUtil.getErrormessage();
						}
					} else {
						message = "This Student Id Is Not Exists";
					}
				} else {
					message = "This Format For File is Not Allowed For Photo";
				}
				//message = photoname;

			} else {
				message = "Please Choose Appropriate Values";
			}
		}

		else {
			message = "Not Enough Values Supplied";
		}
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("fetchstudentforphoto.do");
		rd.forward(request, response);
	}

}
