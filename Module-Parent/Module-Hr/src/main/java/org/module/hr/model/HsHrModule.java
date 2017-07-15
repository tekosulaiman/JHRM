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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "hs_hr_module", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrModule.findAll", query = "SELECT h FROM HsHrModule h"),
    @NamedQuery(name = "HsHrModule.findByModId", query = "SELECT h FROM HsHrModule h WHERE h.modId = :modId"),
    @NamedQuery(name = "HsHrModule.findByName", query = "SELECT h FROM HsHrModule h WHERE h.name = :name"),
    @NamedQuery(name = "HsHrModule.findByOwner", query = "SELECT h FROM HsHrModule h WHERE h.owner = :owner"),
    @NamedQuery(name = "HsHrModule.findByOwnerEmail", query = "SELECT h FROM HsHrModule h WHERE h.ownerEmail = :ownerEmail"),
    @NamedQuery(name = "HsHrModule.findByVersion", query = "SELECT h FROM HsHrModule h WHERE h.version = :version")})
public class HsHrModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "mod_id")
    private String modId;
    @Column(name = "name")
    private String name;
    @Column(name = "owner")
    private String owner;
    @Column(name = "owner_email")
    private String ownerEmail;
    @Column(name = "version")
    private String version;
    @Lob
    @Column(name = "description")
    private String description;

    public HsHrModule() {
    }

    public HsHrModule(String modId) {
        this.modId = modId;
    }

    public String getModId() {
        return modId;
    }

    public void setModId(String modId) {
        this.modId = modId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modId != null ? modId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrModule)) {
            return false;
        }
        HsHrModule other = (HsHrModule) object;
        if ((this.modId == null && other.modId != null) || (this.modId != null && !this.modId.equals(other.modId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrModule[ modId=" + modId + " ]";
    }
    
}
