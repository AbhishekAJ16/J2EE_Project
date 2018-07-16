package model.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class StudentQualification implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="sq_id")
    @SequenceGenerator(name="sq_id",sequenceName="seq_sqid")
	private int sqid;
    @ManyToOne
    @JoinColumn(name="studentid")
    private StudentInfo student;
    @ManyToOne
    @JoinColumn(name="qualificationid")
    private QualificationInfo qualification;

    private int passingyear;
    
    private float percentage;
    @Column(length=100)
    private String universityboard;
	public int getSqid() {
		return sqid;
	}
	public void setSqid(int sqid) {
		this.sqid = sqid;
	}
	public StudentInfo getStudent() {
		return student;
	}
	public void setStudent(StudentInfo student) {
		this.student = student;
	}
	public QualificationInfo getQualification() {
		return qualification;
	}
	public void setQualification(QualificationInfo qualification) {
		this.qualification = qualification;
	}
	public int getPassingyear() {
		return passingyear;
	}
	public void setPassingyear(int passingyear) {
		this.passingyear = passingyear;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public String getUniversityboard() {
		return universityboard;
	}
	public void setUniversityboard(String universityboard) {
		this.universityboard = universityboard;
	}

    
}
