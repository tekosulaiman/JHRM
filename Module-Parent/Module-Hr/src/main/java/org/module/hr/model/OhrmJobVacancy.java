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
@Table(name = "ohrm_job_vacancy", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobVacancy.findAll", query = "SELECT o FROM OhrmJobVacancy o"),
    @NamedQuery(name = "OhrmJobVacancy.findById", query = "SELECT o FROM OhrmJobVacancy o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobVacancy.findByName", query = "SELECT o FROM OhrmJobVacancy o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmJobVacancy.findByNoOfPositions", query = "SELECT o FROM OhrmJobVacancy o WHERE o.noOfPositions = :noOfPositions"),
    @NamedQuery(name = "OhrmJobVacancy.findByStatus", query = "SELECT o FROM OhrmJobVacancy o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmJobVacancy.findByPublishedInFeed", query = "SELECT o FROM OhrmJobVacancy o WHERE o.publishedInFeed = :publishedInFeed"),
    @NamedQuery(name = "OhrmJobVacancy.findByDefinedTime", query = "SELECT o FROM OhrmJobVacancy o WHERE o.definedTime = :definedTime"),
    @NamedQuery(name = "OhrmJobVacancy.findByUpdatedTime", query = "SELECT o FROM OhrmJobVacancy o WHERE o.updatedTime = :updatedTime")})
public class OhrmJobVacancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "no_of_positions")
    private Integer noOfPositions;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "published_in_feed")
    private boolean publishedInFeed;
    @Basic(optional = false)
    @Column(name = "defined_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date definedTime;
    @Basic(optional = false)
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacancyId")
    private List<OhrmJobVacancyAttachment> ohrmJobVacancyAttachmentList;
    @OneToMany(mappedBy = "vacancyId")
    private List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList;
    @JoinColumn(name = "job_title_code", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmJobTitle jobTitleCode;
    @JoinColumn(name = "hiring_manager_id", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee hiringManagerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmJobVacancy")
    private List<OhrmJobCandidateVacancy> ohrmJobCandidateVacancyList;

    public OhrmJobVacancy() {
    }

    public OhrmJobVacancy(Integer id) {
        this.id = id;
    }

    public OhrmJobVacancy(Integer id, String name, int status, boolean publishedInFeed, Date definedTime, Date updatedTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.publishedInFeed = publishedInFeed;
        this.definedTime = definedTime;
        this.updatedTime = updatedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNoOfPositions() {
        return noOfPositions;
    }

    public void setNoOfPositions(Integer noOfPositions) {
        this.noOfPositions = noOfPositions;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getPublishedInFeed() {
        return publishedInFeed;
    }

    public void setPublishedInFeed(boolean publishedInFeed) {
        this.publishedInFeed = publishedInFeed;
    }

    public Date getDefinedTime() {
        return definedTime;
    }

    public void setDefinedTime(Date definedTime) {
        this.definedTime = definedTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @XmlTransient
    public List<OhrmJobVacancyAttachment> getOhrmJobVacancyAttachmentList() {
        return ohrmJobVacancyAttachmentList;
    }

    public void setOhrmJobVacancyAttachmentList(List<OhrmJobVacancyAttachment> ohrmJobVacancyAttachmentList) {
        this.ohrmJobVacancyAttachmentList = ohrmJobVacancyAttachmentList;
    }

    @XmlTransient
    public List<OhrmJobCandidateHistory> getOhrmJobCandidateHistoryList() {
        return ohrmJobCandidateHistoryList;
    }

    public void setOhrmJobCandidateHistoryList(List<OhrmJobCandidateHistory> ohrmJobCandidateHistoryList) {
        this.ohrmJobCandidateHistoryList = ohrmJobCandidateHistoryList;
    }

    public OhrmJobTitle getJobTitleCode() {
        return jobTitleCode;
    }

    public void setJobTitleCode(OhrmJobTitle jobTitleCode) {
        this.jobTitleCode = jobTitleCode;
    }

    public HsHrEmployee getHiringManagerId() {
        return hiringManagerId;
    }

    public void setHiringManagerId(HsHrEmployee hiringManagerId) {
        this.hiringManagerId = hiringManagerId;
    }

    @XmlTransient
    public List<OhrmJobCandidateVacancy> getOhrmJobCandidateVacancyList() {
        return ohrmJobCandidateVacancyList;
    }

    public void setOhrmJobCandidateVacancyList(List<OhrmJobCandidateVacancy> ohrmJobCandidateVacancyList) {
        this.ohrmJobCandidateVacancyList = ohrmJobCandidateVacancyList;
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
        if (!(object instanceof OhrmJobVacancy)) {
            return false;
        }
        OhrmJobVacancy other = (OhrmJobVacancy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobVacancy[ id=" + id + " ]";
    }
    
}
