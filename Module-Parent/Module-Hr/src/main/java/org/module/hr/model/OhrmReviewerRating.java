/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_reviewer_rating", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmReviewerRating.findAll", query = "SELECT o FROM OhrmReviewerRating o"),
    @NamedQuery(name = "OhrmReviewerRating.findById", query = "SELECT o FROM OhrmReviewerRating o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmReviewerRating.findByRating", query = "SELECT o FROM OhrmReviewerRating o WHERE o.rating = :rating"),
    @NamedQuery(name = "OhrmReviewerRating.findByKpiId", query = "SELECT o FROM OhrmReviewerRating o WHERE o.kpiId = :kpiId")})
public class OhrmReviewerRating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "kpi_id")
    private Integer kpiId;
    @Lob
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "reviewer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmReviewer reviewerId;
    @JoinColumn(name = "review_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmPerformanceReview reviewId;

    public OhrmReviewerRating() {
    }

    public OhrmReviewerRating(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getKpiId() {
        return kpiId;
    }

    public void setKpiId(Integer kpiId) {
        this.kpiId = kpiId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OhrmReviewer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(OhrmReviewer reviewerId) {
        this.reviewerId = reviewerId;
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
        if (!(object instanceof OhrmReviewerRating)) {
            return false;
        }
        OhrmReviewerRating other = (OhrmReviewerRating) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmReviewerRating[ id=" + id + " ]";
    }
    
}
