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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_data_group", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDataGroup.findAll", query = "SELECT o FROM OhrmDataGroup o"),
    @NamedQuery(name = "OhrmDataGroup.findById", query = "SELECT o FROM OhrmDataGroup o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmDataGroup.findByName", query = "SELECT o FROM OhrmDataGroup o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmDataGroup.findByDescription", query = "SELECT o FROM OhrmDataGroup o WHERE o.description = :description"),
    @NamedQuery(name = "OhrmDataGroup.findByCanRead", query = "SELECT o FROM OhrmDataGroup o WHERE o.canRead = :canRead"),
    @NamedQuery(name = "OhrmDataGroup.findByCanCreate", query = "SELECT o FROM OhrmDataGroup o WHERE o.canCreate = :canCreate"),
    @NamedQuery(name = "OhrmDataGroup.findByCanUpdate", query = "SELECT o FROM OhrmDataGroup o WHERE o.canUpdate = :canUpdate"),
    @NamedQuery(name = "OhrmDataGroup.findByCanDelete", query = "SELECT o FROM OhrmDataGroup o WHERE o.canDelete = :canDelete")})
public class OhrmDataGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "can_read")
    private Short canRead;
    @Column(name = "can_create")
    private Short canCreate;
    @Column(name = "can_update")
    private Short canUpdate;
    @Column(name = "can_delete")
    private Short canDelete;
    @OneToMany(mappedBy = "dataGroupId")
    private List<OhrmUserRoleDataGroup> ohrmUserRoleDataGroupList;
    @OneToMany(mappedBy = "dataGroupId")
    private List<OhrmDataGroupScreen> ohrmDataGroupScreenList;

    public OhrmDataGroup() {
    }

    public OhrmDataGroup(Integer id) {
        this.id = id;
    }

    public OhrmDataGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public List<OhrmUserRoleDataGroup> getOhrmUserRoleDataGroupList() {
        return ohrmUserRoleDataGroupList;
    }

    public void setOhrmUserRoleDataGroupList(List<OhrmUserRoleDataGroup> ohrmUserRoleDataGroupList) {
        this.ohrmUserRoleDataGroupList = ohrmUserRoleDataGroupList;
    }

    @XmlTransient
    public List<OhrmDataGroupScreen> getOhrmDataGroupScreenList() {
        return ohrmDataGroupScreenList;
    }

    public void setOhrmDataGroupScreenList(List<OhrmDataGroupScreen> ohrmDataGroupScreenList) {
        this.ohrmDataGroupScreenList = ohrmDataGroupScreenList;
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
        if (!(object instanceof OhrmDataGroup)) {
            return false;
        }
        OhrmDataGroup other = (OhrmDataGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDataGroup[ id=" + id + " ]";
    }
    
}
