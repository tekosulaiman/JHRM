/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_country", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrCountry.findAll", query = "SELECT h FROM HsHrCountry h"),
    @NamedQuery(name = "HsHrCountry.findByCouCode", query = "SELECT h FROM HsHrCountry h WHERE h.couCode = :couCode"),
    @NamedQuery(name = "HsHrCountry.findByName", query = "SELECT h FROM HsHrCountry h WHERE h.name = :name"),
    @NamedQuery(name = "HsHrCountry.findByCouName", query = "SELECT h FROM HsHrCountry h WHERE h.couName = :couName"),
    @NamedQuery(name = "HsHrCountry.findByIso3", query = "SELECT h FROM HsHrCountry h WHERE h.iso3 = :iso3"),
    @NamedQuery(name = "HsHrCountry.findByNumcode", query = "SELECT h FROM HsHrCountry h WHERE h.numcode = :numcode")})
public class HsHrCountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cou_code")
    private String couCode;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "cou_name")
    private String couName;
    @Column(name = "iso3")
    private String iso3;
    @Column(name = "numcode")
    private Short numcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
    private List<OhrmLocation> ohrmLocationList;
    @OneToMany(mappedBy = "countryCode")
    private List<OhrmOperationalCountry> ohrmOperationalCountryList;

    public HsHrCountry() {
    }

    public HsHrCountry(String couCode) {
        this.couCode = couCode;
    }

    public HsHrCountry(String couCode, String name, String couName) {
        this.couCode = couCode;
        this.name = name;
        this.couName = couName;
    }

    public String getCouCode() {
        return couCode;
    }

    public void setCouCode(String couCode) {
        this.couCode = couCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public Short getNumcode() {
        return numcode;
    }

    public void setNumcode(Short numcode) {
        this.numcode = numcode;
    }

    @XmlTransient
    public List<OhrmLocation> getOhrmLocationList() {
        return ohrmLocationList;
    }

    public void setOhrmLocationList(List<OhrmLocation> ohrmLocationList) {
        this.ohrmLocationList = ohrmLocationList;
    }

    @XmlTransient
    public List<OhrmOperationalCountry> getOhrmOperationalCountryList() {
        return ohrmOperationalCountryList;
    }

    public void setOhrmOperationalCountryList(List<OhrmOperationalCountry> ohrmOperationalCountryList) {
        this.ohrmOperationalCountryList = ohrmOperationalCountryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couCode != null ? couCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrCountry)) {
            return false;
        }
        HsHrCountry other = (HsHrCountry) object;
        if ((this.couCode == null && other.couCode != null) || (this.couCode != null && !this.couCode.equals(other.couCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrCountry[ couCode=" + couCode + " ]";
    }
    
}
