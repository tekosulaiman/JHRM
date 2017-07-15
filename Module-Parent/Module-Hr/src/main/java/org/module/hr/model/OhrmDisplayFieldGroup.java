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
@Table(name = "ohrm_display_field_group", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDisplayFieldGroup.findAll", query = "SELECT o FROM OhrmDisplayFieldGroup o"),
    @NamedQuery(name = "OhrmDisplayFieldGroup.findById", query = "SELECT o FROM OhrmDisplayFieldGroup o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmDisplayFieldGroup.findByName", query = "SELECT o FROM OhrmDisplayFieldGroup o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmDisplayFieldGroup.findByIsList", query = "SELECT o FROM OhrmDisplayFieldGroup o WHERE o.isList = :isList")})
public class OhrmDisplayFieldGroup implements Serializable {
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
    @Column(name = "is_list")
    private boolean isList;
    @OneToMany(mappedBy = "displayFieldGroupId")
    private List<OhrmCompositeDisplayField> ohrmCompositeDisplayFieldList;
    @JoinColumn(name = "report_group_id", referencedColumnName = "report_group_id")
    @ManyToOne(optional = false)
    private OhrmReportGroup reportGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "displayFieldGroupId")
    private List<OhrmSelectedDisplayFieldGroup> ohrmSelectedDisplayFieldGroupList;
    @OneToMany(mappedBy = "displayFieldGroupId")
    private List<OhrmDisplayField> ohrmDisplayFieldList;
    @OneToMany(mappedBy = "displayFieldGroupId")
    private List<OhrmSummaryDisplayField> ohrmSummaryDisplayFieldList;

    public OhrmDisplayFieldGroup() {
    }

    public OhrmDisplayFieldGroup(Integer id) {
        this.id = id;
    }

    public OhrmDisplayFieldGroup(Integer id, String name, boolean isList) {
        this.id = id;
        this.name = name;
        this.isList = isList;
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

    public boolean getIsList() {
        return isList;
    }

    public void setIsList(boolean isList) {
        this.isList = isList;
    }

    @XmlTransient
    public List<OhrmCompositeDisplayField> getOhrmCompositeDisplayFieldList() {
        return ohrmCompositeDisplayFieldList;
    }

    public void setOhrmCompositeDisplayFieldList(List<OhrmCompositeDisplayField> ohrmCompositeDisplayFieldList) {
        this.ohrmCompositeDisplayFieldList = ohrmCompositeDisplayFieldList;
    }

    public OhrmReportGroup getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(OhrmReportGroup reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    @XmlTransient
    public List<OhrmSelectedDisplayFieldGroup> getOhrmSelectedDisplayFieldGroupList() {
        return ohrmSelectedDisplayFieldGroupList;
    }

    public void setOhrmSelectedDisplayFieldGroupList(List<OhrmSelectedDisplayFieldGroup> ohrmSelectedDisplayFieldGroupList) {
        this.ohrmSelectedDisplayFieldGroupList = ohrmSelectedDisplayFieldGroupList;
    }

    @XmlTransient
    public List<OhrmDisplayField> getOhrmDisplayFieldList() {
        return ohrmDisplayFieldList;
    }

    public void setOhrmDisplayFieldList(List<OhrmDisplayField> ohrmDisplayFieldList) {
        this.ohrmDisplayFieldList = ohrmDisplayFieldList;
    }

    @XmlTransient
    public List<OhrmSummaryDisplayField> getOhrmSummaryDisplayFieldList() {
        return ohrmSummaryDisplayFieldList;
    }

    public void setOhrmSummaryDisplayFieldList(List<OhrmSummaryDisplayField> ohrmSummaryDisplayFieldList) {
        this.ohrmSummaryDisplayFieldList = ohrmSummaryDisplayFieldList;
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
        if (!(object instanceof OhrmDisplayFieldGroup)) {
            return false;
        }
        OhrmDisplayFieldGroup other = (OhrmDisplayFieldGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDisplayFieldGroup[ id=" + id + " ]";
    }
    
}
