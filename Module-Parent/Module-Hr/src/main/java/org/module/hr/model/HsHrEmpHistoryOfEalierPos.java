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
@Table(name = "hs_hr_emp_history_of_ealier_pos", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpHistoryOfEalierPos.findAll", query = "SELECT h FROM HsHrEmpHistoryOfEalierPos h"),
    @NamedQuery(name = "HsHrEmpHistoryOfEalierPos.findByEmpNumber", query = "SELECT h FROM HsHrEmpHistoryOfEalierPos h WHERE h.hsHrEmpHistoryOfEalierPosPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpHistoryOfEalierPos.findByEmpSeqno", query = "SELECT h FROM HsHrEmpHistoryOfEalierPos h WHERE h.hsHrEmpHistoryOfEalierPosPK.empSeqno = :empSeqno"),
    @NamedQuery(name = "HsHrEmpHistoryOfEalierPos.findByEhoepJobTitle", query = "SELECT h FROM HsHrEmpHistoryOfEalierPos h WHERE h.ehoepJobTitle = :ehoepJobTitle"),
    @NamedQuery(name = "HsHrEmpHistoryOfEalierPos.findByEhoepYears", query = "SELECT h FROM HsHrEmpHistoryOfEalierPos h WHERE h.ehoepYears = :ehoepYears")})
public class HsHrEmpHistoryOfEalierPos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpHistoryOfEalierPosPK hsHrEmpHistoryOfEalierPosPK;
    @Column(name = "ehoep_job_title")
    private String ehoepJobTitle;
    @Column(name = "ehoep_years")
    private String ehoepYears;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpHistoryOfEalierPos() {
    }

    public HsHrEmpHistoryOfEalierPos(HsHrEmpHistoryOfEalierPosPK hsHrEmpHistoryOfEalierPosPK) {
        this.hsHrEmpHistoryOfEalierPosPK = hsHrEmpHistoryOfEalierPosPK;
    }

    public HsHrEmpHistoryOfEalierPos(int empNumber, short empSeqno) {
        this.hsHrEmpHistoryOfEalierPosPK = new HsHrEmpHistoryOfEalierPosPK(empNumber, empSeqno);
    }

    public HsHrEmpHistoryOfEalierPosPK getHsHrEmpHistoryOfEalierPosPK() {
        return hsHrEmpHistoryOfEalierPosPK;
    }

    public void setHsHrEmpHistoryOfEalierPosPK(HsHrEmpHistoryOfEalierPosPK hsHrEmpHistoryOfEalierPosPK) {
        this.hsHrEmpHistoryOfEalierPosPK = hsHrEmpHistoryOfEalierPosPK;
    }

    public String getEhoepJobTitle() {
        return ehoepJobTitle;
    }

    public void setEhoepJobTitle(String ehoepJobTitle) {
        this.ehoepJobTitle = ehoepJobTitle;
    }

    public String getEhoepYears() {
        return ehoepYears;
    }

    public void setEhoepYears(String ehoepYears) {
        this.ehoepYears = ehoepYears;
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
        hash += (hsHrEmpHistoryOfEalierPosPK != null ? hsHrEmpHistoryOfEalierPosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpHistoryOfEalierPos)) {
            return false;
        }
        HsHrEmpHistoryOfEalierPos other = (HsHrEmpHistoryOfEalierPos) object;
        if ((this.hsHrEmpHistoryOfEalierPosPK == null && other.hsHrEmpHistoryOfEalierPosPK != null) || (this.hsHrEmpHistoryOfEalierPosPK != null && !this.hsHrEmpHistoryOfEalierPosPK.equals(other.hsHrEmpHistoryOfEalierPosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpHistoryOfEalierPos[ hsHrEmpHistoryOfEalierPosPK=" + hsHrEmpHistoryOfEalierPosPK + " ]";
    }
    
}
