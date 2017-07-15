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
@Table(name = "ohrm_advanced_report", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmAdvancedReport.findAll", query = "SELECT o FROM OhrmAdvancedReport o"),
    @NamedQuery(name = "OhrmAdvancedReport.findById", query = "SELECT o FROM OhrmAdvancedReport o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmAdvancedReport.findByName", query = "SELECT o FROM OhrmAdvancedReport o WHERE o.name = :name")})
public class OhrmAdvancedReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "definition")
    private String definition;

    public OhrmAdvancedReport() {
    }

    public OhrmAdvancedReport(Integer id) {
        this.id = id;
    }

    public OhrmAdvancedReport(Integer id, String name, String definition) {
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmAdvancedReport)) {
            return false;
        }
        OhrmAdvancedReport other = (OhrmAdvancedReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmAdvancedReport[ id=" + id + " ]";
    }
    
}
