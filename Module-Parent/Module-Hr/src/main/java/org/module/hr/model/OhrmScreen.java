/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_screen", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmScreen.findAll", query = "SELECT o FROM OhrmScreen o"),
    @NamedQuery(name = "OhrmScreen.findById", query = "SELECT o FROM OhrmScreen o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmScreen.findByName", query = "SELECT o FROM OhrmScreen o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmScreen.findByActionUrl", query = "SELECT o FROM OhrmScreen o WHERE o.actionUrl = :actionUrl")})
public class OhrmScreen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "action_url")
    private String actionUrl;
    @OneToMany(mappedBy = "screenId")
    private List<OhrmDataGroupScreen> ohrmDataGroupScreenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screenId")
    private List<OhrmUserRoleScreen> ohrmUserRoleScreenList;
    @OneToMany(mappedBy = "screenId")
    private List<OhrmMenuItem> ohrmMenuItemList;
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmModule moduleId;

    public OhrmScreen() {
    }

    public OhrmScreen(Integer id) {
        this.id = id;
    }

    public OhrmScreen(Integer id, String name, String actionUrl) {
        this.id = id;
        this.name = name;
        this.actionUrl = actionUrl;
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

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    @XmlTransient
    public List<OhrmDataGroupScreen> getOhrmDataGroupScreenList() {
        return ohrmDataGroupScreenList;
    }

    public void setOhrmDataGroupScreenList(List<OhrmDataGroupScreen> ohrmDataGroupScreenList) {
        this.ohrmDataGroupScreenList = ohrmDataGroupScreenList;
    }

    @XmlTransient
    public List<OhrmUserRoleScreen> getOhrmUserRoleScreenList() {
        return ohrmUserRoleScreenList;
    }

    public void setOhrmUserRoleScreenList(List<OhrmUserRoleScreen> ohrmUserRoleScreenList) {
        this.ohrmUserRoleScreenList = ohrmUserRoleScreenList;
    }

    @XmlTransient
    public List<OhrmMenuItem> getOhrmMenuItemList() {
        return ohrmMenuItemList;
    }

    public void setOhrmMenuItemList(List<OhrmMenuItem> ohrmMenuItemList) {
        this.ohrmMenuItemList = ohrmMenuItemList;
    }

    public OhrmModule getModuleId() {
        return moduleId;
    }

    public void setModuleId(OhrmModule moduleId) {
        this.moduleId = moduleId;
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
        if (!(object instanceof OhrmScreen)) {
            return false;
        }
        OhrmScreen other = (OhrmScreen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmScreen[ id=" + id + " ]";
    }
    
}
