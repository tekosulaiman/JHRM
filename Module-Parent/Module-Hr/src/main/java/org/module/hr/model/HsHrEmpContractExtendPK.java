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
public class HsHrEmpContractExtendPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "econ_extend_id")
    private long econExtendId;

    public HsHrEmpContractExtendPK() {
    }

    public HsHrEmpContractExtendPK(int empNumber, long econExtendId) {
        this.empNumber = empNumber;
        this.econExtendId = econExtendId;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public long getEconExtendId() {
        return econExtendId;
    }

    public void setEconExtendId(long econExtendId) {
        this.econExtendId = econExtendId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) econExtendId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpContractExtendPK)) {
            return false;
        }
        HsHrEmpContractExtendPK other = (HsHrEmpContractExtendPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.econExtendId != other.econExtendId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpContractExtendPK[ empNumber=" + empNumber + ", econExtendId=" + econExtendId + " ]";
    }
    
}
