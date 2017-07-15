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
public class HsHrEmpDependentsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "ed_seqno")
    private short edSeqno;

    public HsHrEmpDependentsPK() {
    }

    public HsHrEmpDependentsPK(int empNumber, short edSeqno) {
        this.empNumber = empNumber;
        this.edSeqno = edSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public short getEdSeqno() {
        return edSeqno;
    }

    public void setEdSeqno(short edSeqno) {
        this.edSeqno = edSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) edSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpDependentsPK)) {
            return false;
        }
        HsHrEmpDependentsPK other = (HsHrEmpDependentsPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.edSeqno != other.edSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpDependentsPK[ empNumber=" + empNumber + ", edSeqno=" + edSeqno + " ]";
    }
    
}
