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
@Table(name = "ohrm_leave_period_history", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeavePeriodHistory.findAll", query = "SELECT o FROM OhrmLeavePeriodHistory o"),
    @NamedQuery(name = "OhrmLeavePeriodHistory.findById", query = "SELECT o FROM OhrmLeavePeriodHistory o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeavePeriodHistory.findByLeavePeriodStartMonth", query = "SELECT o FROM OhrmLeavePeriodHistory o WHERE o.leavePeriodStartMonth = :leavePeriodStartMonth"),
    @NamedQuery(name = "OhrmLeavePeriodHistory.findByLeavePeriodStartDay", query = "SELECT o FROM OhrmLeavePeriodHistory o WHERE o.leavePeriodStartDay = :leavePeriodStartDay"),
    @NamedQuery(name = "OhrmLeavePeriodHistory.findByCreatedAt", query = "SELECT o FROM OhrmLeavePeriodHistory o WHERE o.createdAt = :createdAt")})
public class OhrmLeavePeriodHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "leave_period_start_month")
    private int leavePeriodStartMonth;
    @Basic(optional = false)
    @Column(name = "leave_period_start_day")
    private int leavePeriodStartDay;
    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public OhrmLeavePeriodHistory() {
    }

    public OhrmLeavePeriodHistory(Integer id) {
        this.id = id;
    }

    public OhrmLeavePeriodHistory(Integer id, int leavePeriodStartMonth, int leavePeriodStartDay, Date createdAt) {
        this.id = id;
        this.leavePeriodStartMonth = leavePeriodStartMonth;
        this.leavePeriodStartDay = leavePeriodStartDay;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLeavePeriodStartMonth() {
        return leavePeriodStartMonth;
    }

    public void setLeavePeriodStartMonth(int leavePeriodStartMonth) {
        this.leavePeriodStartMonth = leavePeriodStartMonth;
    }

    public int getLeavePeriodStartDay() {
        return leavePeriodStartDay;
    }

    public void setLeavePeriodStartDay(int leavePeriodStartDay) {
        this.leavePeriodStartDay = leavePeriodStartDay;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof OhrmLeavePeriodHistory)) {
            return false;
        }
        OhrmLeavePeriodHistory other = (OhrmLeavePeriodHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeavePeriodHistory[ id=" + id + " ]";
    }
    
}
