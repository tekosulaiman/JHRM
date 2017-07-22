package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_paygrade_currency database table.
 * 
 */
@Entity
@Table(name="mst_paygrade_currency")
@NamedQuery(name="MstPaygradeCurrency.findAll", query="SELECT m FROM MstPaygradeCurrency m")
public class MstPaygradeCurrency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_paygrade_currency")
	private Integer idPaygradeCurrency;

	@Column(name="max_salary")
	private Long maxSalary;

	@Column(name="min_salary")
	private Long minSalary;

	//bi-directional many-to-one association to MstCurrency
	@ManyToOne
	@JoinColumn(name="id_currency")
	private MstCurrency mstCurrency;

	//bi-directional many-to-one association to MstPaygrade
	@ManyToOne
	@JoinColumn(name="id_paygrade")
	private MstPaygrade mstPaygrade;

	public MstPaygradeCurrency() {
	}

	public Integer getIdPaygradeCurrency() {
		return this.idPaygradeCurrency;
	}

	public void setIdPaygradeCurrency(Integer idPaygradeCurrency) {
		this.idPaygradeCurrency = idPaygradeCurrency;
	}

	public Long getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Long getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public MstCurrency getMstCurrency() {
		return this.mstCurrency;
	}

	public void setMstCurrency(MstCurrency mstCurrency) {
		this.mstCurrency = mstCurrency;
	}

	public MstPaygrade getMstPaygrade() {
		return this.mstPaygrade;
	}

	public void setMstPaygrade(MstPaygrade mstPaygrade) {
		this.mstPaygrade = mstPaygrade;
	}

}