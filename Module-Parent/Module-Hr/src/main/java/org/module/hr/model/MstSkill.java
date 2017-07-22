package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_skill database table.
 * 
 */
@Entity
@Table(name="mst_skill")
@NamedQuery(name="MstSkill.findAll", query="SELECT m FROM MstSkill m")
public class MstSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_skill")
	private Integer idSkill;

	@Column(name="descpription_skill")
	private String descpriptionSkill;

	@Column(name="name_skill")
	private String nameSkill;

	//bi-directional many-to-one association to TrsEmployeeSkill
	@OneToMany(mappedBy="mstSkill")
	private List<TrsEmployeeSkill> trsEmployeeSkills;

	public MstSkill() {
	}

	public Integer getIdSkill() {
		return this.idSkill;
	}

	public void setIdSkill(Integer idSkill) {
		this.idSkill = idSkill;
	}

	public String getDescpriptionSkill() {
		return this.descpriptionSkill;
	}

	public void setDescpriptionSkill(String descpriptionSkill) {
		this.descpriptionSkill = descpriptionSkill;
	}

	public String getNameSkill() {
		return this.nameSkill;
	}

	public void setNameSkill(String nameSkill) {
		this.nameSkill = nameSkill;
	}

	public List<TrsEmployeeSkill> getTrsEmployeeSkills() {
		return this.trsEmployeeSkills;
	}

	public void setTrsEmployeeSkills(List<TrsEmployeeSkill> trsEmployeeSkills) {
		this.trsEmployeeSkills = trsEmployeeSkills;
	}

	public TrsEmployeeSkill addTrsEmployeeSkill(TrsEmployeeSkill trsEmployeeSkill) {
		getTrsEmployeeSkills().add(trsEmployeeSkill);
		trsEmployeeSkill.setMstSkill(this);

		return trsEmployeeSkill;
	}

	public TrsEmployeeSkill removeTrsEmployeeSkill(TrsEmployeeSkill trsEmployeeSkill) {
		getTrsEmployeeSkills().remove(trsEmployeeSkill);
		trsEmployeeSkill.setMstSkill(null);

		return trsEmployeeSkill;
	}

}