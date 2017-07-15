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
import javax.persistence.JoinColumn;
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
@Table(name = "ohrm_timesheet_action_log", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmTimesheetActionLog.findAll", query = "SELECT o FROM OhrmTimesheetActionLog o"),
    @NamedQuery(name = "OhrmTimesheetActionLog.findByTimesheetActionLogId", query = "SELECT o FROM OhrmTimesheetActionLog o WHERE o.timesheetActionLogId = :timesheetActionLogId"),
    @NamedQuery(name = "OhrmTimesheetActionLog.findByComment", query = "SELECT o FROM OhrmTimesheetActionLog o WHERE o.comment = :comment"),
    @NamedQuery(name = "OhrmTimesheetActionLog.findByAction", query = "SELECT o FROM OhrmTimesheetActionLog o WHERE o.action = :action"),
    @NamedQuery(name = "OhrmTimesheetActionLog.findByDateTime", query = "SELECT o FROM OhrmTimesheetActionLog o WHERE o.dateTime = :dateTime"),
    @NamedQuery(name = "OhrmTimesheetActionLog.findByTimesheetId", query = "SELECT o FROM OhrmTimesheetActionLog o WHERE o.timesheetId = :timesheetId")})
public class OhrmTimesheetActionLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "timesheet_action_log_id")
    private Long timesheetActionLogId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Basic(optional = false)
    @Column(name = "timesheet_id")
    private long timesheetId;
    @JoinColumn(name = "performed_by", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmUser performedBy;

    public OhrmTimesheetActionLog() {
    }

    public OhrmTimesheetActionLog(Long timesheetActionLogId) {
        this.timesheetActionLogId = timesheetActionLogId;
    }

    public OhrmTimesheetActionLog(Long timesheetActionLogId, Date dateTime, long timesheetId) {
        this.timesheetActionLogId = timesheetActionLogId;
        this.dateTime = dateTime;
        this.timesheetId = timesheetId;
    }

    public Long getTimesheetActionLogId() {
        return timesheetActionLogId;
    }

    public void setTimesheetActionLogId(Long timesheetActionLogId) {
        this.timesheetActionLogId = timesheetActionLogId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public long getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public OhrmUser getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(OhrmUser performedBy) {
        this.performedBy = performedBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesheetActionLogId != null ? timesheetActionLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmTimesheetActionLog)) {
            return false;
        }
        OhrmTimesheetActionLog other = (OhrmTimesheetActionLog) object;
        if ((this.timesheetActionLogId == null && other.timesheetActionLogId != null) || (this.timesheetActionLogId != null && !this.timesheetActionLogId.equals(other.timesheetActionLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmTimesheetActionLog[ timesheetActionLogId=" + timesheetActionLogId + " ]";
    }
    
}
