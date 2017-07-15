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
@Table(name = "hs_hr_custom_export", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrCustomExport.findAll", query = "SELECT h FROM HsHrCustomExport h"),
    @NamedQuery(name = "HsHrCustomExport.findByExportId", query = "SELECT h FROM HsHrCustomExport h WHERE h.exportId = :exportId"),
    @NamedQuery(name = "HsHrCustomExport.findByName", query = "SELECT h FROM HsHrCustomExport h WHERE h.name = :name")})
public class HsHrCustomExport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "export_id")
    private Integer exportId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "fields")
    private String fields;
    @Lob
    @Column(name = "headings")
    private String headings;

    public HsHrCustomExport() {
    }

    public HsHrCustomExport(Integer exportId) {
        this.exportId = exportId;
    }

    public HsHrCustomExport(Integer exportId, String name) {
        this.exportId = exportId;
        this.name = name;
    }

    public Integer getExportId() {
        return exportId;
    }

    public void setExportId(Integer exportId) {
        this.exportId = exportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getHeadings() {
        return headings;
    }

    public void setHeadings(String headings) {
        this.headings = headings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exportId != null ? exportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrCustomExport)) {
            return false;
        }
        HsHrCustomExport other = (HsHrCustomExport) object;
        if ((this.exportId == null && other.exportId != null) || (this.exportId != null && !this.exportId.equals(other.exportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrCustomExport[ exportId=" + exportId + " ]";
    }
    
}
