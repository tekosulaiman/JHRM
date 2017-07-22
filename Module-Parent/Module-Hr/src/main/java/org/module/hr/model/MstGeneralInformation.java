package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mst_general_information database table.
 * 
 */
@Entity
@Table(name="mst_general_information")
@NamedQuery(name="MstGeneralInformation.findAll", query="SELECT m FROM MstGeneralInformation m")
public class MstGeneralInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_general_information")
	private Integer idGeneralInformation;

	private String city;

	private String country;

	private String email;

	private String fax;

	private String name;

	private String note;

	private String phone;

	private String province;

	@Column(name="registration_number")
	private String registrationNumber;

	private String street1;

	private String street2;

	@Column(name="tax_id")
	private String taxId;

	@Column(name="zip_code")
	private String zipCode;

	public MstGeneralInformation() {
	}

	public Integer getIdGeneralInformation() {
		return this.idGeneralInformation;
	}

	public void setIdGeneralInformation(Integer idGeneralInformation) {
		this.idGeneralInformation = idGeneralInformation;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getTaxId() {
		return this.taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}