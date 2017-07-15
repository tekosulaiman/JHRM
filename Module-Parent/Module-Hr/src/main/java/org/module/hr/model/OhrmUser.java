/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
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
@Table(name = "ohrm_user", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUser.findAll", query = "SELECT o FROM OhrmUser o"),
    @NamedQuery(name = "OhrmUser.findById", query = "SELECT o FROM OhrmUser o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUser.findByUserName", query = "SELECT o FROM OhrmUser o WHERE o.userName = :userName"),
    @NamedQuery(name = "OhrmUser.findByUserPassword", query = "SELECT o FROM OhrmUser o WHERE o.userPassword = :userPassword"),
    @NamedQuery(name = "OhrmUser.findByDeleted", query = "SELECT o FROM OhrmUser o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "OhrmUser.findByStatus", query = "SELECT o FROM OhrmUser o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmUser.findByDateEntered", query = "SELECT o FROM OhrmUser o WHERE o.dateEntered = :dateEntered"),
    @NamedQuery(name = "OhrmUser.findByDateModified", query = "SELECT o FROM OhrmUser o WHERE o.dateModified = :dateModified"),
    @NamedQuery(name = "OhrmUser.findByModifiedUserId", query = "SELECT o FROM OhrmUser o WHERE o.modifiedUserId = :modifiedUserId"),
    @NamedQuery(name = "OhrmUser.findByCreatedBy", query = "SELECT o FROM OhrmUser o WHERE o.createdBy = :createdBy")})
public class OhrmUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @Column(name = "deleted")
    private boolean deleted;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Column(name = "date_entered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEntered;
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    @Column(name = "modified_user_id")
    private Integer modifiedUserId;
    @Column(name = "created_by")
    private Integer createdBy;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee empNumber;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmUserRole userRoleId;
    @OneToMany(mappedBy = "createdById")
    private List<OhrmLeaveEntitlement> ohrmLeaveEntitlementList;
    @OneToMany(mappedBy = "createdById")
    private List<OhrmLeaveAdjustment> ohrmLeaveAdjustmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "performedBy")
    private List<OhrmTimesheetActionLog> ohrmTimesheetActionLogList;
    @OneToMany(mappedBy = "createdById")
    private List<OhrmLeaveComment> ohrmLeaveCommentList;
    @OneToMany(mappedBy = "createdById")
    private List<OhrmLeaveRequestComment> ohrmLeaveRequestCommentList;
    @OneToMany(mappedBy = "userId")
    private List<OhrmPerformanceTrackerLog> ohrmPerformanceTrackerLogList;

    public OhrmUser() {
    }

    public OhrmUser(Integer id) {
        this.id = id;
    }

    public OhrmUser(Integer id, boolean deleted, boolean status) {
        this.id = id;
        this.deleted = deleted;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Integer getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(Integer modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public OhrmUserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(OhrmUserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    @XmlTransient
    public List<OhrmLeaveEntitlement> getOhrmLeaveEntitlementList() {
        return ohrmLeaveEntitlementList;
    }

    public void setOhrmLeaveEntitlementList(List<OhrmLeaveEntitlement> ohrmLeaveEntitlementList) {
        this.ohrmLeaveEntitlementList = ohrmLeaveEntitlementList;
    }

    @XmlTransient
    public List<OhrmLeaveAdjustment> getOhrmLeaveAdjustmentList() {
        return ohrmLeaveAdjustmentList;
    }

    public void setOhrmLeaveAdjustmentList(List<OhrmLeaveAdjustment> ohrmLeaveAdjustmentList) {
        this.ohrmLeaveAdjustmentList = ohrmLeaveAdjustmentList;
    }

    @XmlTransient
    public List<OhrmTimesheetActionLog> getOhrmTimesheetActionLogList() {
        return ohrmTimesheetActionLogList;
    }

    public void setOhrmTimesheetActionLogList(List<OhrmTimesheetActionLog> ohrmTimesheetActionLogList) {
        this.ohrmTimesheetActionLogList = ohrmTimesheetActionLogList;
    }

    @XmlTransient
    public List<OhrmLeaveComment> getOhrmLeaveCommentList() {
        return ohrmLeaveCommentList;
    }

    public void setOhrmLeaveCommentList(List<OhrmLeaveComment> ohrmLeaveCommentList) {
        this.ohrmLeaveCommentList = ohrmLeaveCommentList;
    }

    @XmlTransient
    public List<OhrmLeaveRequestComment> getOhrmLeaveRequestCommentList() {
        return ohrmLeaveRequestCommentList;
    }

    public void setOhrmLeaveRequestCommentList(List<OhrmLeaveRequestComment> ohrmLeaveRequestCommentList) {
        this.ohrmLeaveRequestCommentList = ohrmLeaveRequestCommentList;
    }

    @XmlTransient
    public List<OhrmPerformanceTrackerLog> getOhrmPerformanceTrackerLogList() {
        return ohrmPerformanceTrackerLogList;
    }

    public void setOhrmPerformanceTrackerLogList(List<OhrmPerformanceTrackerLog> ohrmPerformanceTrackerLogList) {
        this.ohrmPerformanceTrackerLogList = ohrmPerformanceTrackerLogList;
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
        if (!(object instanceof OhrmUser)) {
            return false;
        }
        OhrmUser other = (OhrmUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUser[ id=" + id + " ]";
    }
    
}
