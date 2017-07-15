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
@Table(name = "ohrm_project", catalog = "orangehrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmProject.findAll", query = "SELECT o FROM OhrmProject o"),
    @NamedQuery(name = "OhrmProject.findByProjectId", query = "SELECT o FROM OhrmProject o WHERE o.projectId = :projectId"),
    @NamedQuery(name = "OhrmProject.findByCustomerId", query = "SELECT o FROM OhrmProject o WHERE o.customerId = :customerId"),
    @NamedQuery(name = "OhrmProject.findByName", query = "SELECT o FROM OhrmProject o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmProject.findByDescription", query = "SELECT o FROM OhrmProject o WHERE o.description = :description"),
    @NamedQuery(name = "OhrmProject.findByIsDeleted", query = "SELECT o FROM OhrmProject o WHERE o.isDeleted = :isDeleted")})
public class OhrmProject implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private List<OhrmProjectActivity> ohrmProjectActivityList;

    public OhrmProject() {
    }

    public OhrmProject(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @XmlTransient
    public List<OhrmProjectActivity> getOhrmProjectActivityList() {
        return ohrmProjectActivityList;
    }

    public void setOhrmProjectActivityList(List<OhrmProjectActivity> ohrmProjectActivityList) {
        this.ohrmProjectActivityList = ohrmProjectActivityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmProject)) {
            return false;
        }
        OhrmProject other = (OhrmProject) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmProject[ projectId=" + projectId + " ]";
    }
    
}
