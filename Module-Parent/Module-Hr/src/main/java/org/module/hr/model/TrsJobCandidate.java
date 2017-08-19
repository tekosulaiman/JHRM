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
import javax.persistence.Id;
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
@Table(name = "trs_job_candidate", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobCandidate.findAll", query = "SELECT t FROM TrsJobCandidate t"),
    @NamedQuery(name = "TrsJobCandidate.findByIdTrsJobCandidate", query = "SELECT t FROM TrsJobCandidate t WHERE t.idTrsJobCandidate = :idTrsJobCandidate")})
public class TrsJobCandidate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_trs_job_candidate")
    private Integer idTrsJobCandidate;
    @OneToMany(mappedBy = "idTrsJobCandidate")
    private List<TrsJobCandidateVacancy> trsJobCandidateVacancyList;

    public TrsJobCandidate() {
    }

    public TrsJobCandidate(Integer idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    public Integer getIdTrsJobCandidate() {
        return idTrsJobCandidate;
    }

    public void setIdTrsJobCandidate(Integer idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    @XmlTransient
    public List<TrsJobCandidateVacancy> getTrsJobCandidateVacancyList() {
        return trsJobCandidateVacancyList;
    }

    public void setTrsJobCandidateVacancyList(List<TrsJobCandidateVacancy> trsJobCandidateVacancyList) {
        this.trsJobCandidateVacancyList = trsJobCandidateVacancyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrsJobCandidate != null ? idTrsJobCandidate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsJobCandidate)) {
            return false;
        }
        TrsJobCandidate other = (TrsJobCandidate) object;
        if ((this.idTrsJobCandidate == null && other.idTrsJobCandidate != null) || (this.idTrsJobCandidate != null && !this.idTrsJobCandidate.equals(other.idTrsJobCandidate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsJobCandidate[ idTrsJobCandidate=" + idTrsJobCandidate + " ]";
    }
    
}
