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
@Table(name = "ohrm_job_candidate", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobCandidate.findAll", query = "SELECT o FROM OhrmJobCandidate o"),
    @NamedQuery(name = "OhrmJobCandidate.findById", query = "SELECT o FROM OhrmJobCandidate o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobCandidate.findByFirstName", query = "SELECT o FROM OhrmJobCandidate o WHERE o.firstName = :firstName"),
    @NamedQuery(name = "OhrmJobCandidate.findByMiddleName", query = "SELECT o FROM OhrmJobCandidate o WHERE o.middleName = :middleName"),
    @NamedQuery(name = "OhrmJobCandidate.findByLastName", query = "SELECT o FROM OhrmJobCandidate o WHERE o.lastName = :lastName"),
    @NamedQuery(name = "OhrmJobCandidate.findByEmail", query = "SELECT o FROM OhrmJobCandidate o WHERE o.email = :email"),
    @NamedQuery(name = "OhrmJobCandidate.findByContactNumber", query = "SELECT o FROM OhrmJobCandidate o WHERE o.contactNumber = :contactNumber"),
    @NamedQuery(name = "OhrmJobCandidate.findByStatus", query = "SELECT o FROM OhrmJobCandidate o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmJobCandidate.findByModeOfApplication", query = "SELECT o FROM OhrmJobCandidate o WHERE o.modeOfApplication = :modeOfApplication"),
    @NamedQuery(name = "OhrmJobCandidate.findByDateOfApplication", query = "SELECT o FROM OhrmJobCandidate o WHERE o.dateOfApplication = :dateOfApplication"),
    @NamedQuery(name = "OhrmJobCandidate.findByCvFileId", query = "SELECT o FROM OhrmJobCandidate o WHERE o.cvFileId = :cvFileId"),
    @NamedQuery(name = "OhrmJobCandidate.findByKeywords", query = "SELECT o FROM OhrmJobCandidate o WHERE o.keywords = :keywords")})
public class OhrmJobCandidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Lob
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "mode_of_application")
    private int modeOfApplication;
    @Basic(optional = false)
    @Column(name = "date_of_application")
    @Temporal(TemporalType.DATE)
    private Date dateOfApplication;
    @Column(name = "cv_file_id")
    private Integer cvFileId;
    @Lob
    @Column(name = "cv_text_version")
    private String cvTextVersion;
    @Column(name = "keywords")
    private String keywords;
    @JoinColumn(name = "added_person", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee addedPerson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId")
    private List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList;
    @OneToMany(mappedBy = "candidateId")
    private List<OhrmJobInterview> ohrmJobInterviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmJobCandidate")
    private List<OhrmJobCandidateVacancy> ohrmJobCandidateVacancyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId")
    private List<OhrmJobCandidateAttachment> ohrmJobCandidateAttachmentList;

    public OhrmJobCandidate() {
    }

    public OhrmJobCandidate(Integer id) {
        this.id = id;
    }

    public OhrmJobCandidate(Integer id, String firstName, String lastName, String email, int status, int modeOfApplication, Date dateOfApplication) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.modeOfApplication = modeOfApplication;
        this.dateOfApplication = dateOfApplication;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getModeOfApplication() {
        return modeOfApplication;
    }

    public void setModeOfApplication(int modeOfApplication) {
        this.modeOfApplication = modeOfApplication;
    }

    public Date getDateOfApplication() {
        return dateOfApplication;
    }

    public void setDateOfApplication(Date dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }

    public Integer getCvFileId() {
        return cvFileId;
    }

    public void setCvFileId(Integer cvFileId) {
        this.cvFileId = cvFileId;
    }

    public String getCvTextVersion() {
        return cvTextVersion;
    }

    public void setCvTextVersion(String cvTextVersion) {
        this.cvTextVersion = cvTextVersion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public HsHrEmployee getAddedPerson() {
        return addedPerson;
    }

    public void setAddedPerson(HsHrEmployee addedPerson) {
        this.addedPerson = addedPerson;
    }

    @XmlTransient
    public List<OhrmJobCandidateHistory> getOhrmJobCandidateHistoryList() {
        return ohrmJobCandidateHistoryList;
    }

    public void setOhrmJobCandidateHistoryList(List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList) {
        this.ohrmJobCandidateHistoryList = ohrmJobCandidateHistoryList;
    }

    @XmlTransient
    public List<OhrmJobInterview> getOhrmJobInterviewList() {
        return ohrmJobInterviewList;
    }

    public void setOhrmJobInterviewList(List<OhrmJobInterview> ohrmJobInterviewList) {
        this.ohrmJobInterviewList = ohrmJobInterviewList;
    }

    @XmlTransient
    public List<OhrmJobCandidateVacancy> getOhrmJobCandidateVacancyList() {
        return ohrmJobCandidateVacancyList;
    }

    public void setOhrmJobCandidateVacancyList(List<OhrmJobCandidateVacancy> ohrmJobCandidateVacancyList) {
        this.ohrmJobCandidateVacancyList = ohrmJobCandidateVacancyList;
    }

    @XmlTransient
    public List<OhrmJobCandidateAttachment> getOhrmJobCandidateAttachmentList() {
        return ohrmJobCandidateAttachmentList;
    }

    public void setOhrmJobCandidateAttachmentList(List<OhrmJobCandidateAttachment> ohrmJobCandidateAttachmentList) {
        this.ohrmJobCandidateAttachmentList = ohrmJobCandidateAttachmentList;
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
        if (!(object instanceof OhrmJobCandidate)) {
            return false;
        }
        OhrmJobCandidate other = (OhrmJobCandidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobCandidate[ id=" + id + " ]";
    }
    
}
