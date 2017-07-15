/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_location", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLocation.findAll", query = "SELECT o FROM OhrmLocation o"),
    @NamedQuery(name = "OhrmLocation.findById", query = "SELECT o FROM OhrmLocation o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLocation.findByName", query = "SELECT o FROM OhrmLocation o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmLocation.findByProvince", query = "SELECT o FROM OhrmLocation o WHERE o.province = :province"),
    @NamedQuery(name = "OhrmLocation.findByCity", query = "SELECT o FROM OhrmLocation o WHERE o.city = :city"),
    @NamedQuery(name = "OhrmLocation.findByAddress", query = "SELECT o FROM OhrmLocation o WHERE o.address = :address"),
    @NamedQuery(name = "OhrmLocation.findByZipCode", query = "SELECT o FROM OhrmLocation o WHERE o.zipCode = :zipCode"),
    @NamedQuery(name = "OhrmLocation.findByPhone", query = "SELECT o FROM OhrmLocation o WHERE o.phone = :phone"),
    @NamedQuery(name = "OhrmLocation.findByFax", query = "SELECT o FROM OhrmLocation o WHERE o.fax = :fax"),
    @NamedQuery(name = "OhrmLocation.findByNotes", query = "SELECT o FROM OhrmLocation o WHERE o.notes = :notes")})
public class OhrmLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "notes")
    private String notes;
    @JoinTable(name = "hs_hr_emp_locations", joinColumns = {
        @JoinColumn(name = "location_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")})
    @ManyToMany
    private List<HsHrEmployee> hsHrEmployeeList;
    @JoinColumn(name = "country_code", referencedColumnName = "cou_code")
    @ManyToOne(optional = false)
    private HsHrCountry countryCode;

    public OhrmLocation() {
    }

    public OhrmLocation(Integer id) {
        this.id = id;
    }

    public OhrmLocation(Integer id, String name) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
    }

    public HsHrCountry getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(HsHrCountry countryCode) {
        this.countryCode = countryCode;
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
        if (!(object instanceof OhrmLocation)) {
            return false;
        }
        OhrmLocation other = (OhrmLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLocation[ id=" + id + " ]";
    }
    
}
