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
@Table(name = "ohrm_data_group_screen", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDataGroupScreen.findAll", query = "SELECT o FROM OhrmDataGroupScreen o"),
    @NamedQuery(name = "OhrmDataGroupScreen.findById", query = "SELECT o FROM OhrmDataGroupScreen o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmDataGroupScreen.findByPermission", query = "SELECT o FROM OhrmDataGroupScreen o WHERE o.permission = :permission")})
public class OhrmDataGroupScreen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "permission")
    private Integer permission;
    @JoinColumn(name = "data_group_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmDataGroup dataGroupId;
    @JoinColumn(name = "screen_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmScreen screenId;

    public OhrmDataGroupScreen() {
    }

    public OhrmDataGroupScreen(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }

    public OhrmDataGroup getDataGroupId() {
        return dataGroupId;
    }

    public void setDataGroupId(OhrmDataGroup dataGroupId) {
        this.dataGroupId = dataGroupId;
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
        if (!(object instanceof OhrmDataGroupScreen)) {
            return false;
        }
        OhrmDataGroupScreen other = (OhrmDataGroupScreen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDataGroupScreen[ id=" + id + " ]";
    }
    
}
