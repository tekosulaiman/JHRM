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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "mst_jobtitle", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstJobtitle.findAll", query = "SELECT m FROM MstJobtitle m"),
    @NamedQuery(name = "MstJobtitle.findByIdJobTitle", query = "SELECT m FROM MstJobtitle m WHERE m.idJobTitle = :idJobTitle"),
    @NamedQuery(name = "MstJobtitle.findByJobName", query = "SELECT m FROM MstJobtitle m WHERE m.jobName = :jobName"),
    @NamedQuery(name = "MstJobtitle.findByJobDescription", query = "SELECT m FROM MstJobtitle m WHERE m.jobDescription = :jobDescription"),
    @NamedQuery(name = "MstJobtitle.findByJobNote", query = "SELECT m FROM MstJobtitle m WHERE m.jobNote = :jobNote")})
public class MstJobtitle implements Serializable {
    @OneToMany(mappedBy = "idJobTitle")
    private List<TrsJobVacancy> trsJobVacancyList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="MstJobtitle_idJobTitle_GENERATOR", sequenceName="SCHEMA_HR.MstJobtitle_idJobTitle_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MstJobtitle_idJobTitle_GENERATOR")
    @Column(name = "id_job_title")
    private Integer idJobTitle;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_note")
    private String jobNote;

    public MstJobtitle() {
    }

    public MstJobtitle(Integer idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public Integer getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(Integer idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobNote() {
        return jobNote;
    }

    public void setJobNote(String jobNote) {
        this.jobNote = jobNote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJobTitle != null ? idJobTitle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstJobtitle)) {
            return false;
        }
        MstJobtitle other = (MstJobtitle) object;
        if ((this.idJobTitle == null && other.idJobTitle != null) || (this.idJobTitle != null && !this.idJobTitle.equals(other.idJobTitle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstJobtitle[ idJobTitle=" + idJobTitle + " ]";
    }

    @XmlTransient
    public List<TrsJobVacancy> getTrsJobVacancyList() {
        return trsJobVacancyList;
    }

    public void setTrsJobVacancyList(List<TrsJobVacancy> trsJobVacancyList) {
        this.trsJobVacancyList = trsJobVacancyList;
    }
    
}
