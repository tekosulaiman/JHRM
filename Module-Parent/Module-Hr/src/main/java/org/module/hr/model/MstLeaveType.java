/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 10991044
 */
@Entity
@Table(name = "mst_leave_type", catalog = "dbhr", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstLeaveType.findAll", query = "SELECT m FROM MstLeaveType m"),
    @NamedQuery(name = "MstLeaveType.findByIdLeaveType", query = "SELECT m FROM MstLeaveType m WHERE m.idLeaveType = :idLeaveType"),
    @NamedQuery(name = "MstLeaveType.findByType", query = "SELECT m FROM MstLeaveType m WHERE m.type = :type")})
public class MstLeaveType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_leave_type")
    private Integer idLeaveType;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "idLeaveType")
    private List<TrsLeave> trsLeaveList;

    public MstLeaveType() {
    }

    public MstLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public Integer getIdLeaveType() {
        return idLeaveType;
    }

    public void setIdLeaveType(Integer idLeaveType) {
        this.idLeaveType = idLeaveType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<TrsLeave> getTrsLeaveList() {
        return trsLeaveList;
    }

    public void setTrsLeaveList(List<TrsLeave> trsLeaveList) {
        this.trsLeaveList = trsLeaveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeaveType != null ? idLeaveType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstLeaveType)) {
            return false;
        }
        MstLeaveType other = (MstLeaveType) object;
        if ((this.idLeaveType == null && other.idLeaveType != null) || (this.idLeaveType != null && !this.idLeaveType.equals(other.idLeaveType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.MstLeaveType[ idLeaveType=" + idLeaveType + " ]";
    }
    
}
