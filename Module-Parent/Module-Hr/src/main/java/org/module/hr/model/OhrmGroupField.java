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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "ohrm_group_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmGroupField.findAll", query = "SELECT o FROM OhrmGroupField o"),
    @NamedQuery(name = "OhrmGroupField.findByGroupFieldId", query = "SELECT o FROM OhrmGroupField o WHERE o.groupFieldId = :groupFieldId"),
    @NamedQuery(name = "OhrmGroupField.findByName", query = "SELECT o FROM OhrmGroupField o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmGroupField.findByGroupFieldWidget", query = "SELECT o FROM OhrmGroupField o WHERE o.groupFieldWidget = :groupFieldWidget")})
public class OhrmGroupField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "group_field_id")
    private Long groupFieldId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "group_by_clause")
    private String groupByClause;
    @Column(name = "group_field_widget")
    private String groupFieldWidget;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmGroupField")
    private List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmGroupField")
    private List<OhrmAvailableGroupField> ohrmAvailableGroupFieldList;

    public OhrmGroupField() {
    }

    public OhrmGroupField(Long groupFieldId) {
        this.groupFieldId = groupFieldId;
    }

    public OhrmGroupField(Long groupFieldId, String name, String groupByClause) {
        this.groupFieldId = groupFieldId;
        this.name = name;
        this.groupByClause = groupByClause;
    }

    public Long getGroupFieldId() {
        return groupFieldId;
    }

    public void setGroupFieldId(Long groupFieldId) {
        this.groupFieldId = groupFieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupByClause() {
        return groupByClause;
    }

    public void setGroupByClause(String groupByClause) {
        this.groupByClause = groupByClause;
    }

    public String getGroupFieldWidget() {
        return groupFieldWidget;
    }

    public void setGroupFieldWidget(String groupFieldWidget) {
        this.groupFieldWidget = groupFieldWidget;
    }

    @XmlTransient
    public List<OhrmSelectedGroupField> getOhrmSelectedGroupFieldList() {
        return ohrmSelectedGroupFieldList;
    }

    public void setOhrmSelectedGroupFieldList(List<OhrmSelectedGroupField> ohrmSelectedGroupFieldList) {
        this.ohrmSelectedGroupFieldList = ohrmSelectedGroupFieldList;
    }

    @XmlTransient
    public List<OhrmAvailableGroupField> getOhrmAvailableGroupFieldList() {
        return ohrmAvailableGroupFieldList;
    }

    public void setOhrmAvailableGroupFieldList(List<OhrmAvailableGroupField> ohrmAvailableGroupFieldList) {
        this.ohrmAvailableGroupFieldList = ohrmAvailableGroupFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupFieldId != null ? groupFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmGroupField)) {
            return false;
        }
        OhrmGroupField other = (OhrmGroupField) object;
        if ((this.groupFieldId == null && other.groupFieldId != null) || (this.groupFieldId != null && !this.groupFieldId.equals(other.groupFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmGroupField[ groupFieldId=" + groupFieldId + " ]";
    }
    
}
