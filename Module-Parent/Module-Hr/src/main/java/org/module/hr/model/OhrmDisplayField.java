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
@Table(name = "ohrm_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmDisplayField.findAll", query = "SELECT o FROM OhrmDisplayField o"),
    @NamedQuery(name = "OhrmDisplayField.findByDisplayFieldId", query = "SELECT o FROM OhrmDisplayField o WHERE o.displayFieldId = :displayFieldId"),
    @NamedQuery(name = "OhrmDisplayField.findByName", query = "SELECT o FROM OhrmDisplayField o WHERE o.name = :name"),
    @NamedQuery(name = "OhrmDisplayField.findByLabel", query = "SELECT o FROM OhrmDisplayField o WHERE o.label = :label"),
    @NamedQuery(name = "OhrmDisplayField.findByFieldAlias", query = "SELECT o FROM OhrmDisplayField o WHERE o.fieldAlias = :fieldAlias"),
    @NamedQuery(name = "OhrmDisplayField.findByIsSortable", query = "SELECT o FROM OhrmDisplayField o WHERE o.isSortable = :isSortable"),
    @NamedQuery(name = "OhrmDisplayField.findBySortOrder", query = "SELECT o FROM OhrmDisplayField o WHERE o.sortOrder = :sortOrder"),
    @NamedQuery(name = "OhrmDisplayField.findBySortField", query = "SELECT o FROM OhrmDisplayField o WHERE o.sortField = :sortField"),
    @NamedQuery(name = "OhrmDisplayField.findByElementType", query = "SELECT o FROM OhrmDisplayField o WHERE o.elementType = :elementType"),
    @NamedQuery(name = "OhrmDisplayField.findByElementProperty", query = "SELECT o FROM OhrmDisplayField o WHERE o.elementProperty = :elementProperty"),
    @NamedQuery(name = "OhrmDisplayField.findByWidth", query = "SELECT o FROM OhrmDisplayField o WHERE o.width = :width"),
    @NamedQuery(name = "OhrmDisplayField.findByIsExportable", query = "SELECT o FROM OhrmDisplayField o WHERE o.isExportable = :isExportable"),
    @NamedQuery(name = "OhrmDisplayField.findByTextAlignmentStyle", query = "SELECT o FROM OhrmDisplayField o WHERE o.textAlignmentStyle = :textAlignmentStyle"),
    @NamedQuery(name = "OhrmDisplayField.findByIsValueList", query = "SELECT o FROM OhrmDisplayField o WHERE o.isValueList = :isValueList"),
    @NamedQuery(name = "OhrmDisplayField.findByDefaultValue", query = "SELECT o FROM OhrmDisplayField o WHERE o.defaultValue = :defaultValue"),
    @NamedQuery(name = "OhrmDisplayField.findByIsEncrypted", query = "SELECT o FROM OhrmDisplayField o WHERE o.isEncrypted = :isEncrypted"),
    @NamedQuery(name = "OhrmDisplayField.findByIsMeta", query = "SELECT o FROM OhrmDisplayField o WHERE o.isMeta = :isMeta")})
