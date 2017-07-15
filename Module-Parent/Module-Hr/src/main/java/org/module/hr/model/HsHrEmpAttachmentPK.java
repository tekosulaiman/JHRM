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
public class HsHrEmpAttachmentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Basic(optional = false)
    @Column(name = "eattach_id")
    private int eattachId;

    public HsHrEmpAttachmentPK() {
    }

    public HsHrEmpAttachmentPK(int empNumber, int eattachId) {
        this.empNumber = empNumber;
        this.eattachId = eattachId;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public int getEattachId() {
        return eattachId;
    }

    public void setEattachId(int eattachId) {
        this.eattachId = eattachId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) empNumber;
        hash += (int) eattachId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpAttachmentPK)) {
            return false;
        }
        HsHrEmpAttachmentPK other = (HsHrEmpAttachmentPK) object;
        if (this.empNumber != other.empNumber) {
            return false;
        }
        if (this.eattachId != other.eattachId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpAttachmentPK[ empNumber=" + empNumber + ", eattachId=" + eattachId + " ]";
    }
    
}
