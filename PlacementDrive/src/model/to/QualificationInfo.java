package model.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class QualificationInfo implements Serializable{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="qualification_id")
    @SequenceGenerator(name="qualification_id",sequenceName="seq_qualificationid")
	private int qualificationid;
	@Column(length=100,unique=true)
	private String qualificationname;
	@Column(length=100)
	private String description;
	public int getQualificationid() {
		return qualificationid;
	}
	public void setQualificationid(int qualificationid) {
		this.qualificationid = qualificationid;
	}
	public String getQualificationname() {
		return qualificationname;
	}
	public void setQualificationname(String qualificationname) {
		this.qualificationname = qualificationname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
