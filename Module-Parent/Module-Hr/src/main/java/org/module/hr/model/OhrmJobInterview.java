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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "ohrm_job_interview", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobInterview.findAll", query = "SELECT o FROM OhrmJobInterview o"),
    @NamedQuery(name = "OhrmJobInterview.findById", query = "SELECT o FROM OhrmJobInterview o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobInterview.findByInterviewName", query = "SELECT o FROM OhrmJobInterview o WHERE o.interviewName = :interviewName"),
    @NamedQuery(name = "OhrmJobInterview.findByInterviewDate", query = "SELECT o FROM OhrmJobInterview o WHERE o.interviewDate = :interviewDate"),
    @NamedQuery(name = "OhrmJobInterview.findByInterviewTime", query = "SELECT o FROM OhrmJobInterview o WHERE o.interviewTime = :interviewTime")})
public class OhrmJobInterview implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "interview_name")
    private String interviewName;
    @Column(name = "interview_date")
    @Temporal(TemporalType.DATE)
    private Date interviewDate;
    @Column(name = "interview_time")
    @Temporal(TemporalType.TIME)
    private Date interviewTime;
    @Lob
    @Column(name = "note")
    private String note;
    @JoinTable(name = "ohrm_job_interview_interviewer", joinColumns = {
        @JoinColumn(name = "interview_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "interviewer_id", referencedColumnName = "emp_number")})
    @ManyToMany
    private List<HsHrEmployee> hsHrEmployeeList;
    @OneToMany(mappedBy = "interviewId")
    private List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList;
    @JoinColumn(name = "candidate_vacancy_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobCandidateVacancy candidateVacancyId;
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmJobCandidate candidateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewId")
    private List<OhrmJobInterviewAttachment> ohrmJobInterviewAttachmentList;

    public OhrmJobInterview() {
    }

    public OhrmJobInterview(Integer id) {
        this.id = id;
    }

    public OhrmJobInterview(Integer id, String interviewName) {
        this.id = id;
        this.interviewName = interviewName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterviewName() {
        return interviewName;
    }

    public void setInterviewName(String interviewName) {
        this.interviewName = interviewName;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
    }

    @XmlTransient
    public List<OhrmJobCandidateHistory> getOhrmJobCandidateHistoryList() {
        return ohrmJobCandidateHistoryList;
    }

    public void setOhrmJobCandidateHistoryList(List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList) {
        this.ohrmJobCandidateHistoryList = ohrmJobCandidateHistoryList;
    }

    public OhrmJobCandidateVacancy getCandidateVacancyId() {
        return candidateVacancyId;
    }

    public void setCandidateVacancyId(OhrmJobCandidateVacancy candidateVacancyId) {
        this.candidateVacancyId = candidateVacancyId;
    }

    public OhrmJobCandidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(OhrmJobCandidate candidateId) {
        this.candidateId = candidateId;
    }

    @XmlTransient
    public List<OhrmJobInterviewAttachment> getOhrmJobInterviewAttachmentList() {
        return ohrmJobInterviewAttachmentList;
    }

    public void setOhrmJobInterviewAttachmentList(List<OhrmJobInterviewAttachment> ohrmJobInterviewAttachmentList) {
        this.ohrmJobInterviewAttachmentList = ohrmJobInterviewAttachmentList;
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
        if (!(object instanceof OhrmJobInterview)) {
            return false;
        }
        OhrmJobInterview other = (OhrmJobInterview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobInterview[ id=" + id + " ]";
    }
    
}
