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
@Table(name = "mst_location", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLocation.findAll", query = "SELECT m FROM MstLocation m"),
    @NamedQuery(name = "MstLocation.findByIdLocation", query = "SELECT m FROM MstLocation m WHERE m.idLocation = :idLocation"),
    @NamedQuery(name = "MstLocation.findByName", query = "SELECT m FROM MstLocation m WHERE m.name = :name"),
    @NamedQuery(name = "MstLocation.findByCountryCode", query = "SELECT m FROM MstLocation m WHERE m.countryCode = :countryCode"),
    @NamedQuery(name = "MstLocation.findByProvince", query = "SELECT m FROM MstLocation m WHERE m.province = :province"),
    @NamedQuery(name = "MstLocation.findByCity", query = "SELECT m FROM MstLocation m WHERE m.city = :city"),
    @NamedQuery(name = "MstLocation.findByAddress", query = "SELECT m FROM MstLocation m WHERE m.address = :address"),
    @NamedQuery(name = "MstLocation.findByZipCode", query = "SELECT m FROM MstLocation m WHERE m.zipCode = :zipCode"),
    @NamedQuery(name = "MstLocation.findByPhone", query = "SELECT m FROM MstLocation m WHERE m.phone = :phone"),
    @NamedQuery(name = "MstLocation.findByFax", query = "SELECT m FROM MstLocation m WHERE m.fax = :fax"),
    @NamedQuery(name = "MstLocation.findByNotes", query = "SELECT m FROM MstLocation m WHERE m.notes = :notes")})
public class MstLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_location")
    private Integer idLocation;
    @Column(name = "name")
    private String name;
    @Column(name = "country_code")
    private String countryCode;
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

    public MstLocation() {
    }

    public MstLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLocation)) {
            return false;
        }
        MstLocation other = (MstLocation) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstLocation[ idLocation=" + idLocation + " ]";
    }
    
}
