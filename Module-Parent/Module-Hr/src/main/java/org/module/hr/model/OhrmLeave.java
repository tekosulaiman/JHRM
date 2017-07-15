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
@Table(name = "ohrm_leave", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeave.findAll", query = "SELECT o FROM OhrmLeave o"),
    @NamedQuery(name = "OhrmLeave.findById", query = "SELECT o FROM OhrmLeave o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeave.findByDate", query = "SELECT o FROM OhrmLeave o WHERE o.date = :date"),
    @NamedQuery(name = "OhrmLeave.findByLengthHours", query = "SELECT o FROM OhrmLeave o WHERE o.lengthHours = :lengthHours"),
    @NamedQuery(name = "OhrmLeave.findByLengthDays", query = "SELECT o FROM OhrmLeave o WHERE o.lengthDays = :lengthDays"),
    @NamedQuery(name = "OhrmLeave.findByStatus", query = "SELECT o FROM OhrmLeave o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmLeave.findByComments", query = "SELECT o FROM OhrmLeave o WHERE o.comments = :comments"),
    @NamedQuery(name = "OhrmLeave.findByEmpNumber", query = "SELECT o FROM OhrmLeave o WHERE o.empNumber = :empNumber"),
    @NamedQuery(name = "OhrmLeave.findByStartTime", query = "SELECT o FROM OhrmLeave o WHERE o.startTime = :startTime"),
    @NamedQuery(name = "OhrmLeave.findByEndTime", query = "SELECT o FROM OhrmLeave o WHERE o.endTime = :endTime"),
    @NamedQuery(name = "OhrmLeave.findByDurationType", query = "SELECT o FROM OhrmLeave o WHERE o.durationType = :durationType")})
public class OhrmLeave implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "length_hours")
    private BigDecimal lengthHours;
    @Column(name = "length_days")
    private BigDecimal lengthDays;
    @Column(name = "status")
    private Short status;
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @Column(name = "emp_number")
    private int empNumber;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Basic(optional = false)
    @Column(name = "duration_type")
    private short durationType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveId")
    private List<OhrmLeaveLeaveEntitlement> ohrmLeaveLeaveEntitlementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveId")
    private List<OhrmLeaveComment> ohrmLeaveCommentList;
    @JoinColumn(name = "leave_request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveRequest leaveRequestId;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveType leaveTypeId;

    public OhrmLeave() {
    }

    public OhrmLeave(Integer id) {
        this.id = id;
    }

    public OhrmLeave(Integer id, int empNumber, short durationType) {
        this.id = id;
        this.empNumber = empNumber;
        this.durationType = durationType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getLengthHours() {
        return lengthHours;
    }

    public void setLengthHours(BigDecimal lengthHours) {
        this.lengthHours = lengthHours;
    }

    public BigDecimal getLengthDays() {
        return lengthDays;
    }

    public void setLengthDays(BigDecimal lengthDays) {
        this.lengthDays = lengthDays;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public short getDurationType() {
        return durationType;
    }

    public void setDurationType(short durationType) {
        this.durationType = durationType;
    }

    @XmlTransient
    public List<OhrmLeaveLeaveEntitlement> getOhrmLeaveLeaveEntitlementList() {
        return ohrmLeaveLeaveEntitlementList;
    }

    public void setOhrmLeaveLeaveEntitlementList(List<OhrmLeaveLeaveEntitlement> ohrmLeaveLeaveEntitlementList) {
        this.ohrmLeaveLeaveEntitlementList = ohrmLeaveLeaveEntitlementList;
    }

    @XmlTransient
    public List<OhrmLeaveComment> getOhrmLeaveCommentList() {
        return ohrmLeaveCommentList;
    }

    public void setOhrmLeaveCommentList(List<OhrmLeaveComment> ohrmLeaveCommentList) {
        this.ohrmLeaveCommentList = ohrmLeaveCommentList;
    }

    public OhrmLeaveRequest getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(OhrmLeaveRequest leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public OhrmLeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(OhrmLeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
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
        if (!(object instanceof OhrmLeave)) {
            return false;
        }
        OhrmLeave other = (OhrmLeave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeave[ id=" + id + " ]";
    }
    
}
