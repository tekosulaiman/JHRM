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
@Table(name = "hs_hr_emp_contract_extend", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrEmpContractExtend.findAll", query = "SELECT h FROM HsHrEmpContractExtend h"),
    @NamedQuery(name = "HsHrEmpContractExtend.findByEmpNumber", query = "SELECT h FROM HsHrEmpContractExtend h WHERE h.hsHrEmpContractExtendPK.empNumber = :empNumber"),
    @NamedQuery(name = "HsHrEmpContractExtend.findByEconExtendId", query = "SELECT h FROM HsHrEmpContractExtend h WHERE h.hsHrEmpContractExtendPK.econExtendId = :econExtendId"),
    @NamedQuery(name = "HsHrEmpContractExtend.findByEconExtendStartDate", query = "SELECT h FROM HsHrEmpContractExtend h WHERE h.econExtendStartDate = :econExtendStartDate"),
    @NamedQuery(name = "HsHrEmpContractExtend.findByEconExtendEndDate", query = "SELECT h FROM HsHrEmpContractExtend h WHERE h.econExtendEndDate = :econExtendEndDate")})
public class HsHrEmpContractExtend implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HsHrEmpContractExtendPK hsHrEmpContractExtendPK;
    @Column(name = "econ_extend_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date econExtendStartDate;
    @Column(name = "econ_extend_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date econExtendEndDate;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HsHrEmployee hsHrEmployee;

    public HsHrEmpContractExtend() {
    }

    public HsHrEmpContractExtend(HsHrEmpContractExtendPK hsHrEmpContractExtendPK) {
        this.hsHrEmpContractExtendPK = hsHrEmpContractExtendPK;
    }

    public HsHrEmpContractExtend(int empNumber, long econExtendId) {
        this.hsHrEmpContractExtendPK = new HsHrEmpContractExtendPK(empNumber, econExtendId);
    }

    public HsHrEmpContractExtendPK getHsHrEmpContractExtendPK() {
        return hsHrEmpContractExtendPK;
    }

    public void setHsHrEmpContractExtendPK(HsHrEmpContractExtendPK hsHrEmpContractExtendPK) {
        this.hsHrEmpContractExtendPK = hsHrEmpContractExtendPK;
    }

    public Date getEconExtendStartDate() {
        return econExtendStartDate;
    }

    public void setEconExtendStartDate(Date econExtendStartDate) {
        this.econExtendStartDate = econExtendStartDate;
    }

    public Date getEconExtendEndDate() {
        return econExtendEndDate;
    }

    public void setEconExtendEndDate(Date econExtendEndDate) {
        this.econExtendEndDate = econExtendEndDate;
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
        hash += (hsHrEmpContractExtendPK != null ? hsHrEmpContractExtendPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrEmpContractExtend)) {
            return false;
        }
        HsHrEmpContractExtend other = (HsHrEmpContractExtend) object;
        if ((this.hsHrEmpContractExtendPK == null && other.hsHrEmpContractExtendPK != null) || (this.hsHrEmpContractExtendPK != null && !this.hsHrEmpContractExtendPK.equals(other.hsHrEmpContractExtendPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrEmpContractExtend[ hsHrEmpContractExtendPK=" + hsHrEmpContractExtendPK + " ]";
    }
    
}
