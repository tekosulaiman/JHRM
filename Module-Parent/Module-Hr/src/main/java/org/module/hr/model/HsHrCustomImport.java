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
@Table(name = "hs_hr_custom_import", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HsHrCustomImport.findAll", query = "SELECT h FROM HsHrCustomImport h"),
    @NamedQuery(name = "HsHrCustomImport.findByImportId", query = "SELECT h FROM HsHrCustomImport h WHERE h.importId = :importId"),
    @NamedQuery(name = "HsHrCustomImport.findByName", query = "SELECT h FROM HsHrCustomImport h WHERE h.name = :name"),
    @NamedQuery(name = "HsHrCustomImport.findByHasHeading", query = "SELECT h FROM HsHrCustomImport h WHERE h.hasHeading = :hasHeading")})
public class HsHrCustomImport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "import_id")
    private Integer importId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "fields")
    private String fields;
    @Column(name = "has_heading")
    private Boolean hasHeading;

    public HsHrCustomImport() {
    }

    public HsHrCustomImport(Integer importId) {
        this.importId = importId;
    }

    public HsHrCustomImport(Integer importId, String name) {
        this.importId = importId;
        this.name = name;
    }

    public Integer getImportId() {
        return importId;
    }

    public void setImportId(Integer importId) {
        this.importId = importId;
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

    public Boolean getHasHeading() {
        return hasHeading;
    }

    public void setHasHeading(Boolean hasHeading) {
        this.hasHeading = hasHeading;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (importId != null ? importId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HsHrCustomImport)) {
            return false;
        }
        HsHrCustomImport other = (HsHrCustomImport) object;
        if ((this.importId == null && other.importId != null) || (this.importId != null && !this.importId.equals(other.importId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.HsHrCustomImport[ importId=" + importId + " ]";
    }
    
}
