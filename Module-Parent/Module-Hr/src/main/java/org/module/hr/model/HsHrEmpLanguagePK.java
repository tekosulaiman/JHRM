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
public class HsHrEmpLanguagePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "lang_id")
    private int langId;
    @Basic(optional = false)
    @Column(name = "fluency")
    private short fluency;

    public HsHrEmpLanguagePK() {
    }

    public HsHrEmpLanguagePK(int empNumber, int langId, short fluency) {
        this.empNumber = empNumber;
        this.langId = langId;
        this.fluency = fluency;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public short getFluency() {
        return fluency;
    }

    public void setFluency(short fluency) {
        this.fluency = fluency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) langId;
        hash += (int) fluency;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpLanguagePK)) {
            return false;
        }
        HsHrEmpLanguagePK other = (HsHrEmpLanguagePK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.langId != other.langId) {
            return false;
        }
        if (this.fluency != other.fluency) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpLanguagePK[ empNumber=" + empNumber + ", langId=" + langId + ", fluency=" + fluency + " ]";
    }
    
}
