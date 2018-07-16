package model.to;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class StudentPlaced implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="sp_id")
	@SequenceGenerator(name="sp_id",sequenceName="seq_spid")
	private int spid;
    @ManyToOne
    @JoinColumn(name="studentid")
    private StudentInfo student2;
    @ManyToOne
    @JoinColumn(name="placementid")
    private PlacementInfo placement1;
    private Date placementdate;
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public StudentInfo getStudent2() {
		return student2;
	}
	public void setStudent2(StudentInfo student2) {
		this.student2 = student2;
	}
	public PlacementInfo getPlacement1() {
		return placement1;
	}
	public void setPlacement1(PlacementInfo placement1) {
		this.placement1 = placement1;
	}
	public Date getPlacementdate() {
		return placementdate;
	}
	public void setPlacementdate(Date placementdate) {
		this.placementdate = placementdate;
	}


}
