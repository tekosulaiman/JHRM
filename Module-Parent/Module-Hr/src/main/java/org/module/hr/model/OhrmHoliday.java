/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_holiday", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmHoliday.findAll", query = "SELECT o FROM OhrmHoliday o"),
    @NamedQuery(name = "OhrmHoliday.findById", query = "SELECT o FROM OhrmHoliday o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmHoliday.findByDate", query = "SELECT o FROM OhrmHoliday o WHERE o.date = :date"),
    @NamedQuery(name = "OhrmHoliday.findByRecurring", query = "SELECT o FROM OhrmHoliday o WHERE o.recurring = :recurring"),
    @NamedQuery(name = "OhrmHoliday.findByLength", query = "SELECT o FROM OhrmHoliday o WHERE o.length = :length")})
public class OhrmHoliday implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "recurring")
    private Short recurring;
    @Column(name = "length")
    private Integer length;
    @JoinColumn(name = "operational_country_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmOperationalCountry operationalCountryId;

    public OhrmHoliday() {
    }

    public OhrmHoliday(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getRecurring() {
        return recurring;
    }

    public void setRecurring(Short recurring) {
        this.recurring = recurring;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public OhrmOperationalCountry getOperationalCountryId() {
        return operationalCountryId;
    }

    public void setOperationalCountryId(OhrmOperationalCountry operationalCountryId) {
        this.operationalCountryId = operationalCountryId;
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
        if (!(object instanceof OhrmHoliday)) {
            return false;
        }
        OhrmHoliday other = (OhrmHoliday) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmHoliday[ id=" + id + " ]";
    }
    
}
