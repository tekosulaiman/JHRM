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
@Table(name = "ohrm_performance_tracker_log", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findAll", query = "SELECT o FROM OhrmPerformanceTrackerLog o"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findById", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByLog", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.log = :log"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByComment", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.comment = :comment"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByStatus", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByAddedDate", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.addedDate = :addedDate"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByModifiedDate", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "OhrmPerformanceTrackerLog.findByAchievement", query = "SELECT o FROM OhrmPerformanceTrackerLog o WHERE o.achievement = :achievement")})
public class OhrmPerformanceTrackerLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "log")
    private String log;
    @Column(name = "comment")
    private String comment;
    @Column(name = "status")
    private Integer status;
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "achievement")
    private String achievement;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmUser userId;
    @JoinColumn(name = "performance_track_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmPerformanceTrack performanceTrackId;
    @JoinColumn(name = "reviewer_id", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee reviewerId;

    public OhrmPerformanceTrackerLog() {
    }

    public OhrmPerformanceTrackerLog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public OhrmUser getUserId() {
        return userId;
    }

    public void setUserId(OhrmUser userId) {
        this.userId = userId;
    }

    public OhrmPerformanceTrack getPerformanceTrackId() {
        return performanceTrackId;
    }

    public void setPerformanceTrackId(OhrmPerformanceTrack performanceTrackId) {
        this.performanceTrackId = performanceTrackId;
    }

    public HsHrEmployee getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(HsHrEmployee reviewerId) {
        this.reviewerId = reviewerId;
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
        if (!(object instanceof OhrmPerformanceTrackerLog)) {
            return false;
        }
        OhrmPerformanceTrackerLog other = (OhrmPerformanceTrackerLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPerformanceTrackerLog[ id=" + id + " ]";
    }
    
}
