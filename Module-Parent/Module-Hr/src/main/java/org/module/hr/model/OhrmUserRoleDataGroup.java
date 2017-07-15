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
@Table(name = "ohrm_user_role_data_group", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUserRoleDataGroup.findAll", query = "SELECT o FROM OhrmUserRoleDataGroup o"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findById", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findByCanRead", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.canRead = :canRead"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findByCanCreate", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.canCreate = :canCreate"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findByCanUpdate", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.canUpdate = :canUpdate"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findByCanDelete", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.canDelete = :canDelete"),
    @NamedQuery(name = "OhrmUserRoleDataGroup.findBySelf", query = "SELECT o FROM OhrmUserRoleDataGroup o WHERE o.self = :self")})
public class OhrmUserRoleDataGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "can_read")
    private Short canRead;
    @Column(name = "can_create")
    private Short canCreate;
    @Column(name = "can_update")
    private Short canUpdate;
    @Column(name = "can_delete")
    private Short canDelete;
    @Column(name = "self")
    private Short self;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmUserRole userRoleId;
    @JoinColumn(name = "data_group_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmDataGroup dataGroupId;

    public OhrmUserRoleDataGroup() {
    }

    public OhrmUserRoleDataGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getCanRead() {
        return canRead;
    }

    public void setCanRead(Short canRead) {
        this.canRead = canRead;
    }

    public Short getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(Short canCreate) {
        this.canCreate = canCreate;
    }

    public Short getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(Short canUpdate) {
        this.canUpdate = canUpdate;
    }

    public Short getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(Short canDelete) {
        this.canDelete = canDelete;
    }

    public Short getSelf() {
        return self;
    }

    public void setSelf(Short self) {
        this.self = self;
    }

    public OhrmUserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(OhrmUserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    public OhrmDataGroup getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(OhrmDataGroup dataGroupId) {
        this.dataGroupId = dataGroupId;
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
        if (!(object instanceof OhrmUserRoleDataGroup)) {
            return false;
        }
        OhrmUserRoleDataGroup other = (OhrmUserRoleDataGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUserRoleDataGroup[ id=" + id + " ]";
    }
    
}
