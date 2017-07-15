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
import javax.persistence.Lob;
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
@Table(name = "ohrm_reviewer", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmReviewer.findAll", query = "SELECT o FROM OhrmReviewer o"),
    @NamedQuery(name = "OhrmReviewer.findById", query = "SELECT o FROM OhrmReviewer o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmReviewer.findByEmployeeNumber", query = "SELECT o FROM OhrmReviewer o WHERE o.employeeNumber = :employeeNumber"),
    @NamedQuery(name = "OhrmReviewer.findByStatus", query = "SELECT o FROM OhrmReviewer o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmReviewer.findByReviewerGroupId", query = "SELECT o FROM OhrmReviewer o WHERE o.reviewerGroupId = :reviewerGroupId"),
    @NamedQuery(name = "OhrmReviewer.findByCompletedDate", query = "SELECT o FROM OhrmReviewer o WHERE o.completedDate = :completedDate")})
public class OhrmReviewer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "employee_number")
    private Integer employeeNumber;
    @Column(name = "status")
    private Integer status;
    @Column(name = "reviewer_group_id")
    private Integer reviewerGroupId;
    @Column(name = "completed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;
    @Lob
    @Column(name = "comment")
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewerId")
    private List<OhrmReviewerRating> ohrmReviewerRatingList;
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmPerformanceReview reviewId;

    public OhrmReviewer() {
    }

    public OhrmReviewer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getReviewerGroupId() {
        return reviewerGroupId;
    }

    public void setReviewerGroupId(Integer reviewerGroupId) {
        this.reviewerGroupId = reviewerGroupId;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public List<OhrmReviewerRating> getOhrmReviewerRatingList() {
        return ohrmReviewerRatingList;
    }

    public void setOhrmReviewerRatingList(List<OhrmReviewerRating> ohrmReviewerRatingList) {
        this.ohrmReviewerRatingList = ohrmReviewerRatingList;
    }

    public OhrmPerformanceReview getReviewId() {
        return reviewId;
    }

    public void setReviewId(OhrmPerformanceReview reviewId) {
        this.reviewId = reviewId;
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
        if (!(object instanceof OhrmReviewer)) {
            return false;
        }
        OhrmReviewer other = (OhrmReviewer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmReviewer[ id=" + id + " ]";
    }
    
}
