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
public class HsHrEmpChildrenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "ec_seqno")
    private short ecSeqno;

    public HsHrEmpChildrenPK() {
    }

    public HsHrEmpChildrenPK(int empNumber, short ecSeqno) {
        this.empNumber = empNumber;
        this.ecSeqno = ecSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public short getEcSeqno() {
        return ecSeqno;
    }

    public void setEcSeqno(short ecSeqno) {
        this.ecSeqno = ecSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) ecSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpChildrenPK)) {
            return false;
        }
        HsHrEmpChildrenPK other = (HsHrEmpChildrenPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.ecSeqno != other.ecSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpChildrenPK[ empNumber=" + empNumber + ", ecSeqno=" + ecSeqno + " ]";
    }
    
}
