package model.to;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class PlacementInfo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="placement_id")
	@SequenceGenerator(name="placement_id",sequenceName="seq_placementid")
	private int placementid;
	@ManyToOne
	@JoinColumn(name="companyid")
	private CompanyInfo company;
	
	private Date drivedate;
	@Column(length=1000)
	private String jobdescription;
    
    private float packages;
    
    private int allowedbacklog;

	public int getPlacementid() {
		return placementid;
	}

	public void setPlacementid(int placementid) {
		this.placementid = placementid;
	}

	public CompanyInfo getCompany() {
		return company;
	}

	public void setCompany(CompanyInfo company) {
		this.company = company;
	}

	public Date getDrivedate() {
		return drivedate;
	}

	public void setDrivedate(Date drivedate) {
		this.drivedate = drivedate;
	}

	public String getJobdescription() {
		return jobdescription;
	}

	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public float getPackages() {
		return packages;
	}

	public void setPackages(float packages) {
		this.packages = packages;
	}

	public int getAllowedbacklog() {
		return allowedbacklog;
	}

	public void setAllowedbacklog(int allowedbacklog) {
		this.allowedbacklog = allowedbacklog;
	}
    
    
}
