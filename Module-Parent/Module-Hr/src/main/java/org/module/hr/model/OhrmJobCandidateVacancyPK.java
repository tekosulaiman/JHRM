/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class OhrmJobCandidateVacancyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "candidate_id")
    private int candidateId;
    @Basic(optional = false)
    @Column(name = "vacancy_id")
    private int vacancyId;

    public OhrmJobCandidateVacancyPK() {
    }

    public OhrmJobCandidateVacancyPK(int candidateId, int vacancyId) {
        this.candidateId = candidateId;
        this.vacancyId = vacancyId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) candidateId;
        hash += (int) vacancyId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmJobCandidateVacancyPK)) {
            return false;
        }
        OhrmJobCandidateVacancyPK other = (OhrmJobCandidateVacancyPK) object;
        if (this.candidateId != other.candidateId) {
            return false;
        }
        if (this.vacancyId != other.vacancyId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmJobCandidateVacancyPK[ candidateId=" + candidateId + ", vacancyId=" + vacancyId + " ]";
    }
    
}
