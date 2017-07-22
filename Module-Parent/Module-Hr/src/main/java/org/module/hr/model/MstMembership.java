package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_membership database table.
 * 
 */
@Entity
@Table(name="mst_membership")
@NamedQuery(name="MstMembership.findAll", query="SELECT m FROM MstMembership m")
public class MstMembership implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_membership")
	private Integer idMembership;

	@Column(name="name_membership")
	private String nameMembership;

	//bi-directional many-to-one association to TrsEmployeeMembership
	@OneToMany(mappedBy="mstMembership")
	private List<TrsEmployeeMembership> trsEmployeeMemberships;

	public MstMembership() {
	}

	public Integer getIdMembership() {
		return this.idMembership;
	}

	public void setIdMembership(Integer idMembership) {
		this.idMembership = idMembership;
	}

	public String getNameMembership() {
		return this.nameMembership;
	}

	public void setNameMembership(String nameMembership) {
		this.nameMembership = nameMembership;
	}

	public List<TrsEmployeeMembership> getTrsEmployeeMemberships() {
		return this.trsEmployeeMemberships;
	}

	public void setTrsEmployeeMemberships(List<TrsEmployeeMembership> trsEmployeeMemberships) {
		this.trsEmployeeMemberships = trsEmployeeMemberships;
	}

	public TrsEmployeeMembership addTrsEmployeeMembership(TrsEmployeeMembership trsEmployeeMembership) {
		getTrsEmployeeMemberships().add(trsEmployeeMembership);
		trsEmployeeMembership.setMstMembership(this);

		return trsEmployeeMembership;
	}

	public TrsEmployeeMembership removeTrsEmployeeMembership(TrsEmployeeMembership trsEmployeeMembership) {
		getTrsEmployeeMemberships().remove(trsEmployeeMembership);
		trsEmployeeMembership.setMstMembership(null);

		return trsEmployeeMembership;
	}

}