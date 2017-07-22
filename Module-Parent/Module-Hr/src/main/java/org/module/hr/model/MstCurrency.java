package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mst_currency database table.
 * 
 */
@Entity
@Table(name="mst_currency")
@NamedQuery(name="MstCurrency.findAll", query="SELECT m FROM MstCurrency m")
public class MstCurrency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_currency")
	private String idCurrency;

	@Column(name="currency_name")
	private String currencyName;

	//bi-directional many-to-one association to MstPaygradeCurrency
	@OneToMany(mappedBy="mstCurrency")
	private List<MstPaygradeCurrency> mstPaygradeCurrencies;

	public MstCurrency() {
	}

	public String getIdCurrency() {
		return this.idCurrency;
	}

	public void setIdCurrency(String idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public List<MstPaygradeCurrency> getMstPaygradeCurrencies() {
		return this.mstPaygradeCurrencies;
	}

	public void setMstPaygradeCurrencies(List<MstPaygradeCurrency> mstPaygradeCurrencies) {
		this.mstPaygradeCurrencies = mstPaygradeCurrencies;
	}

	public MstPaygradeCurrency addMstPaygradeCurrency(MstPaygradeCurrency mstPaygradeCurrency) {
		getMstPaygradeCurrencies().add(mstPaygradeCurrency);
		mstPaygradeCurrency.setMstCurrency(this);

		return mstPaygradeCurrency;
	}

	public MstPaygradeCurrency removeMstPaygradeCurrency(MstPaygradeCurrency mstPaygradeCurrency) {
		getMstPaygradeCurrencies().remove(mstPaygradeCurrency);
		mstPaygradeCurrency.setMstCurrency(null);

		return mstPaygradeCurrency;
	}

}