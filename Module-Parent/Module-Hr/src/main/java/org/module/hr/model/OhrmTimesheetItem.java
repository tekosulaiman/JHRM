/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ohrm_timesheet_item", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmTimesheetItem.findAll", query = "SELECT o FROM OhrmTimesheetItem o"),
    @NamedQuery(name = "OhrmTimesheetItem.findByTimesheetItemId", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.timesheetItemId = :timesheetItemId"),
    @NamedQuery(name = "OhrmTimesheetItem.findByTimesheetId", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.timesheetId = :timesheetId"),
    @NamedQuery(name = "OhrmTimesheetItem.findByDate", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.date = :date"),
    @NamedQuery(name = "OhrmTimesheetItem.findByDuration", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.duration = :duration"),
    @NamedQuery(name = "OhrmTimesheetItem.findByProjectId", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.projectId = :projectId"),
    @NamedQuery(name = "OhrmTimesheetItem.findByEmployeeId", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.employeeId = :employeeId"),
    @NamedQuery(name = "OhrmTimesheetItem.findByActivityId", query = "SELECT o FROM OhrmTimesheetItem o WHERE o.activityId = :activityId")})
public class OhrmTimesheetItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timesheet_item_id")
    private Long timesheetItemId;
    @Basic(optional = false)
    @Column(name = "timesheet_id")
    private long timesheetId;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "duration")
    private BigInteger duration;
    @Lob
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "project_id")
    private long projectId;
    @Basic(optional = false)
    @Column(name = "employee_id")
    private long employeeId;
    @Basic(optional = false)
    @Column(name = "activity_id")
    private long activityId;

    public OhrmTimesheetItem() {
    }

    public OhrmTimesheetItem(Long timesheetItemId) {
        this.timesheetItemId = timesheetItemId;
    }

    public OhrmTimesheetItem(Long timesheetItemId, long timesheetId, Date date, long projectId, long employeeId, long activityId) {
        this.timesheetItemId = timesheetItemId;
        this.timesheetId = timesheetId;
        this.date = date;
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.activityId = activityId;
    }

    public Long getTimesheetItemId() {
        return timesheetItemId;
    }

    public void setTimesheetItemId(Long timesheetItemId) {
        this.timesheetItemId = timesheetItemId;
    }

    public long getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesheetItemId != null ? timesheetItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmTimesheetItem)) {
            return false;
        }
        OhrmTimesheetItem other = (OhrmTimesheetItem) object;
        if ((this.timesheetItemId == null && other.timesheetItemId != null) || (this.timesheetItemId != null && !this.timesheetItemId.equals(other.timesheetItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmTimesheetItem[ timesheetItemId=" + timesheetItemId + " ]";
    }
    
}
