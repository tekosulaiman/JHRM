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
public class HsHrEmpHistoryOfEalierPosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "emp_seqno")
    private short empSeqno;

    public HsHrEmpHistoryOfEalierPosPK() {
    }

    public HsHrEmpHistoryOfEalierPosPK(int empNumber, short empSeqno) {
        this.empNumber = empNumber;
        this.empSeqno = empSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public short getEmpSeqno() {
        return empSeqno;
    }

    public void setEmpSeqno(short empSeqno) {
        this.empSeqno = empSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) empSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpHistoryOfEalierPosPK)) {
            return false;
        }
        HsHrEmpHistoryOfEalierPosPK other = (HsHrEmpHistoryOfEalierPosPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.empSeqno != other.empSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpHistoryOfEalierPosPK[ empNumber=" + empNumber + ", empSeqno=" + empSeqno + " ]";
    }
    
}
