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
public class HsHrEmpPassportPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "ep_seqno")
    private short epSeqno;

    public HsHrEmpPassportPK() {
    }

    public HsHrEmpPassportPK(int empNumber, short epSeqno) {
        this.empNumber = empNumber;
        this.epSeqno = epSeqno;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public short getEpSeqno() {
        return epSeqno;
    }

    public void setEpSeqno(short epSeqno) {
        this.epSeqno = epSeqno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) epSeqno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpPassportPK)) {
            return false;
        }
        HsHrEmpPassportPK other = (HsHrEmpPassportPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.epSeqno != other.epSeqno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpPassportPK[ empNumber=" + empNumber + ", epSeqno=" + epSeqno + " ]";
    }
    
}
