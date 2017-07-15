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
public class HsHrEmpEmergencyContactsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "eec_seqno")
    private short eecSeqno;

    public HsHrEmpEmergencyContactsPK() {
    }

    public HsHrEmpEmergencyContactsPK(int empNumber, short eecSeqno) {
        this.empNumber = empNumber;
        this.eecSeqno = eecSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public short getEecSeqno() {
        return eecSeqno;
    }

    public void setEecSeqno(short eecSeqno) {
        this.eecSeqno = eecSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) eecSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpEmergencyContactsPK)) {
            return false;
        }
        HsHrEmpEmergencyContactsPK other = (HsHrEmpEmergencyContactsPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.eecSeqno != other.eecSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpEmergencyContactsPK[ empNumber=" + empNumber + ", eecSeqno=" + eecSeqno + " ]";
    }
    
}
