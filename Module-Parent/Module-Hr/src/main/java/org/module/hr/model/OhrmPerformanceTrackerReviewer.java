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
@Table(name = "ohrm_performance_tracker_reviewer", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPerformanceTrackerReviewer.findAll", query = "SELECT o FROM OhrmPerformanceTrackerReviewer o"),
    @NamedQuery(name = "OhrmPerformanceTrackerReviewer.findById", query = "SELECT o FROM OhrmPerformanceTrackerReviewer o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmPerformanceTrackerReviewer.findByAddedDate", query = "SELECT o FROM OhrmPerformanceTrackerReviewer o WHERE o.addedDate = :addedDate"),
    @NamedQuery(name = "OhrmPerformanceTrackerReviewer.findByStatus", query = "SELECT o FROM OhrmPerformanceTrackerReviewer o WHERE o.status = :status")})
public class OhrmPerformanceTrackerReviewer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "status")
    private Integer status;
    @JoinColumn(name = "performance_track_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmPerformanceTrack performanceTrackId;
    @JoinColumn(name = "reviewer_id", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee reviewerId;

    public OhrmPerformanceTrackerReviewer() {
    }

    public OhrmPerformanceTrackerReviewer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        if (!(object instanceof OhrmPerformanceTrackerReviewer)) {
            return false;
        }
        OhrmPerformanceTrackerReviewer other = (OhrmPerformanceTrackerReviewer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPerformanceTrackerReviewer[ id=" + id + " ]";
    }
    
}
