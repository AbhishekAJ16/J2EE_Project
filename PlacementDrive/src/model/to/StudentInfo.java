package model.to;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class StudentInfo implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="student_id")
    @SequenceGenerator(name="student_id",sequenceName="seq_studentid")
	private int studentid;
    
    
    @Column(length=100)
    private String studentname;
                                                                                      
    private Date dob;
    @Column(length=20)
    private String contactno;
    @Column(length=20)
    private String gender;
    @Column(length=20)
    private String fathername;    
    @ManyToOne
    @JoinColumn(name="branchid")
    private BranchInfo branch;
    
    private int sessionbeginyear;

    private int sessionendyear;
    
    private float currentpercentage;
    
    private int noofbacklog;

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public BranchInfo getBranch() {
		return branch;
	}

	public void setBranch(BranchInfo branch) {
		this.branch = branch;
	}

	public int getSessionbeginyear() {
		return sessionbeginyear;
	}

	public void setSessionbeginyear(int sessionbeginyear) {
		this.sessionbeginyear = sessionbeginyear;
	}

	public int getSessionendyear() {
		return sessionendyear;
	}

	public void setSessionendyear(int sessionendyear) {
		this.sessionendyear = sessionendyear;
	}

	public float getCurrentpercentage() {
		return currentpercentage;
	}

	public void setCurrentpercentage(float currentpercentage) {
		this.currentpercentage = currentpercentage;
	}

	public int getNoofbacklog() {
		return noofbacklog;
	}

	public void setNoofbacklog(int noofbacklog) {
		this.noofbacklog = noofbacklog;
	}
  
}
