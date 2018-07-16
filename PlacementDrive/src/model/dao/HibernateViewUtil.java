package model.dao;

import java.util.List;

import org.hibernate.Query;

import model.to.BranchInfo;
import model.to.CompanyInfo;
import model.to.LoginInfo;
import model.to.PlacementCriteria;
import model.to.PlacementInfo;
import model.to.QualificationInfo;
import model.to.StudentInfo;
import model.to.StudentPhoto;
import model.to.StudentPlaced;
import model.to.StudentQualification;

public class HibernateViewUtil {
	public static List<BranchInfo> getAllBranch() {
		try {
			Query query = HibernateUtil.getHibernateSession().createQuery("from BranchInfo");
			List<BranchInfo> records = query.list();
			return records;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	public static List<StudentQualification> getAllStudentQual() {
		try {
			Query query = HibernateUtil.getHibernateSession().createQuery("from StudentQualification");
			List<StudentQualification> records = query.list();
			return records;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	public static StudentQualification getStudentQual(String sqid){
		try{
			StudentQualification record = (StudentQualification) HibernateUtil.getHibernateSession().get(StudentQualification.class,sqid);
		return record;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
		}

	public static LoginInfo getLogin(String username){
		try{
			LoginInfo record = (LoginInfo) HibernateUtil.getHibernateSession().get(LoginInfo.class,username);
		return record;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
		}
public static BranchInfo getBranch(String branchid){
	try{
	BranchInfo record = (BranchInfo) HibernateUtil.getHibernateSession().get(BranchInfo.class,branchid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}
public static List<StudentInfo> getAllStudents() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from StudentInfo");
		List<StudentInfo> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}
public static StudentInfo getStudent(int studentid){
	try{
		StudentInfo record = (StudentInfo)HibernateUtil.getHibernateSession().get(StudentInfo.class,studentid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}
public static StudentPlaced getStudentPlaced(int spid){
	try{
		StudentPlaced record = (StudentPlaced)HibernateUtil.getHibernateSession().get(StudentPlaced.class,spid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}
public static List<QualificationInfo> getAllQualifications() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from QualificationInfo");
		List<QualificationInfo> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}
public static List<StudentPlaced> getAllStudentPlaced() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from StudentPlaced");
		List<StudentPlaced> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}
public static QualificationInfo getQualification(int qualificationid){
	try{
		QualificationInfo record = (QualificationInfo)HibernateUtil.getHibernateSession().get(QualificationInfo.class,qualificationid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}
public static List<PlacementInfo> getAllPlacements() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from PlacementInfo");
		List<PlacementInfo> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}




public static PlacementInfo getPlacement(int placementid){
	try{
		PlacementInfo record = (PlacementInfo)HibernateUtil.getHibernateSession().get(PlacementInfo.class,placementid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}


public static List<CompanyInfo> getAllCompanies() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from CompanyInfo");
		List<CompanyInfo> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}




public static CompanyInfo getCompany(int companyid){
	try{
		CompanyInfo record = (CompanyInfo)HibernateUtil.getHibernateSession().get(CompanyInfo.class,companyid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}

public static List<PlacementCriteria> getAllPlacementCriterias() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from PlacementCriteria");
		List<PlacementCriteria> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}

public static List<StudentPhoto> getAllStudentPhoto() {
	try {
		Query query = HibernateUtil.getHibernateSession().createQuery("from StudentPhoto");
		List<StudentPhoto> records = query.list();
		return records;
	} catch (Exception ex) {
		System.out.println(ex); 
		return null;
	}
}

public static StudentPhoto getStudentPhoto(int photoid){
	try{
		StudentPhoto record = (StudentPhoto)HibernateUtil.getHibernateSession().get(StudentPhoto.class,photoid);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}



public static PlacementCriteria getPlacementCriteria(int srno){
	try{
		PlacementCriteria record = (PlacementCriteria)HibernateUtil.getHibernateSession().get(PlacementCriteria.class,srno);
	return record;
	} catch (Exception ex) {
		System.out.println(ex);
		return null;
	}
	}

}

