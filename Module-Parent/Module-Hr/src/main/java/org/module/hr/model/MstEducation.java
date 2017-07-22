package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_education database table.
 * 
 */
@Entity
@Table(name="mst_education")
@NamedQuery(name="MstEducation.findAll", query="SELECT m FROM MstEducation m")
public class MstEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_education")
	private Integer idEducation;

	@Column(name="education_name")
	private String educationName;

	//bi-directional many-to-one association to TrsEmployeeEducation
	@OneToMany(mappedBy="mstEducation")
	private List<TrsEmployeeEducation> trsEmployeeEducations;

	public MstEducation() {
	}

	public Integer getIdEducation() {
		return this.idEducation;
	}

	public void setIdEducation(Integer idEducation) {
		this.idEducation = idEducation;
	}

	public String getEducationName() {
		return this.educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public List<TrsEmployeeEducation> getTrsEmployeeEducations() {
		return this.trsEmployeeEducations;
	}

	public void setTrsEmployeeEducations(List<TrsEmployeeEducation> trsEmployeeEducations) {
		this.trsEmployeeEducations = trsEmployeeEducations;
	}

	public TrsEmployeeEducation addTrsEmployeeEducation(TrsEmployeeEducation trsEmployeeEducation) {
		getTrsEmployeeEducations().add(trsEmployeeEducation);
		trsEmployeeEducation.setMstEducation(this);

		return trsEmployeeEducation;
	}

	public TrsEmployeeEducation removeTrsEmployeeEducation(TrsEmployeeEducation trsEmployeeEducation) {
		getTrsEmployeeEducations().remove(trsEmployeeEducation);
		trsEmployeeEducation.setMstEducation(null);

		return trsEmployeeEducation;
	}

}