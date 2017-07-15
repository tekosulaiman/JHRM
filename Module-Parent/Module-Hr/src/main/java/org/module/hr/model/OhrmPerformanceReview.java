/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
@Table(name = "ohrm_performance_review", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmPerformanceReview.findAll", query = "SELECT o FROM OhrmPerformanceReview o"),
    @NamedQuery(name = "OhrmPerformanceReview.findById", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmPerformanceReview.findByStatusId", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.statusId = :statusId"),
    @NamedQuery(name = "OhrmPerformanceReview.findByWorkPeriodStart", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.workPeriodStart = :workPeriodStart"),
    @NamedQuery(name = "OhrmPerformanceReview.findByWorkPeriodEnd", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.workPeriodEnd = :workPeriodEnd"),
    @NamedQuery(name = "OhrmPerformanceReview.findByJobTitleCode", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.jobTitleCode = :jobTitleCode"),
    @NamedQuery(name = "OhrmPerformanceReview.findByDepartmentId", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.departmentId = :departmentId"),
    @NamedQuery(name = "OhrmPerformanceReview.findByDueDate", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.dueDate = :dueDate"),
    @NamedQuery(name = "OhrmPerformanceReview.findByCompletedDate", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.completedDate = :completedDate"),
    @NamedQuery(name = "OhrmPerformanceReview.findByActivatedDate", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.activatedDate = :activatedDate"),
    @NamedQuery(name = "OhrmPerformanceReview.findByFinalRate", query = "SELECT o FROM OhrmPerformanceReview o WHERE o.finalRate = :finalRate")})
public class OhrmPerformanceReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "work_period_start")
    @Temporal(TemporalType.DATE)
    private Date workPeriodStart;
    @Column(name = "work_period_end")
    @Temporal(TemporalType.DATE)
    private Date workPeriodEnd;
    @Column(name = "job_title_code")
    private Integer jobTitleCode;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "due_date")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Column(name = "completed_date")
    @Temporal(TemporalType.DATE)
    private Date completedDate;
    @Column(name = "activated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activatedDate;
    @Lob
    @Column(name = "final_comment")
    private String finalComment;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "final_rate")
    private BigDecimal finalRate;
    @JoinColumn(name = "employee_number", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee employeeNumber;
    @OneToMany(mappedBy = "reviewId")
    private List<OhrmReviewerRating> ohrmReviewerRatingList;
    @OneToMany(mappedBy = "reviewId")
    private List<OhrmReviewer> ohrmReviewerList;

    public OhrmPerformanceReview() {
    }

    public OhrmPerformanceReview(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getWorkPeriodStart() {
        return workPeriodStart;
    }

    public void setWorkPeriodStart(Date workPeriodStart) {
        this.workPeriodStart = workPeriodStart;
    }

    public Date getWorkPeriodEnd() {
        return workPeriodEnd;
    }

    public void setWorkPeriodEnd(Date workPeriodEnd) {
        this.workPeriodEnd = workPeriodEnd;
    }

    public Integer getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(Integer jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    public String getFinalComment() {
        return finalComment;
    }

    public void setFinalComment(String finalComment) {
        this.finalComment = finalComment;
    }

    public BigDecimal getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(BigDecimal finalRate) {
        this.finalRate = finalRate;
    }

    public HsHrEmployee getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(HsHrEmployee employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @XmlTransient
    public List<OhrmReviewerRating> getOhrmReviewerRatingList() {
        return ohrmReviewerRatingList;
    }

    public void setOhrmReviewerRatingList(List<OhrmReviewerRating> ohrmReviewerRatingList) {
        this.ohrmReviewerRatingList = ohrmReviewerRatingList;
    }

    @XmlTransient
    public List<OhrmReviewer> getOhrmReviewerList() {
        return ohrmReviewerList;
    }

    public void setOhrmReviewerList(List<OhrmReviewer> ohrmReviewerList) {
        this.ohrmReviewerList = ohrmReviewerList;
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
        if (!(object instanceof OhrmPerformanceReview)) {
            return false;
        }
        OhrmPerformanceReview other = (OhrmPerformanceReview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmPerformanceReview[ id=" + id + " ]";
    }
    
}
