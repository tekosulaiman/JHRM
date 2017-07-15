/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_performance_track", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPerformanceTrack.findAll", query = "SELECT o FROM OhrmPerformanceTrack o"),
    @NamedQuery(name = "OhrmPerformanceTrack.findById", query = "SELECT o FROM OhrmPerformanceTrack o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmPerformanceTrack.findByTrackerName", query = "SELECT o FROM OhrmPerformanceTrack o WHERE o.trackerName = :trackerName"),
    @NamedQuery(name = "OhrmPerformanceTrack.findByAddedDate", query = "SELECT o FROM OhrmPerformanceTrack o WHERE o.addedDate = :addedDate"),
    @NamedQuery(name = "OhrmPerformanceTrack.findByStatus", query = "SELECT o FROM OhrmPerformanceTrack o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmPerformanceTrack.findByModifiedDate", query = "SELECT o FROM OhrmPerformanceTrack o WHERE o.modifiedDate = :modifiedDate")})
public class OhrmPerformanceTrack implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tracker_name")
    private String trackerName;
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "status")
    private Integer status;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee empNumber;
    @JoinColumn(name = "added_by", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee addedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "performanceTrackId")
    private List<OhrmPerformanceTrackerReviewer> ohrmPerformanceTrackerReviewerList;
    @OneToMany(mappedBy = "performanceTrackId")
    private List<OhrmPerformanceTrackerLog> ohrmPerformanceTrackerLogList;

    public OhrmPerformanceTrack() {
    }

    public OhrmPerformanceTrack(Integer id) {
        this.id = id;
    }

    public OhrmPerformanceTrack(Integer id, String trackerName) {
        this.id = id;
        this.trackerName = trackerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public HsHrEmployee getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(HsHrEmployee addedBy) {
        this.addedBy = addedBy;
    }

    @XmlTransient
    public List<OhrmPerformanceTrackerReviewer> getOhrmPerformanceTrackerReviewerList() {
        return ohrmPerformanceTrackerReviewerList;
    }

    public void setOhrmPerformanceTrackerReviewerList(List<OhrmPerformanceTrackerReviewer> ohrmPerformanceTrackerReviewerList) {
        this.ohrmPerformanceTrackerReviewerList = ohrmPerformanceTrackerReviewerList;
    }

    @XmlTransient
    public List<OhrmPerformanceTrackerLog> getOhrmPerformanceTrackerLogList() {
        return ohrmPerformanceTrackerLogList;
    }

    public void setOhrmPerformanceTrackerLogList(List<OhrmPerformanceTrackerLog> ohrmPerformanceTrackerLogList) {
        this.ohrmPerformanceTrackerLogList = ohrmPerformanceTrackerLogList;
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
        if (!(object instanceof OhrmPerformanceTrack)) {
            return false;
        }
        OhrmPerformanceTrack other = (OhrmPerformanceTrack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPerformanceTrack[ id=" + id + " ]";
    }
    
}
