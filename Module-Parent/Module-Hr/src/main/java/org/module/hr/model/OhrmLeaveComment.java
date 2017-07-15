/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_leave_comment", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveComment.findAll", query = "SELECT o FROM OhrmLeaveComment o"),
    @NamedQuery(name = "OhrmLeaveComment.findById", query = "SELECT o FROM OhrmLeaveComment o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveComment.findByCreated", query = "SELECT o FROM OhrmLeaveComment o WHERE o.created = :created"),
    @NamedQuery(name = "OhrmLeaveComment.findByCreatedByName", query = "SELECT o FROM OhrmLeaveComment o WHERE o.createdByName = :createdByName"),
    @NamedQuery(name = "OhrmLeaveComment.findByComments", query = "SELECT o FROM OhrmLeaveComment o WHERE o.comments = :comments")})
public class OhrmLeaveComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @Column(name = "created_by_name")
    private String createdByName;
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "leave_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmLeave leaveId;
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmUser createdById;
    @JoinColumn(name = "created_by_emp_number", referencedColumnName = "emp_number")
    @ManyToOne
    private HsHrEmployee createdByEmpNumber;

    public OhrmLeaveComment() {
    }

    public OhrmLeaveComment(Integer id) {
        this.id = id;
    }

    public OhrmLeaveComment(Integer id, String createdByName) {
        this.id = id;
        this.createdByName = createdByName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OhrmLeave getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(OhrmLeave leaveId) {
        this.leaveId = leaveId;
    }

    public OhrmUser getCreatedById() {
        return createdById;
    }

    public void setCreatedById(OhrmUser createdById) {
        this.createdById = createdById;
    }

    public HsHrEmployee getCreatedByEmpNumber() {
        return createdByEmpNumber;
    }

    public void setCreatedByEmpNumber(HsHrEmployee createdByEmpNumber) {
        this.createdByEmpNumber = createdByEmpNumber;
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
        if (!(object instanceof OhrmLeaveComment)) {
            return false;
        }
        OhrmLeaveComment other = (OhrmLeaveComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveComment[ id=" + id + " ]";
    }
    
}
