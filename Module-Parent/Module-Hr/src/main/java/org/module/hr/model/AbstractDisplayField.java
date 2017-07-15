/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "abstract_display_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AbstractDisplayField.findAll", query = "SELECT a FROM AbstractDisplayField a"),
    @NamedQuery(name = "AbstractDisplayField.findById", query = "SELECT a FROM AbstractDisplayField a WHERE a.id = :id"),
    @NamedQuery(name = "AbstractDisplayField.findByReportGroupId", query = "SELECT a FROM AbstractDisplayField a WHERE a.reportGroupId = :reportGroupId"),
    @NamedQuery(name = "AbstractDisplayField.findByName", query = "SELECT a FROM AbstractDisplayField a WHERE a.name = :name"),
    @NamedQuery(name = "AbstractDisplayField.findByLabel", query = "SELECT a FROM AbstractDisplayField a WHERE a.label = :label"),
    @NamedQuery(name = "AbstractDisplayField.findByFieldAlias", query = "SELECT a FROM AbstractDisplayField a WHERE a.fieldAlias = :fieldAlias"),
    @NamedQuery(name = "AbstractDisplayField.findByIsSortable", query = "SELECT a FROM AbstractDisplayField a WHERE a.isSortable = :isSortable"),
    @NamedQuery(name = "AbstractDisplayField.findBySortOrder", query = "SELECT a FROM AbstractDisplayField a WHERE a.sortOrder = :sortOrder"),
    @NamedQuery(name = "AbstractDisplayField.findBySortField", query = "SELECT a FROM AbstractDisplayField a WHERE a.sortField = :sortField"),
    @NamedQuery(name = "AbstractDisplayField.findByElementType", query = "SELECT a FROM AbstractDisplayField a WHERE a.elementType = :elementType"),
    @NamedQuery(name = "AbstractDisplayField.findByWidth", query = "SELECT a FROM AbstractDisplayField a WHERE a.width = :width"),
    @NamedQuery(name = "AbstractDisplayField.findByIsExportable", query = "SELECT a FROM AbstractDisplayField a WHERE a.isExportable = :isExportable"),
    @NamedQuery(name = "AbstractDisplayField.findByTextAlignmentStyle", query = "SELECT a FROM AbstractDisplayField a WHERE a.textAlignmentStyle = :textAlignmentStyle"),
    @NamedQuery(name = "AbstractDisplayField.findByIsValueList", query = "SELECT a FROM AbstractDisplayField a WHERE a.isValueList = :isValueList"),
    @NamedQuery(name = "AbstractDisplayField.findByDisplayFieldGroupId", query = "SELECT a FROM AbstractDisplayField a WHERE a.displayFieldGroupId = :displayFieldGroupId"),
    @NamedQuery(name = "AbstractDisplayField.findByDefaultValue", query = "SELECT a FROM AbstractDisplayField a WHERE a.defaultValue = :defaultValue"),
    @NamedQuery(name = "AbstractDisplayField.findByIsEncrypted", query = "SELECT a FROM AbstractDisplayField a WHERE a.isEncrypted = :isEncrypted"),
    @NamedQuery(name = "AbstractDisplayField.findByIsMeta", query = "SELECT a FROM AbstractDisplayField a WHERE a.isMeta = :isMeta")})
public class AbstractDisplayField implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "report_group_id")
    private long reportGroupId;
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
    @Lob
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
    @Column(name = "display_field_group_id")
    private BigInteger displayFieldGroupId;
    @Column(name = "default_value")
    private String defaultValue;
    @Basic(optional = false)
    @Column(name = "is_encrypted")
    private boolean isEncrypted;
    @Basic(optional = false)
    @Column(name = "is_meta")
    private boolean isMeta;

    public AbstractDisplayField() {
    }

    public AbstractDisplayField(Long id) {
        this.id = id;
    }

    public AbstractDisplayField(Long id, long reportGroupId, String name, String label, String isSortable, String elementType, String elementProperty, String width, boolean isValueList, boolean isEncrypted, boolean isMeta) {
        this.id = id;
        this.reportGroupId = reportGroupId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(long reportGroupId) {
        this.reportGroupId = reportGroupId;
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

    public BigInteger getDisplayFieldGroupId() {
        return displayFieldGroupId;
    }

    public void setDisplayFieldGroupId(BigInteger displayFieldGroupId) {
        this.displayFieldGroupId = displayFieldGroupId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AbstractDisplayField)) {
            return false;
        }
        AbstractDisplayField other = (AbstractDisplayField) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.AbstractDisplayField[ id=" + id + " ]";
    }
    
}
