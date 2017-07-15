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
@Table(name = "ohrm_leave_request", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveRequest.findAll", query = "SELECT o FROM OhrmLeaveRequest o"),
    @NamedQuery(name = "OhrmLeaveRequest.findById", query = "SELECT o FROM OhrmLeaveRequest o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveRequest.findByDateApplied", query = "SELECT o FROM OhrmLeaveRequest o WHERE o.dateApplied = :dateApplied"),
    @NamedQuery(name = "OhrmLeaveRequest.findByComments", query = "SELECT o FROM OhrmLeaveRequest o WHERE o.comments = :comments")})
public class OhrmLeaveRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_applied")
    @Temporal(TemporalType.DATE)
    private Date dateApplied;
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "emp_number", referencedColumnName = "emp_number")
    @ManyToOne(optional = false)
    private HsHrEmployee empNumber;
    @JoinColumn(name = "leave_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeaveType leaveTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequestId")
    private List<OhrmLeaveRequestComment> ohrmLeaveRequestCommentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leaveRequestId")
    private List<OhrmLeave> ohrmLeaveList;

    public OhrmLeaveRequest() {
    }

    public OhrmLeaveRequest(Integer id) {
        this.id = id;
    }

    public OhrmLeaveRequest(Integer id, Date dateApplied) {
        this.id = id;
        this.dateApplied = dateApplied;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public HsHrEmployee getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(HsHrEmployee empNumber) {
        this.empNumber = empNumber;
    }

    public OhrmLeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(OhrmLeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    @XmlTransient
    public List<OhrmLeaveRequestComment> getOhrmLeaveRequestCommentList() {
        return ohrmLeaveRequestCommentList;
    }

    public void setOhrmLeaveRequestCommentList(List<OhrmLeaveRequestComment> ohrmLeaveRequestCommentList) {
        this.ohrmLeaveRequestCommentList = ohrmLeaveRequestCommentList;
    }

    @XmlTransient
    public List<OhrmLeave> getOhrmLeaveList() {
        return ohrmLeaveList;
    }

    public void setOhrmLeaveList(List<OhrmLeave> ohrmLeaveList) {
        this.ohrmLeaveList = ohrmLeaveList;
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
        if (!(object instanceof OhrmLeaveRequest)) {
            return false;
        }
        OhrmLeaveRequest other = (OhrmLeaveRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveRequest[ id=" + id + " ]";
    }
    
}
