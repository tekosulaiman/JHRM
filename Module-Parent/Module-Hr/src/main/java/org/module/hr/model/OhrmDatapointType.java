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
@Table(name = "ohrm_datapoint_type", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDatapointType.findAll", query = "SELECT o FROM OhrmDatapointType o"),
    @NamedQuery(name = "OhrmDatapointType.findById", query = "SELECT o FROM OhrmDatapointType o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmDatapointType.findByName", query = "SELECT o FROM OhrmDatapointType o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmDatapointType.findByActionClass", query = "SELECT o FROM OhrmDatapointType o WHERE o.actionClass = :actionClass")})
public class OhrmDatapointType implements Serializable {
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
    @Column(name = "action_class")
    private String actionClass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "datapointTypeId")
    private List<OhrmDatapoint> ohrmDatapointList;

    public OhrmDatapointType() {
    }

    public OhrmDatapointType(Integer id) {
        this.id = id;
    }

    public OhrmDatapointType(Integer id, String name, String actionClass) {
        this.id = id;
        this.name = name;
        this.actionClass = actionClass;
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

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    @XmlTransient
    public List<OhrmDatapoint> getOhrmDatapointList() {
        return ohrmDatapointList;
    }

    public void setOhrmDatapointList(List<OhrmDatapoint> ohrmDatapointList) {
        this.ohrmDatapointList = ohrmDatapointList;
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
        if (!(object instanceof OhrmDatapointType)) {
            return false;
        }
        OhrmDatapointType other = (OhrmDatapointType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDatapointType[ id=" + id + " ]";
    }
    
}
