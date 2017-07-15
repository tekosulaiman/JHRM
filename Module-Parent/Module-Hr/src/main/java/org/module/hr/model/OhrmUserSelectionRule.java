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
@Table(name = "ohrm_user_selection_rule", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUserSelectionRule.findAll", query = "SELECT o FROM OhrmUserSelectionRule o"),
    @NamedQuery(name = "OhrmUserSelectionRule.findById", query = "SELECT o FROM OhrmUserSelectionRule o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUserSelectionRule.findByName", query = "SELECT o FROM OhrmUserSelectionRule o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmUserSelectionRule.findByDescription", query = "SELECT o FROM OhrmUserSelectionRule o WHERE o.description = :description"),
    @NamedQuery(name = "OhrmUserSelectionRule.findByImplementationClass", query = "SELECT o FROM OhrmUserSelectionRule o WHERE o.implementationClass = :implementationClass")})
public class OhrmUserSelectionRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "implementation_class")
    private String implementationClass;
    @Lob
    @Column(name = "rule_xml_data")
    private String ruleXmlData;

    public OhrmUserSelectionRule() {
    }

    public OhrmUserSelectionRule(Integer id) {
        this.id = id;
    }

    public OhrmUserSelectionRule(Integer id, String name, String implementationClass) {
        this.id = id;
        this.name = name;
        this.implementationClass = implementationClass;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImplementationClass() {
        return implementationClass;
    }

    public void setImplementationClass(String implementationClass) {
        this.implementationClass = implementationClass;
    }

    public String getRuleXmlData() {
        return ruleXmlData;
    }

    public void setRuleXmlData(String ruleXmlData) {
        this.ruleXmlData = ruleXmlData;
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
        if (!(object instanceof OhrmUserSelectionRule)) {
            return false;
        }
        OhrmUserSelectionRule other = (OhrmUserSelectionRule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUserSelectionRule[ id=" + id + " ]";
    }
    
}
