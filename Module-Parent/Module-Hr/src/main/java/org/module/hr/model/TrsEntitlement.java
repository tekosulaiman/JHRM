/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 10991044
 */
@Entity
@Table(name = "trs_entitlement", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrsEntitlement.findAll", query = "SELECT t FROM TrsEntitlement t"),
    @NamedQuery(name = "TrsEntitlement.findByIdEntitlement", query = "SELECT t FROM TrsEntitlement t WHERE t.idEntitlement = :idEntitlement"),
    @NamedQuery(name = "TrsEntitlement.findByEntitlement", query = "SELECT t FROM TrsEntitlement t WHERE t.entitlement = :entitlement"),
    @NamedQuery(name = "TrsEntitlement.findByIdLeaveType", query = "SELECT t FROM TrsEntitlement t WHERE t.idLeaveType = :idLeaveType")})
public class TrsEntitlement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_entitlement")
    private Integer idEntitlement;
    @Column(name = "entitlement")
    private Integer entitlement;
    @Column(name = "id_leave_type")
    private Integer idLeaveType;
    @JoinColumn(name = "id_leave_period", referencedColumnName = "id_leave_period")
    @ManyToOne
    private MstLeavePeriod idLeavePeriod;
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee")
    @ManyToOne
    private TrsEmployee idEmployee;

    public TrsEntitlement() {
    }

    public TrsEntitlement(Integer idEntitlement) {
        this.idEntitlement = idEntitlement;
    }

    public Integer getIdEntitlement() {
        return idEntitlement;
    }

    public void setIdEntitlement(Integer idEntitlement) {
        this.idEntitlement = idEntitlement;
    }

    public Integer getEntitlement() {
        return entitlement;
    }

    public void setEntitlement(Integer entitlement) {
        this.entitlement = entitlement;
    }

    public Integer getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public MstLeavePeriod getIdLeavePeriod() {
        return idLeavePeriod;
    }

    public void setIdLeavePeriod(MstLeavePeriod idLeavePeriod) {
        this.idLeavePeriod = idLeavePeriod;
    }

    public TrsEmployee getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(TrsEmployee idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntitlement != null ? idEntitlement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrsEntitlement)) {
            return false;
        }
        TrsEntitlement other = (TrsEntitlement) object;
        if ((this.idEntitlement == null && other.idEntitlement != null) || (this.idEntitlement != null && !this.idEntitlement.equals(other.idEntitlement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.TrsEntitlement[ idEntitlement=" + idEntitlement + " ]";
    }
    
}
