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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_leave_status", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmLeaveStatus.findAll", query = "SELECT o FROM OhrmLeaveStatus o"),
    @NamedQuery(name = "OhrmLeaveStatus.findById", query = "SELECT o FROM OhrmLeaveStatus o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmLeaveStatus.findByStatus", query = "SELECT o FROM OhrmLeaveStatus o WHERE o.status = :status"),
    @NamedQuery(name = "OhrmLeaveStatus.findByName", query = "SELECT o FROM OhrmLeaveStatus o WHERE o.name = :name")})
public class OhrmLeaveStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public OhrmLeaveStatus() {
    }

    public OhrmLeaveStatus(Integer id) {
        this.id = id;
    }

    public OhrmLeaveStatus(Integer id, short status, String name) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof OhrmLeaveStatus)) {
            return false;
        }
        OhrmLeaveStatus other = (OhrmLeaveStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmLeaveStatus[ id=" + id + " ]";
    }
    
}
