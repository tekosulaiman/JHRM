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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ohrm_job_candidate_vacancy", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobCandidateVacancy.findAll", query = "SELECT o FROM OhrmJobCandidateVacancy o"),
    @NamedQuery(name = "OhrmJobCandidateVacancy.findById", query = "SELECT o FROM OhrmJobCandidateVacancy o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobCandidateVacancy.findByCandidateId", query = "SELECT o FROM OhrmJobCandidateVacancy o WHERE o.ohrmJobCandidateVacancyPK.candidateId = :candidateId"),
    @NamedQuery(name = "OhrmJobCandidateVacancy.findByVacancyId", query = "SELECT o FROM OhrmJobCandidateVacancy o WHERE o.ohrmJobCandidateVacancyPK.vacancyId = :vacancyId"),
    @NamedQuery(name = "OhrmJobCandidateVacancy.findByStatus", query = "SELECT o FROM OhrmJobCandidateVacancy o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmJobCandidateVacancy.findByAppliedDate", query = "SELECT o FROM OhrmJobCandidateVacancy o WHERE o.appliedDate = :appliedDate")})
public class OhrmJobCandidateVacancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmJobCandidateVacancyPK ohrmJobCandidateVacancyPK;
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "applied_date")
    @Temporal(TemporalType.DATE)
    private Date appliedDate;
    @OneToMany(mappedBy = "candidateVacancyId")
    private List<OhrmJobInterview> ohrmJobInterviewList;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmJobCandidate ohrmJobCandidate;
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmJobVacancy ohrmJobVacancy;

    public OhrmJobCandidateVacancy() {
    }

    public OhrmJobCandidateVacancy(OhrmJobCandidateVacancyPK ohrmJobCandidateVacancyPK) {
        this.ohrmJobCandidateVacancyPK = ohrmJobCandidateVacancyPK;
    }

    public OhrmJobCandidateVacancy(OhrmJobCandidateVacancyPK ohrmJobCandidateVacancyPK, String status, Date appliedDate) {
        this.ohrmJobCandidateVacancyPK = ohrmJobCandidateVacancyPK;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public OhrmJobCandidateVacancy(int candidateId, int vacancyId) {
        this.ohrmJobCandidateVacancyPK = new OhrmJobCandidateVacancyPK(candidateId, vacancyId);
    }

    public OhrmJobCandidateVacancyPK getOhrmJobCandidateVacancyPK() {
        return ohrmJobCandidateVacancyPK;
    }

    public void setOhrmJobCandidateVacancyPK(OhrmJobCandidateVacancyPK ohrmJobCandidateVacancyPK) {
        this.ohrmJobCandidateVacancyPK = ohrmJobCandidateVacancyPK;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    @XmlTransient
    public List<OhrmJobInterview> getOhrmJobInterviewList() {
        return ohrmJobInterviewList;
    }

    public void setOhrmJobInterviewList(List<OhrmJobInterview> ohrmJobInterviewList) {
        this.ohrmJobInterviewList = ohrmJobInterviewList;
    }

    public OhrmJobCandidate getOhrmJobCandidate() {
        return ohrmJobCandidate;
    }

    public void setOhrmJobCandidate(OhrmJobCandidate ohrmJobCandidate) {
        this.ohrmJobCandidate = ohrmJobCandidate;
    }

    public OhrmJobVacancy getOhrmJobVacancy() {
        return ohrmJobVacancy;
    }

    public void setOhrmJobVacancy(OhrmJobVacancy ohrmJobVacancy) {
        this.ohrmJobVacancy = ohrmJobVacancy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmJobCandidateVacancyPK != null ? ohrmJobCandidateVacancyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmJobCandidateVacancy)) {
            return false;
        }
        OhrmJobCandidateVacancy other = (OhrmJobCandidateVacancy) object;
        if ((this.ohrmJobCandidateVacancyPK == null && other.ohrmJobCandidateVacancyPK != null) || (this.ohrmJobCandidateVacancyPK != null && !this.ohrmJobCandidateVacancyPK.equals(other.ohrmJobCandidateVacancyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobCandidateVacancy[ ohrmJobCandidateVacancyPK=" + ohrmJobCandidateVacancyPK + " ]";
    }
    
}