public class OhrmDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "display_field_id")
    private Long displayFieldId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "label")
    private String label;
    @Column(name = "field_alias")
    private String fieldAlias;
    @Basic(optional = false)
    @Column(name = "is_sortable")
    private String isSortable;
    @Column(name = "sort_order")
    private String sortOrder;
    @Column(name = "sort_field")
    private String sortField;
    @Basic(optional = false)
    @Column(name = "element_type")
    private String elementType;
    @Basic(optional = false)
    @Column(name = "element_property")
    private String elementProperty;
    @Basic(optional = false)
    @Column(name = "width")
    private String width;
    @Column(name = "is_exportable")
    private String isExportable;
    @Column(name = "text_alignment_style")
    private String textAlignmentStyle;
    @Basic(optional = false)
    @Column(name = "is_value_list")
    private boolean isValueList;
    @Column(name = "default_value")
    private String defaultValue;
    @Basic(optional = false)
    @Column(name = "is_encrypted")
    private boolean isEncrypted;
    @Basic(optional = false)
    @Column(name = "is_meta")
    private boolean isMeta;
    @JoinColumn(name = "report_group_id", referencedColumnName = "report_group_id")
    @ManyToOne(optional = false)
    private OhrmReportGroup reportGroupId;
    @JoinColumn(name = "display_field_group_id", referencedColumnName = "id")
    @ManyToOne
    private OhrmDisplayFieldGroup displayFieldGroupId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ohrmDisplayField")
    private List<OhrmSelectedDisplayField> ohrmSelectedDisplayFieldList;

    public OhrmDisplayField() {
    }

    public OhrmDisplayField(Long displayFieldId) {
        this.displayFieldId = displayFieldId;
    }

    public OhrmDisplayField(Long displayFieldId, String name, String label, String isSortable, String elementType, String elementProperty, String width, boolean isValueList, boolean isEncrypted, boolean isMeta) {
        this.displayFieldId = displayFieldId;
        this.name = name;
        this.label = label;
        this.isSortable = isSortable;
        this.elementType = elementType;
        this.elementProperty = elementProperty;
        this.width = width;
        this.isValueList = isValueList;
        this.isEncrypted = isEncrypted;
        this.isMeta = isMeta;
    }

    public Long getDisplayFieldId() {
        return displayFieldId;
    }

    public void setDisplayFieldId(Long displayFieldId) {
        this.displayFieldId = displayFieldId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFieldAlias() {
        return fieldAlias;
    }

    public void setFieldAlias(String fieldAlias) {
        this.fieldAlias = fieldAlias;
    }

    public String getIsSortable() {
        return isSortable;
    }

    public void setIsSortable(String isSortable) {
        this.isSortable = isSortable;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getElementProperty() {
        return elementProperty;
    }

    public void setElementProperty(String elementProperty) {
        this.elementProperty = elementProperty;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getIsExportable() {
        return isExportable;
    }

    public void setIsExportable(String isExportable) {
        this.isExportable = isExportable;
    }

    public String getTextAlignmentStyle() {
        return textAlignmentStyle;
    }

    public void setTextAlignmentStyle(String textAlignmentStyle) {
        this.textAlignmentStyle = textAlignmentStyle;
    }

    public boolean getIsValueList() {
        return isValueList;
    }

    public void setIsValueList(boolean isValueList) {
        this.isValueList = isValueList;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    public boolean getIsMeta() {
        return isMeta;
    }

    public void setIsMeta(boolean isMeta) {
        this.isMeta = isMeta;
    }

    public OhrmReportGroup getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(OhrmReportGroup reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    public OhrmDisplayFieldGroup getDisplayFieldGroupId() {
        return displayFieldGroupId;
    }

    public void setDisplayFieldGroupId(OhrmDisplayFieldGroup displayFieldGroupId) {
        this.displayFieldGroupId = displayFieldGroupId;
    }

    @XmlTransient
    public List<OhrmSelectedDisplayField> getOhrmSelectedDisplayFieldList() {
        return ohrmSelectedDisplayFieldList;
    }

    public void setOhrmSelectedDisplayFieldList(List<OhrmSelectedDisplayField> ohrmSelectedDisplayFieldList) {
        this.ohrmSelectedDisplayFieldList = ohrmSelectedDisplayFieldList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (displayFieldId != null ? displayFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmDisplayField)) {
            return false;
        }
        OhrmDisplayField other = (OhrmDisplayField) object;
        if ((this.displayFieldId == null && other.displayFieldId != null) || (this.displayFieldId != null && !this.displayFieldId.equals(other.displayFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmDisplayField[ displayFieldId=" + displayFieldId + " ]";
    }
    
}
