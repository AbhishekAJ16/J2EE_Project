package model.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class CompanyInfo implements Serializable{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO,generator="company_id")
    @SequenceGenerator(name="company_id",sequenceName="seq_companyid")
	private int companyid;
	@Column(length=100)
	private String companyname;
	@Column(length=3000)
	private String description;
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
   
 }
