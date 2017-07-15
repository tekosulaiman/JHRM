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
@Table(name = "ohrm_user_role_screen", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUserRoleScreen.findAll", query = "SELECT o FROM OhrmUserRoleScreen o"),
    @NamedQuery(name = "OhrmUserRoleScreen.findById", query = "SELECT o FROM OhrmUserRoleScreen o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUserRoleScreen.findByCanRead", query = "SELECT o FROM OhrmUserRoleScreen o WHERE o.canRead = :canRead"),
    @NamedQuery(name = "OhrmUserRoleScreen.findByCanCreate", query = "SELECT o FROM OhrmUserRoleScreen o WHERE o.canCreate = :canCreate"),
    @NamedQuery(name = "OhrmUserRoleScreen.findByCanUpdate", query = "SELECT o FROM OhrmUserRoleScreen o WHERE o.canUpdate = :canUpdate"),
    @NamedQuery(name = "OhrmUserRoleScreen.findByCanDelete", query = "SELECT o FROM OhrmUserRoleScreen o WHERE o.canDelete = :canDelete")})
public class OhrmUserRoleScreen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "can_read")
    private boolean canRead;
    @Basic(optional = false)
    @Column(name = "can_create")
    private boolean canCreate;
    @Basic(optional = false)
    @Column(name = "can_update")
    private boolean canUpdate;
    @Basic(optional = false)
    @Column(name = "can_delete")
    private boolean canDelete;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmUserRole userRoleId;
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmScreen screenId;

    public OhrmUserRoleScreen() {
    }

    public OhrmUserRoleScreen(Integer id) {
        this.id = id;
    }

    public OhrmUserRoleScreen(Integer id, boolean canRead, boolean canCreate, boolean canUpdate, boolean canDelete) {
        this.id = id;
        this.canRead = canRead;
        this.canCreate = canCreate;
        this.canUpdate = canUpdate;
        this.canDelete = canDelete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public boolean getCanCreate() {
        return canCreate;
    }

    public void setCanCreate(boolean canCreate) {
        this.canCreate = canCreate;
    }

    public boolean getCanUpdate() {
        return canUpdate;
    }

    public void setCanUpdate(boolean canUpdate) {
        this.canUpdate = canUpdate;
    }

    public boolean getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }

    public OhrmUserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(OhrmUserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    public OhrmScreen getScreenId() {
        return screenId;
    }

    public void setScreenId(OhrmScreen screenId) {
        this.screenId = screenId;
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
        if (!(object instanceof OhrmUserRoleScreen)) {
            return false;
        }
        OhrmUserRoleScreen other = (OhrmUserRoleScreen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUserRoleScreen[ id=" + id + " ]";
    }
    
}
