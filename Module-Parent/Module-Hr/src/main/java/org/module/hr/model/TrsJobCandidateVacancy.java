package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "trs_job_candidate_vacancy", catalog = "dbhr", schema = "schema_hr")
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
}