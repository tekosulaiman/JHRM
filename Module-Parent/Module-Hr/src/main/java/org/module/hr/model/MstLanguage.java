package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_language database table.
 * 
 */
@Entity
@Table(name="mst_language")
@NamedQuery(name="MstLanguage.findAll", query="SELECT m FROM MstLanguage m")
public class MstLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_language")
	private Integer idLanguage;

	@Column(name="name_language")
	private String nameLanguage;

	//bi-directional many-to-one association to TrsEmployeeLanguage
	@OneToMany(mappedBy="mstLanguage")
	private List<TrsEmployeeLanguage> trsEmployeeLanguages;

	public MstLanguage() {
	}

	public Integer getIdLanguage() {
		return this.idLanguage;
	}

	public void setIdLanguage(Integer idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getNameLanguage() {
		return this.nameLanguage;
	}

	public void setNameLanguage(String nameLanguage) {
		this.nameLanguage = nameLanguage;
	}

	public List<TrsEmployeeLanguage> getTrsEmployeeLanguages() {
		return this.trsEmployeeLanguages;
	}

	public void setTrsEmployeeLanguages(List<TrsEmployeeLanguage> trsEmployeeLanguages) {
		this.trsEmployeeLanguages = trsEmployeeLanguages;
	}

	public TrsEmployeeLanguage addTrsEmployeeLanguage(TrsEmployeeLanguage trsEmployeeLanguage) {
		getTrsEmployeeLanguages().add(trsEmployeeLanguage);
		trsEmployeeLanguage.setMstLanguage(this);

		return trsEmployeeLanguage;
	}

	public TrsEmployeeLanguage removeTrsEmployeeLanguage(TrsEmployeeLanguage trsEmployeeLanguage) {
		getTrsEmployeeLanguages().remove(trsEmployeeLanguage);
		trsEmployeeLanguage.setMstLanguage(null);

		return trsEmployeeLanguage;
	}

}