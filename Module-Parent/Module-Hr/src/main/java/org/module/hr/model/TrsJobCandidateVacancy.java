/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "trs_job_candidate_vacancy", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobCandidateVacancy.findAll", query = "SELECT t FROM TrsJobCandidateVacancy t"),
    @NamedQuery(name = "TrsJobCandidateVacancy.findByIdJobCandidateVacancy", query = "SELECT t FROM TrsJobCandidateVacancy t WHERE t.idJobCandidateVacancy = :idJobCandidateVacancy")})
public class TrsJobCandidateVacancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_job_candidate_vacancy")
    private Integer idJobCandidateVacancy;
    @JoinColumn(name = "id_trs_job_candidate", referencedColumnName = "id_trs_job_candidate")
    @ManyToOne
    private TrsJobCandidate idTrsJobCandidate;
    @JoinColumn(name = "id_trs_job_vacancy", referencedColumnName = "id_trs_job_vacancy")
    @ManyToOne
    private TrsJobVacancy idTrsJobVacancy;

    public TrsJobCandidateVacancy() {
    }

    public TrsJobCandidateVacancy(Integer idJobCandidateVacancy) {
        this.idJobCandidateVacancy = idJobCandidateVacancy;
    }

    public Integer getIdJobCandidateVacancy() {
        return idJobCandidateVacancy;
    }

    public void setIdJobCandidateVacancy(Integer idJobCandidateVacancy) {
        this.idJobCandidateVacancy = idJobCandidateVacancy;
    }

    public TrsJobCandidate getIdTrsJobCandidate() {
        return idTrsJobCandidate;
    }

    public void setIdTrsJobCandidate(TrsJobCandidate idTrsJobCandidate) {
        this.idTrsJobCandidate = idTrsJobCandidate;
    }

    public TrsJobVacancy getIdTrsJobVacancy() {
        return idTrsJobVacancy;
    }

    public void setIdTrsJobVacancy(TrsJobVacancy idTrsJobVacancy) {
        this.idTrsJobVacancy = idTrsJobVacancy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJobCandidateVacancy != null ? idJobCandidateVacancy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsJobCandidateVacancy)) {
            return false;
        }
        TrsJobCandidateVacancy other = (TrsJobCandidateVacancy) object;
        if ((this.idJobCandidateVacancy == null && other.idJobCandidateVacancy != null) || (this.idJobCandidateVacancy != null && !this.idJobCandidateVacancy.equals(other.idJobCandidateVacancy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsJobCandidateVacancy[ idJobCandidateVacancy=" + idJobCandidateVacancy + " ]";
    }
    
}
