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
 * @author 10991044
 */
@Entity
@Table(name = "mst_holiday", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstHoliday.findAll", query = "SELECT m FROM MstHoliday m"),
    @NamedQuery(name = "MstHoliday.findByIdHoliday", query = "SELECT m FROM MstHoliday m WHERE m.idHoliday = :idHoliday"),
    @NamedQuery(name = "MstHoliday.findByHolidayName", query = "SELECT m FROM MstHoliday m WHERE m.holidayName = :holidayName"),
    @NamedQuery(name = "MstHoliday.findByDuration", query = "SELECT m FROM MstHoliday m WHERE m.duration = :duration")})
public class MstHoliday implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_holiday")
    private Integer idHoliday;
    @Column(name = "holiday_name")
    private String holidayName;
    @Column(name = "duration")
    private Integer duration;

    public MstHoliday() {
    }

    public MstHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public Integer getIdHoliday() {
        return idHoliday;
    }

    public void setIdHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoliday != null ? idHoliday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstHoliday)) {
            return false;
        }
        MstHoliday other = (MstHoliday) object;
        if ((this.idHoliday == null && other.idHoliday != null) || (this.idHoliday != null && !this.idHoliday.equals(other.idHoliday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstHoliday[ idHoliday=" + idHoliday + " ]";
    }
    
}
