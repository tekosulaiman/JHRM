package org.module.hr.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author tekosulaiman@yahoo.com
*/
@Entity
@Table(name = "trs_entitlement", catalog = "dbhr", schema = "schema_hr")
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
}