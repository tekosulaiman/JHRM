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
@Table(name = "ohrm_user_role", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUserRole.findAll", query = "SELECT o FROM OhrmUserRole o"),
    @NamedQuery(name = "OhrmUserRole.findById", query = "SELECT o FROM OhrmUserRole o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUserRole.findByName", query = "SELECT o FROM OhrmUserRole o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmUserRole.findByDisplayName", query = "SELECT o FROM OhrmUserRole o WHERE o.displayName = :displayName"),
    @NamedQuery(name = "OhrmUserRole.findByIsAssignable", query = "SELECT o FROM OhrmUserRole o WHERE o.isAssignable = :isAssignable"),
    @NamedQuery(name = "OhrmUserRole.findByIsPredefined", query = "SELECT o FROM OhrmUserRole o WHERE o.isPredefined = :isPredefined")})
public class OhrmUserRole implements Serializable {
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
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "is_assignable")
    private Boolean isAssignable;
    @Column(name = "is_predefined")
    private Boolean isPredefined;
    @OneToMany(mappedBy = "userRoleId")
    private List<OhrmUserRoleDataGroup> ohrmUserRoleDataGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private List<OhrmHomePage> ohrmHomePageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private List<OhrmUserRoleScreen> ohrmUserRoleScreenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private List<OhrmUser> ohrmUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRoleId")
    private List<OhrmModuleDefaultPage> ohrmModuleDefaultPageList;

    public OhrmUserRole() {
    }

    public OhrmUserRole(Integer id) {
        this.id = id;
    }

    public OhrmUserRole(Integer id, String name, String displayName) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Boolean getIsAssignable() {
        return isAssignable;
    }

    public void setIsAssignable(Boolean isAssignable) {
        this.isAssignable = isAssignable;
    }

    public Boolean getIsPredefined() {
        return isPredefined;
    }

    public void setIsPredefined(Boolean isPredefined) {
        this.isPredefined = isPredefined;
    }

    @XmlTransient
    public List<OhrmUserRoleDataGroup> getOhrmUserRoleDataGroupList() {
        return ohrmUserRoleDataGroupList;
    }

    public void setOhrmUserRoleDataGroupList(List<OhrmUserRoleDataGroup> ohrmUserRoleDataGroupList) {
        this.ohrmUserRoleDataGroupList = ohrmUserRoleDataGroupList;
    }

    @XmlTransient
    public List<OhrmHomePage> getOhrmHomePageList() {
        return ohrmHomePageList;
    }

    public void setOhrmHomePageList(List<OhrmHomePage> ohrmHomePageList) {
        this.ohrmHomePageList = ohrmHomePageList;
    }

    @XmlTransient
    public List<OhrmUserRoleScreen> getOhrmUserRoleScreenList() {
        return ohrmUserRoleScreenList;
    }

    public void setOhrmUserRoleScreenList(List<OhrmUserRoleScreen> ohrmUserRoleScreenList) {
        this.ohrmUserRoleScreenList = ohrmUserRoleScreenList;
    }

    @XmlTransient
    public List<OhrmUser> getOhrmUserList() {
        return ohrmUserList;
    }

    public void setOhrmUserList(List<OhrmUser> ohrmUserList) {
        this.ohrmUserList = ohrmUserList;
    }

    @XmlTransient
    public List<OhrmModuleDefaultPage> getOhrmModuleDefaultPageList() {
        return ohrmModuleDefaultPageList;
    }

    public void setOhrmModuleDefaultPageList(List<OhrmModuleDefaultPage> ohrmModuleDefaultPageList) {
        this.ohrmModuleDefaultPageList = ohrmModuleDefaultPageList;
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
        if (!(object instanceof OhrmUserRole)) {
            return false;
        }
        OhrmUserRole other = (OhrmUserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUserRole[ id=" + id + " ]";
    }
    
}
