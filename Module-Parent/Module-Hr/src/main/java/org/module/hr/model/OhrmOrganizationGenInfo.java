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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "ohrm_organization_gen_info", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOrganizationGenInfo.findAll", query = "SELECT o FROM OhrmOrganizationGenInfo o"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findById", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByName", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByTaxId", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.taxId = :taxId"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByRegistrationNumber", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.registrationNumber = :registrationNumber"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByPhone", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.phone = :phone"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByFax", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.fax = :fax"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByEmail", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.email = :email"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByCountry", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.country = :country"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByProvince", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.province = :province"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByCity", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.city = :city"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByZipCode", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.zipCode = :zipCode"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByStreet1", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.street1 = :street1"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByStreet2", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.street2 = :street2"),
    @NamedQuery(name = "OhrmOrganizationGenInfo.findByNote", query = "SELECT o FROM OhrmOrganizationGenInfo o WHERE o.note = :note")})
public class OhrmOrganizationGenInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
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

    public OhrmOrganizationGenInfo() {
    }

    public OhrmOrganizationGenInfo(Integer id) {
        this.id = id;
    }

    public OhrmOrganizationGenInfo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmOrganizationGenInfo)) {
            return false;
        }
        OhrmOrganizationGenInfo other = (OhrmOrganizationGenInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOrganizationGenInfo[ id=" + id + " ]";
    }
    
}
