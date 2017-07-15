/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "hs_hr_emp_language", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpLanguage.findAll", query = "SELECT h FROM HsHrEmpLanguage h"),
    @NamedQuery(name = "HsHrEmpLanguage.findByEmpNumber", query = "SELECT h FROM HsHrEmpLanguage h WHERE h.hsHrEmpLanguagePK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpLanguage.findByLangId", query = "SELECT h FROM HsHrEmpLanguage h WHERE h.hsHrEmpLanguagePK.langId = :langId"),
    @NamedQuery(name = "HsHrEmpLanguage.findByFluency", query = "SELECT h FROM HsHrEmpLanguage h WHERE h.hsHrEmpLanguagePK.fluency = :fluency"),
    @NamedQuery(name = "HsHrEmpLanguage.findByCompetency", query = "SELECT h FROM HsHrEmpLanguage h WHERE h.competency = :competency"),
    @NamedQuery(name = "HsHrEmpLanguage.findByComments", query = "SELECT h FROM HsHrEmpLanguage h WHERE h.comments = :comments")})
public class HsHrEmpLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpLanguagePK hsHrEmpLanguagePK;
    @Column(name = "competency")
    private Short competency;
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;
    @JoinColumn(name = "lang_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmLanguage ohrmLanguage;

    public HsHrEmpLanguage() {
    }

    public HsHrEmpLanguage(HsHrEmpLanguagePK hsHrEmpLanguagePK) {
        this.hsHrEmpLanguagePK = hsHrEmpLanguagePK;
    }

    public HsHrEmpLanguage(int empNumber, int langId, short fluency) {
        this.hsHrEmpLanguagePK = new HsHrEmpLanguagePK(empNumber, langId, fluency);
    }

    public HsHrEmpLanguagePK getHsHrEmpLanguagePK() {
        return hsHrEmpLanguagePK;
    }

    public void setHsHrEmpLanguagePK(HsHrEmpLanguagePK hsHrEmpLanguagePK) {
        this.hsHrEmpLanguagePK = hsHrEmpLanguagePK;
    }

    public Short getCompetency() {
        return competency;
    }

    public void setCompetency(Short competency) {
        this.competency = competency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    public OhrmLanguage getOhrmLanguage() {
        return ohrmLanguage;
    }

    public void setOhrmLanguage(OhrmLanguage ohrmLanguage) {
        this.ohrmLanguage = ohrmLanguage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpLanguagePK != null ? hsHrEmpLanguagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpLanguage)) {
            return false;
        }
        HsHrEmpLanguage other = (HsHrEmpLanguage) object;
        if ((this.hsHrEmpLanguagePK == null && other.hsHrEmpLanguagePK != null) || (this.hsHrEmpLanguagePK != null && !this.hsHrEmpLanguagePK.equals(other.hsHrEmpLanguagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpLanguage[ hsHrEmpLanguagePK=" + hsHrEmpLanguagePK + " ]";
    }
    
}
