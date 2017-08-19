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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "trs_job_vacancy", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsJobVacancy.findAll", query = "SELECT t FROM TrsJobVacancy t"),
    @NamedQuery(name = "TrsJobVacancy.findByIdTrsJobVacancy", query = "SELECT t FROM TrsJobVacancy t WHERE t.idTrsJobVacancy = :idTrsJobVacancy")})
public class TrsJobVacancy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
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
    
}
