package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_license database table.
 * 
 */
@Entity
@Table(name="mst_license")
@NamedQuery(name="MstLicense.findAll", query="SELECT m FROM MstLicense m")
public class MstLicense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_license")
	private Integer idLicense;

	@Column(name="name_license")
	private String nameLicense;

	//bi-directional many-to-one association to TrsEmployeeLicense
	@OneToMany(mappedBy="mstLicense")
	private List<TrsEmployeeLicense> trsEmployeeLicenses;

	public MstLicense() {
	}

	public Integer getIdLicense() {
		return this.idLicense;
	}

	public void setIdLicense(Integer idLicense) {
		this.idLicense = idLicense;
	}

	public String getNameLicense() {
		return this.nameLicense;
	}

	public void setNameLicense(String nameLicense) {
		this.nameLicense = nameLicense;
	}

	public List<TrsEmployeeLicense> getTrsEmployeeLicenses() {
		return this.trsEmployeeLicenses;
	}

	public void setTrsEmployeeLicenses(List<TrsEmployeeLicense> trsEmployeeLicenses) {
		this.trsEmployeeLicenses = trsEmployeeLicenses;
	}

	public TrsEmployeeLicense addTrsEmployeeLicens(TrsEmployeeLicense trsEmployeeLicens) {
		getTrsEmployeeLicenses().add(trsEmployeeLicens);
		trsEmployeeLicens.setMstLicense(this);

		return trsEmployeeLicens;
	}

	public TrsEmployeeLicense removeTrsEmployeeLicens(TrsEmployeeLicense trsEmployeeLicens) {
		getTrsEmployeeLicenses().remove(trsEmployeeLicens);
		trsEmployeeLicens.setMstLicense(null);

		return trsEmployeeLicens;
	}

}