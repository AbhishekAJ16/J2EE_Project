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
public class StudentPhoto implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="photo_id")
	@SequenceGenerator(name="photo_id",sequenceName="seq_photoid")
	private int photoid;
	@ManyToOne
	@JoinColumn(name="studentid")
	private StudentInfo student1;
	@Column(length=100)
	private String photoname;
	@Column(length=100)
	private String phototype;
	@Column(length=100)
	private String photoextname;
	private int photosize;
	public int getPhotoid() {
		return photoid;
	}
	public void setPhotoid(int photoid) {
		this.photoid = photoid;
	}
	public StudentInfo getStudent1() {
		return student1;
	}
	public void setStudent1(StudentInfo student1) {
		this.student1 = student1;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhototype() {
		return phototype;
	}
	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}
	public String getPhotoextname() {
		return photoextname;
	}
	public void setPhotoextname(String photoextname) {
		this.photoextname = photoextname;
	}
	public int getPhotosize() {
		return photosize;
	}
	public void setPhotosize(int photosize) {
		this.photosize = photosize;
	}
	
	
	

}
