/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_job_title", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmJobTitle.findAll", query = "SELECT o FROM OhrmJobTitle o"),
    @NamedQuery(name = "OhrmJobTitle.findById", query = "SELECT o FROM OhrmJobTitle o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmJobTitle.findByJobTitle", query = "SELECT o FROM OhrmJobTitle o WHERE o.jobTitle = :jobTitle"),
    @NamedQuery(name = "OhrmJobTitle.findByJobDescription", query = "SELECT o FROM OhrmJobTitle o WHERE o.jobDescription = :jobDescription"),
    @NamedQuery(name = "OhrmJobTitle.findByNote", query = "SELECT o FROM OhrmJobTitle o WHERE o.note = :note"),
    @NamedQuery(name = "OhrmJobTitle.findByIsDeleted", query = "SELECT o FROM OhrmJobTitle o WHERE o.isDeleted = :isDeleted")})
public class OhrmJobTitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "note")
    private String note;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @JoinTable(name = "hs_hr_jobtit_empstat", joinColumns = {
        @JoinColumn(name = "jobtit_code", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "estat_code", referencedColumnName = "id")})
    @ManyToMany
    private List<OhrmEmploymentStatus> ohrmEmploymentStatusList;
    @OneToMany(mappedBy = "jobTitleCode")
    private List<HsHrEmployee> hsHrEmployeeList;

    public OhrmJobTitle() {
    }

    public OhrmJobTitle(Integer id) {
        this.id = id;
    }

    public OhrmJobTitle(Integer id, String jobTitle) {
        this.id = id;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @XmlTransient
    public List<OhrmEmploymentStatus> getOhrmEmploymentStatusList() {
        return ohrmEmploymentStatusList;
    }

    public void setOhrmEmploymentStatusList(List<OhrmEmploymentStatus> ohrmEmploymentStatusList) {
        this.ohrmEmploymentStatusList = ohrmEmploymentStatusList;
    }

    @XmlTransient
    public List<HsHrEmployee> getHsHrEmployeeList() {
        return hsHrEmployeeList;
    }

    public void setHsHrEmployeeList(List<HsHrEmployee> hsHrEmployeeList) {
        this.hsHrEmployeeList = hsHrEmployeeList;
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
        if (!(object instanceof OhrmJobTitle)) {
            return false;
        }
        OhrmJobTitle other = (OhrmJobTitle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobTitle[ id=" + id + " ]";
    }
    
}
