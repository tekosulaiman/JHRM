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
public class HsHrEmpWorkExperiencePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "eexp_seqno")
    private long eexpSeqno;

    public HsHrEmpWorkExperiencePK() {
    }

    public HsHrEmpWorkExperiencePK(int empNumber, long eexpSeqno) {
        this.empNumber = empNumber;
        this.eexpSeqno = eexpSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public long getEexpSeqno() {
        return eexpSeqno;
    }

    public void setEexpSeqno(long eexpSeqno) {
        this.eexpSeqno = eexpSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) eexpSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpWorkExperiencePK)) {
            return false;
        }
        HsHrEmpWorkExperiencePK other = (HsHrEmpWorkExperiencePK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.eexpSeqno != other.eexpSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpWorkExperiencePK[ empNumber=" + empNumber + ", eexpSeqno=" + eexpSeqno + " ]";
    }
    
}
