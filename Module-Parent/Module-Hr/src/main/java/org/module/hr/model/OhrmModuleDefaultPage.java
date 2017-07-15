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
@Table(name = "ohrm_module_default_page", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmModuleDefaultPage.findAll", query = "SELECT o FROM OhrmModuleDefaultPage o"),
    @NamedQuery(name = "OhrmModuleDefaultPage.findById", query = "SELECT o FROM OhrmModuleDefaultPage o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmModuleDefaultPage.findByAction", query = "SELECT o FROM OhrmModuleDefaultPage o WHERE o.action = :action"),
    @NamedQuery(name = "OhrmModuleDefaultPage.findByEnableClass", query = "SELECT o FROM OhrmModuleDefaultPage o WHERE o.enableClass = :enableClass"),
    @NamedQuery(name = "OhrmModuleDefaultPage.findByPriority", query = "SELECT o FROM OhrmModuleDefaultPage o WHERE o.priority = :priority")})
public class OhrmModuleDefaultPage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "action")
    private String action;
    @Column(name = "enable_class")
    private String enableClass;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;
    @JoinColumn(name = "user_role_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmUserRole userRoleId;
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmModule moduleId;

    public OhrmModuleDefaultPage() {
    }

    public OhrmModuleDefaultPage(Integer id) {
        this.id = id;
    }

    public OhrmModuleDefaultPage(Integer id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEnableClass() {
        return enableClass;
    }

    public void setEnableClass(String enableClass) {
        this.enableClass = enableClass;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public OhrmUserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(OhrmUserRole userRoleId) {
        this.userRoleId = userRoleId;
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
        if (!(object instanceof OhrmModuleDefaultPage)) {
            return false;
        }
        OhrmModuleDefaultPage other = (OhrmModuleDefaultPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmModuleDefaultPage[ id=" + id + " ]";
    }
    
}
