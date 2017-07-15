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
import javax.persistence.Lob;
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
@Table(name = "ohrm_datapoint", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDatapoint.findAll", query = "SELECT o FROM OhrmDatapoint o"),
    @NamedQuery(name = "OhrmDatapoint.findById", query = "SELECT o FROM OhrmDatapoint o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmDatapoint.findByName", query = "SELECT o FROM OhrmDatapoint o WHERE o.name = :name")})
public class OhrmDatapoint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "definition")
    private String definition;
    @JoinColumn(name = "datapoint_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmDatapointType datapointTypeId;

    public OhrmDatapoint() {
    }

    public OhrmDatapoint(Integer id) {
        this.id = id;
    }

    public OhrmDatapoint(Integer id, String definition) {
        this.id = id;
        this.definition = definition;
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public OhrmDatapointType getDatapointTypeId() {
        return datapointTypeId;
    }

    public void setDatapointTypeId(OhrmDatapointType datapointTypeId) {
        this.datapointTypeId = datapointTypeId;
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
        if (!(object instanceof OhrmDatapoint)) {
            return false;
        }
        OhrmDatapoint other = (OhrmDatapoint) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDatapoint[ id=" + id + " ]";
    }
    
}
