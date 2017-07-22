/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_general_information", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstGeneralInformation.findAll", query = "SELECT m FROM MstGeneralInformation m"),
    @NamedQuery(name = "MstGeneralInformation.findByIdGeneralInformation", query = "SELECT m FROM MstGeneralInformation m WHERE m.idGeneralInformation = :idGeneralInformation"),
    @NamedQuery(name = "MstGeneralInformation.findByName", query = "SELECT m FROM MstGeneralInformation m WHERE m.name = :name"),
    @NamedQuery(name = "MstGeneralInformation.findByTaxId", query = "SELECT m FROM MstGeneralInformation m WHERE m.taxId = :taxId"),
    @NamedQuery(name = "MstGeneralInformation.findByRegistrationNumber", query = "SELECT m FROM MstGeneralInformation m WHERE m.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "MstGeneralInformation.findByPhone", query = "SELECT m FROM MstGeneralInformation m WHERE m.phone = :phone"),
    @NamedQuery(name = "MstGeneralInformation.findByFax", query = "SELECT m FROM MstGeneralInformation m WHERE m.fax = :fax"),
    @NamedQuery(name = "MstGeneralInformation.findByEmail", query = "SELECT m FROM MstGeneralInformation m WHERE m.email = :email"),
    @NamedQuery(name = "MstGeneralInformation.findByCountry", query = "SELECT m FROM MstGeneralInformation m WHERE m.country = :country"),
    @NamedQuery(name = "MstGeneralInformation.findByProvince", query = "SELECT m FROM MstGeneralInformation m WHERE m.province = :province"),
    @NamedQuery(name = "MstGeneralInformation.findByCity", query = "SELECT m FROM MstGeneralInformation m WHERE m.city = :city"),
    @NamedQuery(name = "MstGeneralInformation.findByZipCode", query = "SELECT m FROM MstGeneralInformation m WHERE m.zipCode = :zipCode"),
    @NamedQuery(name = "MstGeneralInformation.findByStreet1", query = "SELECT m FROM MstGeneralInformation m WHERE m.street1 = :street1"),
    @NamedQuery(name = "MstGeneralInformation.findByStreet2", query = "SELECT m FROM MstGeneralInformation m WHERE m.street2 = :street2"),
    @NamedQuery(name = "MstGeneralInformation.findByNote", query = "SELECT m FROM MstGeneralInformation m WHERE m.note = :note")})
public class MstGeneralInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_general_information")
    private Integer idGeneralInformation;
    @Column(name = "name")
    private String name;
    @Column(name = "tax_id")
    private String taxId;
    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "street1")
    private String street1;
    @Column(name = "street2")
    private String street2;
    @Column(name = "note")
    private String note;

    public MstGeneralInformation() {
    }

    public MstGeneralInformation(Integer idGeneralInformation) {
        this.idGeneralInformation = idGeneralInformation;
    }

    public Integer getIdGeneralInformation() {
        return idGeneralInformation;
    }

    public void setIdGeneralInformation(Integer idGeneralInformation) {
        this.idGeneralInformation = idGeneralInformation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGeneralInformation != null ? idGeneralInformation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstGeneralInformation)) {
            return false;
        }
        MstGeneralInformation other = (MstGeneralInformation) object;
        if ((this.idGeneralInformation == null && other.idGeneralInformation != null) || (this.idGeneralInformation != null && !this.idGeneralInformation.equals(other.idGeneralInformation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstGeneralInformation[ idGeneralInformation=" + idGeneralInformation + " ]";
    }
    
}
