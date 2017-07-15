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
public class HsHrEmpMemberDetailPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "membship_code")
    private int membshipCode;

    public HsHrEmpMemberDetailPK() {
    }

    public HsHrEmpMemberDetailPK(int empNumber, int membshipCode) {
        this.empNumber = empNumber;
        this.membshipCode = membshipCode;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public int getMembshipCode() {
        return membshipCode;
    }

    public void setMembshipCode(int membshipCode) {
        this.membshipCode = membshipCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) membshipCode;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpMemberDetailPK)) {
            return false;
        }
        HsHrEmpMemberDetailPK other = (HsHrEmpMemberDetailPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.membshipCode != other.membshipCode) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpMemberDetailPK[ empNumber=" + empNumber + ", membshipCode=" + membshipCode + " ]";
    }
    
}
