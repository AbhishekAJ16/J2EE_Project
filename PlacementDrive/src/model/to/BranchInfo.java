package model.to;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BranchInfo implements Serializable{
@Id
@Column(length=20)
private String branchid;
@Column(length=100,unique=true)
private String branchname;
@Column(length=3000)
private String description;

private int totalsem;

public String getBranchid() {
	return branchid;
}

public void setBranchid(String branchid) {
	this.branchid = branchid;
}

public String getBranchname() {
	return branchname;
}

public void setBranchname(String branchname) {
	this.branchname = branchname;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getTotalsem() {
	return totalsem;
}

public void setTotalsem(int totalsem2) {
	this.totalsem = totalsem2;
}

}

