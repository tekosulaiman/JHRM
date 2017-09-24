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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "trs_job_vacancy", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobVacancy.findAll", query = "SELECT t FROM TrsJobVacancy t"),
    @NamedQuery(name = "TrsJobVacancy.findByIdTrsJobVacancy", query = "SELECT t FROM TrsJobVacancy t WHERE t.idTrsJobVacancy = :idTrsJobVacancy")})
public class TrsJobVacancy implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "no_of_positions")
    private Integer noOfPositions;
    @Column(name = "published_in_feed")
    private Boolean publishedInFeed;
    @Column(name = "defined_time")
    @Temporal(TemporalType.DATE)
    private Date definedTime;
    @Column(name = "updated_time")
    @Temporal(TemporalType.DATE)
    private Date updatedTime;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="TrsJobVacancy_idTrsJobVacancy_GENERATOR", sequenceName="SCHEMA_HR.TrsJobVacancy_idTrsJobVacancy_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TrsJobVacancy_idTrsJobVacancy_GENERATOR")
    @Column(name = "id_trs_job_vacancy")
    private Integer idTrsJobVacancy;
    @OneToMany(mappedBy = "idTrsJobVacancy")
    private List<TrsJobCandidateVacancy> trsJobCandidateVacancyList;
    @JoinColumn(name = "id_job_title", referencedColumnName = "id_job_title")
    @ManyToOne
    private MstJobtitle idJobTitle;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsJobVacancy() {
    }

    public TrsJobVacancy(Integer idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }

    public Integer getIdTrsJobVacancy() {
        return idTrsJobVacancy;
    }

    public void setIdTrsJobVacancy(Integer idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }

    @XmlTransient
    public List<TrsJobCandidateVacancy> getTrsJobCandidateVacancyList() {
        return trsJobCandidateVacancyList;
    }

    public void setTrsJobCandidateVacancyList(List<TrsJobCandidateVacancy> trsJobCandidateVacancyList) {
        this.trsJobCandidateVacancyList = trsJobCandidateVacancyList;
    }

    public MstJobtitle getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(MstJobtitle idJobTitle) {
        this.idJobTitle = idJobTitle;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrsJobVacancy != null ? idTrsJobVacancy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsJobVacancy)) {
            return false;
        }
        TrsJobVacancy other = (TrsJobVacancy) object;
        if ((this.idTrsJobVacancy == null && other.idTrsJobVacancy != null) || (this.idTrsJobVacancy != null && !this.idTrsJobVacancy.equals(other.idTrsJobVacancy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsJobVacancy[ idTrsJobVacancy=" + idTrsJobVacancy + " ]";
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

    public Boolean getPublishedInFeed() {
        return publishedInFeed;
    }

    public void setPublishedInFeed(Boolean publishedInFeed) {
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
    
}
