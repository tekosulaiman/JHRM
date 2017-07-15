/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_leave_adjustment", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveAdjustment.findAll", query = "SELECT o FROM OhrmLeaveAdjustment o"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findById", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByNoOfDays", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.noOfDays = :noOfDays"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByFromDate", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.fromDate = :fromDate"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByToDate", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.toDate = :toDate"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByCreditedDate", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.creditedDate = :creditedDate"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByNote", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.note = :note"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByDeleted", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "OhrmLeaveAdjustment.findByCreatedByName", query = "SELECT o FROM OhrmLeaveAdjustment o WHERE o.createdByName = :createdByName")})
public class OhrmLeaveAdjustment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "no_of_days")
    private BigDecimal noOfDays;
    @Column(name = "from_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;
    @Column(name = "to_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;
    @Column(name = "credited_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creditedDate;
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "created_by_name")
    private String createdByName;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveType leaveTypeId;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee empNumber;
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmUser createdById;
    @JoinColumn(name = "adjustment_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveEntitlementType adjustmentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adjustmentId")
    private List<OhrmLeaveEntitlementAdjustment> ohrmLeaveEntitlementAdjustmentList;

    public OhrmLeaveAdjustment() {
    }

    public OhrmLeaveAdjustment(Integer id) {
        this.id = id;
    }

    public OhrmLeaveAdjustment(Integer id, BigDecimal noOfDays, boolean deleted) {
        this.id = id;
        this.noOfDays = noOfDays;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(BigDecimal noOfDays) {
        this.noOfDays = noOfDays;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getCreditedDate() {
        return creditedDate;
    }

    public void setCreditedDate(Date creditedDate) {
        this.creditedDate = creditedDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public OhrmLeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(OhrmLeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public OhrmUser getCreatedById() {
        return createdById;
    }

    public void setCreatedById(OhrmUser createdById) {
        this.createdById = createdById;
    }

    public OhrmLeaveEntitlementType getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(OhrmLeaveEntitlementType adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    @XmlTransient
    public List<OhrmLeaveEntitlementAdjustment> getOhrmLeaveEntitlementAdjustmentList() {
        return ohrmLeaveEntitlementAdjustmentList;
    }

    public void setOhrmLeaveEntitlementAdjustmentList(List<OhrmLeaveEntitlementAdjustment> ohrmLeaveEntitlementAdjustmentList) {
        this.ohrmLeaveEntitlementAdjustmentList = ohrmLeaveEntitlementAdjustmentList;
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
        if (!(object instanceof OhrmLeaveAdjustment)) {
            return false;
        }
        OhrmLeaveAdjustment other = (OhrmLeaveAdjustment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveAdjustment[ id=" + id + " ]";
    }
    
}
