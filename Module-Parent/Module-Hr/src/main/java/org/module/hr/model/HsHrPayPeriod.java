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
@Table(name = "hs_hr_pay_period", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrPayPeriod.findAll", query = "SELECT h FROM HsHrPayPeriod h"),
    @NamedQuery(name = "HsHrPayPeriod.findById", query = "SELECT h FROM HsHrPayPeriod h WHERE h.id = :id"),
    @NamedQuery(name = "HsHrPayPeriod.findByStartDate", query = "SELECT h FROM HsHrPayPeriod h WHERE h.startDate = :startDate"),
    @NamedQuery(name = "HsHrPayPeriod.findByEndDate", query = "SELECT h FROM HsHrPayPeriod h WHERE h.endDate = :endDate"),
    @NamedQuery(name = "HsHrPayPeriod.findByCloseDate", query = "SELECT h FROM HsHrPayPeriod h WHERE h.closeDate = :closeDate"),
    @NamedQuery(name = "HsHrPayPeriod.findByCheckDate", query = "SELECT h FROM HsHrPayPeriod h WHERE h.checkDate = :checkDate"),
    @NamedQuery(name = "HsHrPayPeriod.findByTimesheetAprovalDueDate", query = "SELECT h FROM HsHrPayPeriod h WHERE h.timesheetAprovalDueDate = :timesheetAprovalDueDate")})
public class HsHrPayPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "close_date")
    @Temporal(TemporalType.DATE)
    private Date closeDate;
    @Basic(optional = false)
    @Column(name = "check_date")
    @Temporal(TemporalType.DATE)
    private Date checkDate;
    @Basic(optional = false)
    @Column(name = "timesheet_aproval_due_date")
    @Temporal(TemporalType.DATE)
    private Date timesheetAprovalDueDate;

    public HsHrPayPeriod() {
    }

    public HsHrPayPeriod(Integer id) {
        this.id = id;
    }

    public HsHrPayPeriod(Integer id, Date startDate, Date endDate, Date closeDate, Date checkDate, Date timesheetAprovalDueDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.closeDate = closeDate;
        this.checkDate = checkDate;
        this.timesheetAprovalDueDate = timesheetAprovalDueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Date getTimesheetAprovalDueDate() {
        return timesheetAprovalDueDate;
    }

    public void setTimesheetAprovalDueDate(Date timesheetAprovalDueDate) {
        this.timesheetAprovalDueDate = timesheetAprovalDueDate;
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
        if (!(object instanceof HsHrPayPeriod)) {
            return false;
        }
        HsHrPayPeriod other = (HsHrPayPeriod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrPayPeriod[ id=" + id + " ]";
    }
    
}
