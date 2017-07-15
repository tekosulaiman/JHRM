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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_work_week", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmWorkWeek.findAll", query = "SELECT o FROM OhrmWorkWeek o"),
    @NamedQuery(name = "OhrmWorkWeek.findById", query = "SELECT o FROM OhrmWorkWeek o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmWorkWeek.findByMon", query = "SELECT o FROM OhrmWorkWeek o WHERE o.mon = :mon"),
    @NamedQuery(name = "OhrmWorkWeek.findByTue", query = "SELECT o FROM OhrmWorkWeek o WHERE o.tue = :tue"),
    @NamedQuery(name = "OhrmWorkWeek.findByWed", query = "SELECT o FROM OhrmWorkWeek o WHERE o.wed = :wed"),
    @NamedQuery(name = "OhrmWorkWeek.findByThu", query = "SELECT o FROM OhrmWorkWeek o WHERE o.thu = :thu"),
    @NamedQuery(name = "OhrmWorkWeek.findByFri", query = "SELECT o FROM OhrmWorkWeek o WHERE o.fri = :fri"),
    @NamedQuery(name = "OhrmWorkWeek.findBySat", query = "SELECT o FROM OhrmWorkWeek o WHERE o.sat = :sat"),
    @NamedQuery(name = "OhrmWorkWeek.findBySun", query = "SELECT o FROM OhrmWorkWeek o WHERE o.sun = :sun")})
public class OhrmWorkWeek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mon")
    private short mon;
    @Basic(optional = false)
    @Column(name = "tue")
    private short tue;
    @Basic(optional = false)
    @Column(name = "wed")
    private short wed;
    @Basic(optional = false)
    @Column(name = "thu")
    private short thu;
    @Basic(optional = false)
    @Column(name = "fri")
    private short fri;
    @Basic(optional = false)
    @Column(name = "sat")
    private short sat;
    @Basic(optional = false)
    @Column(name = "sun")
    private short sun;
    @JoinColumn(name = "operational_country_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmOperationalCountry operationalCountryId;

    public OhrmWorkWeek() {
    }

    public OhrmWorkWeek(Integer id) {
        this.id = id;
    }

    public OhrmWorkWeek(Integer id, short mon, short tue, short wed, short thu, short fri, short sat, short sun) {
        this.id = id;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getMon() {
        return mon;
    }

    public void setMon(short mon) {
        this.mon = mon;
    }

    public short getTue() {
        return tue;
    }

    public void setTue(short tue) {
        this.tue = tue;
    }

    public short getWed() {
        return wed;
    }

    public void setWed(short wed) {
        this.wed = wed;
    }

    public short getThu() {
        return thu;
    }

    public void setThu(short thu) {
        this.thu = thu;
    }

    public short getFri() {
        return fri;
    }

    public void setFri(short fri) {
        this.fri = fri;
    }

    public short getSat() {
        return sat;
    }

    public void setSat(short sat) {
        this.sat = sat;
    }

    public short getSun() {
        return sun;
    }

    public void setSun(short sun) {
        this.sun = sun;
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
        if (!(object instanceof OhrmWorkWeek)) {
            return false;
        }
        OhrmWorkWeek other = (OhrmWorkWeek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmWorkWeek[ id=" + id + " ]";
    }
    
}
