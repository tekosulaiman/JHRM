/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_leave_entitlement_adjustment", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveEntitlementAdjustment.findAll", query = "SELECT o FROM OhrmLeaveEntitlementAdjustment o"),
    @NamedQuery(name = "OhrmLeaveEntitlementAdjustment.findById", query = "SELECT o FROM OhrmLeaveEntitlementAdjustment o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveEntitlementAdjustment.findByLengthDays", query = "SELECT o FROM OhrmLeaveEntitlementAdjustment o WHERE o.lengthDays = :lengthDays")})
public class OhrmLeaveEntitlementAdjustment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "length_days")
    private BigDecimal lengthDays;
    @JoinColumn(name = "entitlement_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveEntitlement entitlementId;
    @JoinColumn(name = "adjustment_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveAdjustment adjustmentId;

    public OhrmLeaveEntitlementAdjustment() {
    }

    public OhrmLeaveEntitlementAdjustment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLengthDays() {
        return lengthDays;
    }

    public void setLengthDays(BigDecimal lengthDays) {
        this.lengthDays = lengthDays;
    }

    public OhrmLeaveEntitlement getEntitlementId() {
        return entitlementId;
    }

    public void setEntitlementId(OhrmLeaveEntitlement entitlementId) {
        this.entitlementId = entitlementId;
    }

    public OhrmLeaveAdjustment getAdjustmentId() {
        return adjustmentId;
    }

    public void setAdjustmentId(OhrmLeaveAdjustment adjustmentId) {
        this.adjustmentId = adjustmentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmLeaveEntitlementAdjustment)) {
            return false;
        }
        OhrmLeaveEntitlementAdjustment other = (OhrmLeaveEntitlementAdjustment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveEntitlementAdjustment[ id=" + id + " ]";
    }
    
}
