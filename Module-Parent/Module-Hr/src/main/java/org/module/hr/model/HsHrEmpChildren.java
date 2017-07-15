/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_emp_children", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpChildren.findAll", query = "SELECT h FROM HsHrEmpChildren h"),
    @NamedQuery(name = "HsHrEmpChildren.findByEmpNumber", query = "SELECT h FROM HsHrEmpChildren h WHERE h.hsHrEmpChildrenPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpChildren.findByEcSeqno", query = "SELECT h FROM HsHrEmpChildren h WHERE h.hsHrEmpChildrenPK.ecSeqno = :ecSeqno"),
    @NamedQuery(name = "HsHrEmpChildren.findByEcName", query = "SELECT h FROM HsHrEmpChildren h WHERE h.ecName = :ecName"),
    @NamedQuery(name = "HsHrEmpChildren.findByEcDateOfBirth", query = "SELECT h FROM HsHrEmpChildren h WHERE h.ecDateOfBirth = :ecDateOfBirth")})
public class HsHrEmpChildren implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpChildrenPK hsHrEmpChildrenPK;
    @Column(name = "ec_name")
    private String ecName;
    @Column(name = "ec_date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date ecDateOfBirth;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpChildren() {
    }

    public HsHrEmpChildren(HsHrEmpChildrenPK hsHrEmpChildrenPK) {
        this.hsHrEmpChildrenPK = hsHrEmpChildrenPK;
    }

    public HsHrEmpChildren(int empNumber, short ecSeqno) {
        this.hsHrEmpChildrenPK = new HsHrEmpChildrenPK(empNumber, ecSeqno);
    }

    public HsHrEmpChildrenPK getHsHrEmpChildrenPK() {
        return hsHrEmpChildrenPK;
    }

    public void setHsHrEmpChildrenPK(HsHrEmpChildrenPK hsHrEmpChildrenPK) {
        this.hsHrEmpChildrenPK = hsHrEmpChildrenPK;
    }

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public Date getEcDateOfBirth() {
        return ecDateOfBirth;
    }

    public void setEcDateOfBirth(Date ecDateOfBirth) {
        this.ecDateOfBirth = ecDateOfBirth;
    }

    public HsHrEmployee getHsHrEmployee() {
        return hsHrEmployee;
    }

    public void setHsHrEmployee(HsHrEmployee hsHrEmployee) {
        this.hsHrEmployee = hsHrEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hsHrEmpChildrenPK != null ? hsHrEmpChildrenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpChildren)) {
            return false;
        }
        HsHrEmpChildren other = (HsHrEmpChildren) object;
        if ((this.hsHrEmpChildrenPK == null && other.hsHrEmpChildrenPK != null) || (this.hsHrEmpChildrenPK != null && !this.hsHrEmpChildrenPK.equals(other.hsHrEmpChildrenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpChildren[ hsHrEmpChildrenPK=" + hsHrEmpChildrenPK + " ]";
    }
    
}
