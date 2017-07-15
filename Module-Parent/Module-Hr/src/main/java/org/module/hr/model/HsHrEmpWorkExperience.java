/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_work_experience", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpWorkExperience.findAll", query = "SELECT h FROM HsHrEmpWorkExperience h"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEmpNumber", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.hsHrEmpWorkExperiencePK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpSeqno", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.hsHrEmpWorkExperiencePK.eexpSeqno = :eexpSeqno"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpEmployer", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpEmployer = :eexpEmployer"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpJobtit", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpJobtit = :eexpJobtit"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpFromDate", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpFromDate = :eexpFromDate"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpToDate", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpToDate = :eexpToDate"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpComments", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpComments = :eexpComments"),
    @NamedQuery(name = "HsHrEmpWorkExperience.findByEexpInternal", query = "SELECT h FROM HsHrEmpWorkExperience h WHERE h.eexpInternal = :eexpInternal")})
public class HsHrEmpWorkExperience implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpWorkExperiencePK hsHrEmpWorkExperiencePK;
    @Column(name = "eexp_employer")
    private String eexpEmployer;
    @Column(name = "eexp_jobtit")
    private String eexpJobtit;
    @Column(name = "eexp_from_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eexpFromDate;
    @Column(name = "eexp_to_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eexpToDate;
    @Column(name = "eexp_comments")
    private String eexpComments;
    @Column(name = "eexp_internal")
    private Integer eexpInternal;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpWorkExperience() {
    }

    public HsHrEmpWorkExperience(HsHrEmpWorkExperiencePK hsHrEmpWorkExperiencePK) {
        this.hsHrEmpWorkExperiencePK = hsHrEmpWorkExperiencePK;
    }

    public HsHrEmpWorkExperience(int empNumber, long eexpSeqno) {
        this.hsHrEmpWorkExperiencePK = new HsHrEmpWorkExperiencePK(empNumber, eexpSeqno);
    }

    public HsHrEmpWorkExperiencePK getHsHrEmpWorkExperiencePK() {
        return hsHrEmpWorkExperiencePK;
    }

    public void setHsHrEmpWorkExperiencePK(HsHrEmpWorkExperiencePK hsHrEmpWorkExperiencePK) {
        this.hsHrEmpWorkExperiencePK = hsHrEmpWorkExperiencePK;
    }

    public String getEexpEmployer() {
        return eexpEmployer;
    }

    public void setEexpEmployer(String eexpEmployer) {
        this.eexpEmployer = eexpEmployer;
    }

    public String getEexpJobtit() {
        return eexpJobtit;
    }

    public void setEexpJobtit(String eexpJobtit) {
        this.eexpJobtit = eexpJobtit;
    }

    public Date getEexpFromDate() {
        return eexpFromDate;
    }

    public void setEexpFromDate(Date eexpFromDate) {
        this.eexpFromDate = eexpFromDate;
    }

    public Date getEexpToDate() {
        return eexpToDate;
    }

    public void setEexpToDate(Date eexpToDate) {
        this.eexpToDate = eexpToDate;
    }

    public String getEexpComments() {
        return eexpComments;
    }

    public void setEexpComments(String eexpComments) {
        this.eexpComments = eexpComments;
    }

    public Integer getEexpInternal() {
        return eexpInternal;
    }

    public void setEexpInternal(Integer eexpInternal) {
        this.eexpInternal = eexpInternal;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpWorkExperiencePK != null ? hsHrEmpWorkExperiencePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpWorkExperience)) {
            return false;
        }
        HsHrEmpWorkExperience other = (HsHrEmpWorkExperience) object;
        if ((this.hsHrEmpWorkExperiencePK == null && other.hsHrEmpWorkExperiencePK != null) || (this.hsHrEmpWorkExperiencePK != null && !this.hsHrEmpWorkExperiencePK.equals(other.hsHrEmpWorkExperiencePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpWorkExperience[ hsHrEmpWorkExperiencePK=" + hsHrEmpWorkExperiencePK + " ]";
    }
    
}
