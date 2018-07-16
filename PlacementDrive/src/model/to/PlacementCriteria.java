package model.to;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PlacementCriteria implements Serializable {
	@ManyToOne
	@JoinColumn(name = "placementid")
	private PlacementInfo placementid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sr_no")
	@SequenceGenerator(name = "sr_no", sequenceName = "seq_srno")
	private int srno;
	@ManyToOne
	@JoinColumn(name = "qualificationid")
	private QualificationInfo qualificationid;
	private float percentage;

	public PlacementInfo getPlacement() {
		return placementid;
	}

	public void setPlacement(PlacementInfo placement) {
		this.placementid = placement;
	}

	public int getSrno() {
		return srno;
	}

	public void setSrno(int srno) {
		this.srno = srno;
	}

	public QualificationInfo getQualification1() {
		return qualificationid;
	}

	public void setQualification1(QualificationInfo qualification1) {
		this.qualificationid = qualification1;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
