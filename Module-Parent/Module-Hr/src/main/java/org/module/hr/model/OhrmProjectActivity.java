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
@Table(name = "ohrm_project_activity", catalog = "orangehrm", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmProjectActivity.findAll", query = "SELECT o FROM OhrmProjectActivity o"),
    @NamedQuery(name = "OhrmProjectActivity.findByActivityId", query = "SELECT o FROM OhrmProjectActivity o WHERE o.activityId = :activityId"),
    @NamedQuery(name = "OhrmProjectActivity.findByName", query = "SELECT o FROM OhrmProjectActivity o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmProjectActivity.findByIsDeleted", query = "SELECT o FROM OhrmProjectActivity o WHERE o.isDeleted = :isDeleted")})
public class OhrmProjectActivity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_id")
    private Integer activityId;
    @Column(name = "name")
    private String name;
    @Column(name = "is_deleted")
    private Boolean isDeleted;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne(optional = false)
    private OhrmProject projectId;

    public OhrmProjectActivity() {
    }

    public OhrmProjectActivity(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public OhrmProject getProjectId() {
        return projectId;
    }

    public void setProjectId(OhrmProject projectId) {
        this.projectId = projectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmProjectActivity)) {
            return false;
        }
        OhrmProjectActivity other = (OhrmProjectActivity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmProjectActivity[ activityId=" + activityId + " ]";
    }
    
}
