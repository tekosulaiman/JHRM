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
import javax.persistence.ManyToOne;
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
@Table(name = "ohrm_operational_country", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmOperationalCountry.findAll", query = "SELECT o FROM OhrmOperationalCountry o"),
    @NamedQuery(name = "OhrmOperationalCountry.findById", query = "SELECT o FROM OhrmOperationalCountry o WHERE o.id = :id")})
public class OhrmOperationalCountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "operationalCountryId")
    private List<OhrmLeaveType> ohrmLeaveTypeList;
    @JoinColumn(name = "country_code", referencedColumnName = "cou_code")
    @ManyToOne
    private HsHrCountry countryCode;
    @OneToMany(mappedBy = "operationalCountryId")
    private List<OhrmHoliday> ohrmHolidayList;
    @OneToMany(mappedBy = "operationalCountryId")
    private List<OhrmWorkWeek> ohrmWorkWeekList;

    public OhrmOperationalCountry() {
    }

    public OhrmOperationalCountry(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public List<OhrmLeaveType> getOhrmLeaveTypeList() {
        return ohrmLeaveTypeList;
    }

    public void setOhrmLeaveTypeList(List<OhrmLeaveType> ohrmLeaveTypeList) {
        this.ohrmLeaveTypeList = ohrmLeaveTypeList;
    }

    public HsHrCountry getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(HsHrCountry countryCode) {
        this.countryCode = countryCode;
    }

    @XmlTransient
    public List<OhrmHoliday> getOhrmHolidayList() {
        return ohrmHolidayList;
    }

    public void setOhrmHolidayList(List<OhrmHoliday> ohrmHolidayList) {
        this.ohrmHolidayList = ohrmHolidayList;
    }

    @XmlTransient
    public List<OhrmWorkWeek> getOhrmWorkWeekList() {
        return ohrmWorkWeekList;
    }

    public void setOhrmWorkWeekList(List<OhrmWorkWeek> ohrmWorkWeekList) {
        this.ohrmWorkWeekList = ohrmWorkWeekList;
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
        if (!(object instanceof OhrmOperationalCountry)) {
            return false;
        }
        OhrmOperationalCountry other = (OhrmOperationalCountry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmOperationalCountry[ id=" + id + " ]";
    }
    
}
