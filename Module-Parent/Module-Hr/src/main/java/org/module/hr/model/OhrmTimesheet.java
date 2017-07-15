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
@Table(name = "ohrm_timesheet", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmTimesheet.findAll", query = "SELECT o FROM OhrmTimesheet o"),
    @NamedQuery(name = "OhrmTimesheet.findByTimesheetId", query = "SELECT o FROM OhrmTimesheet o WHERE o.timesheetId = :timesheetId"),
    @NamedQuery(name = "OhrmTimesheet.findByState", query = "SELECT o FROM OhrmTimesheet o WHERE o.state = :state"),
    @NamedQuery(name = "OhrmTimesheet.findByStartDate", query = "SELECT o FROM OhrmTimesheet o WHERE o.startDate = :startDate"),
    @NamedQuery(name = "OhrmTimesheet.findByEndDate", query = "SELECT o FROM OhrmTimesheet o WHERE o.endDate = :endDate"),
    @NamedQuery(name = "OhrmTimesheet.findByEmployeeId", query = "SELECT o FROM OhrmTimesheet o WHERE o.employeeId = :employeeId")})
public class OhrmTimesheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timesheet_id")
    private Long timesheetId;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "employee_id")
    private long employeeId;

    public OhrmTimesheet() {
    }

    public OhrmTimesheet(Long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public OhrmTimesheet(Long timesheetId, String state, Date startDate, Date endDate, long employeeId) {
        this.timesheetId = timesheetId;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
    }

    public Long getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(Long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesheetId != null ? timesheetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmTimesheet)) {
            return false;
        }
        OhrmTimesheet other = (OhrmTimesheet) object;
        if ((this.timesheetId == null && other.timesheetId != null) || (this.timesheetId != null && !this.timesheetId.equals(other.timesheetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmTimesheet[ timesheetId=" + timesheetId + " ]";
    }
    
}
