package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_paygrade database table.
 * 
 */
@Entity
@Table(name="mst_paygrade")
@NamedQuery(name="MstPaygrade.findAll", query="SELECT m FROM MstPaygrade m")
public class MstPaygrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_paygrade")
	private Integer idPaygrade;

	@Column(name="paygrade_name")
	private String paygradeName;

	//bi-directional many-to-one association to MstPaygradeCurrency
	@OneToMany(mappedBy="mstPaygrade")
	private List<MstPaygradeCurrency> mstPaygradeCurrencies;

	public MstPaygrade() {
	}

	public Integer getIdPaygrade() {
		return this.idPaygrade;
	}

	public void setIdPaygrade(Integer idPaygrade) {
		this.idPaygrade = idPaygrade;
	}

	public String getPaygradeName() {
		return this.paygradeName;
	}

	public void setPaygradeName(String paygradeName) {
		this.paygradeName = paygradeName;
	}

	public List<MstPaygradeCurrency> getMstPaygradeCurrencies() {
		return this.mstPaygradeCurrencies;
	}

	public void setMstPaygradeCurrencies(List<MstPaygradeCurrency> mstPaygradeCurrencies) {
		this.mstPaygradeCurrencies = mstPaygradeCurrencies;
	}

	public MstPaygradeCurrency addMstPaygradeCurrency(MstPaygradeCurrency mstPaygradeCurrency) {
		getMstPaygradeCurrencies().add(mstPaygradeCurrency);
		mstPaygradeCurrency.setMstPaygrade(this);

		return mstPaygradeCurrency;
	}

	public MstPaygradeCurrency removeMstPaygradeCurrency(MstPaygradeCurrency mstPaygradeCurrency) {
		getMstPaygradeCurrencies().remove(mstPaygradeCurrency);
		mstPaygradeCurrency.setMstPaygrade(null);

		return mstPaygradeCurrency;
	}

}