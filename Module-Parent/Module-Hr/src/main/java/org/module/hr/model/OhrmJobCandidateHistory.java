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
import javax.persistence.Lob;
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
@Table(name = "ohrm_job_candidate_history", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobCandidateHistory.findAll", query = "SELECT o FROM OhrmJobCandidateHistory o"),
    @NamedQuery(name = "OhrmJobCandidateHistory.findById", query = "SELECT o FROM OhrmJobCandidateHistory o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobCandidateHistory.findByCandidateVacancyName", query = "SELECT o FROM OhrmJobCandidateHistory o WHERE o.candidateVacancyName = :candidateVacancyName"),
    @NamedQuery(name = "OhrmJobCandidateHistory.findByAction", query = "SELECT o FROM OhrmJobCandidateHistory o WHERE o.action = :action"),
    @NamedQuery(name = "OhrmJobCandidateHistory.findByPerformedDate", query = "SELECT o FROM OhrmJobCandidateHistory o WHERE o.performedDate = :performedDate"),
    @NamedQuery(name = "OhrmJobCandidateHistory.findByInterviewers", query = "SELECT o FROM OhrmJobCandidateHistory o WHERE o.interviewers = :interviewers")})
public class OhrmJobCandidateHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "candidate_vacancy_name")
    private String candidateVacancyName;
    @Basic(optional = false)
    @Column(name = "action")
    private int action;
    @Basic(optional = false)
    @Column(name = "performed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date performedDate;
    @Lob
    @Column(name = "note")
    private String note;
    @Column(name = "interviewers")
    private String interviewers;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmJobCandidate candidateId;
    @JoinColumn(name = "vacancy_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobVacancy vacancyId;
    @JoinColumn(name = "interview_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobInterview interviewId;
    @JoinColumn(name = "performed_by", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee performedBy;

    public OhrmJobCandidateHistory() {
    }

    public OhrmJobCandidateHistory(Integer id) {
        this.id = id;
    }

    public OhrmJobCandidateHistory(Integer id, int action, Date performedDate) {
        this.id = id;
        this.action = action;
        this.performedDate = performedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCandidateVacancyName() {
        return candidateVacancyName;
    }

    public void setCandidateVacancyName(String candidateVacancyName) {
        this.candidateVacancyName = candidateVacancyName;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getPerformedDate() {
        return performedDate;
    }

    public void setPerformedDate(Date performedDate) {
        this.performedDate = performedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(String interviewers) {
        this.interviewers = interviewers;
    }

    public OhrmJobCandidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(OhrmJobCandidate candidateId) {
        this.candidateId = candidateId;
    }

    public OhrmJobVacancy getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(OhrmJobVacancy vacancyId) {
        this.vacancyId = vacancyId;
    }

    public OhrmJobInterview getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(OhrmJobInterview interviewId) {
        this.interviewId = interviewId;
    }

    public HsHrEmployee getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(HsHrEmployee performedBy) {
        this.performedBy = performedBy;
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
        if (!(object instanceof OhrmJobCandidateHistory)) {
            return false;
        }
        OhrmJobCandidateHistory other = (OhrmJobCandidateHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobCandidateHistory[ id=" + id + " ]";
    }
    
}
