package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the trs_employee_immigration database table.
 * 
 */
@Entity
@Table(name="trs_employee_immigration")
@NamedQuery(name="TrsEmployeeImmigration.findAll", query="SELECT t FROM TrsEmployeeImmigration t")
public class TrsEmployeeImmigration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_immigration")
	private Integer idImmigration;

	private String comment;

	private String document;

	@Temporal(TemporalType.DATE)
	@Column(name="eligible_review")
	private Date eligibleReview;

	@Column(name="eligible_status")
	private String eligibleStatus;

	@Temporal(TemporalType.DATE)
	@Column(name="expired_date")
	private Date expiredDate;

	@Column(name="id_country")
	private String idCountry;

	@Temporal(TemporalType.DATE)
	@Column(name="issued_date")
	private Date issuedDate;

	private Integer number;

	//bi-directional many-to-one association to TrsEmployee
	@ManyToOne
	@JoinColumn(name="id_employee")
	private TrsEmployee trsEmployee;

	public TrsEmployeeImmigration() {
	}

	public Integer getIdImmigration() {
		return this.idImmigration;
	}

	public void setIdImmigration(Integer idImmigration) {
		this.idImmigration = idImmigration;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Date getEligibleReview() {
		return this.eligibleReview;
	}

	public void setEligibleReview(Date eligibleReview) {
		this.eligibleReview = eligibleReview;
	}

	public String getEligibleStatus() {
		return this.eligibleStatus;
	}

	public void setEligibleStatus(String eligibleStatus) {
		this.eligibleStatus = eligibleStatus;
	}

	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getIdCountry() {
		return this.idCountry;
	}

	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	public Date getIssuedDate() {
		return this.issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public TrsEmployee getTrsEmployee() {
		return this.trsEmployee;
	}

	public void setTrsEmployee(TrsEmployee trsEmployee) {
		this.trsEmployee = trsEmployee;
	}

}