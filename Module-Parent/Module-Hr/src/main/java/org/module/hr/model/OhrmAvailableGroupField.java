/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "ohrm_available_group_field", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmAvailableGroupField.findAll", query = "SELECT o FROM OhrmAvailableGroupField o"),
    @NamedQuery(name = "OhrmAvailableGroupField.findByReportGroupId", query = "SELECT o FROM OhrmAvailableGroupField o WHERE o.ohrmAvailableGroupFieldPK.reportGroupId = :reportGroupId"),
    @NamedQuery(name = "OhrmAvailableGroupField.findByGroupFieldId", query = "SELECT o FROM OhrmAvailableGroupField o WHERE o.ohrmAvailableGroupFieldPK.groupFieldId = :groupFieldId")})
public class OhrmAvailableGroupField implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmAvailableGroupFieldPK ohrmAvailableGroupFieldPK;
    @JoinColumn(name = "group_field_id", referencedColumnName = "group_field_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OhrmGroupField ohrmGroupField;

    public OhrmAvailableGroupField() {
    }

    public OhrmAvailableGroupField(OhrmAvailableGroupFieldPK ohrmAvailableGroupFieldPK) {
        this.ohrmAvailableGroupFieldPK = ohrmAvailableGroupFieldPK;
    }

    public OhrmAvailableGroupField(long reportGroupId, long groupFieldId) {
        this.ohrmAvailableGroupFieldPK = new OhrmAvailableGroupFieldPK(reportGroupId, groupFieldId);
    }

    public OhrmAvailableGroupFieldPK getOhrmAvailableGroupFieldPK() {
        return ohrmAvailableGroupFieldPK;
    }

    public void setOhrmAvailableGroupFieldPK(OhrmAvailableGroupFieldPK ohrmAvailableGroupFieldPK) {
        this.ohrmAvailableGroupFieldPK = ohrmAvailableGroupFieldPK;
    }

    public OhrmGroupField getOhrmGroupField() {
        return ohrmGroupField;
    }

    public void setOhrmGroupField(OhrmGroupField ohrmGroupField) {
        this.ohrmGroupField = ohrmGroupField;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmAvailableGroupFieldPK != null ? ohrmAvailableGroupFieldPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmAvailableGroupField)) {
            return false;
        }
        OhrmAvailableGroupField other = (OhrmAvailableGroupField) object;
        if ((this.ohrmAvailableGroupFieldPK == null && other.ohrmAvailableGroupFieldPK != null) || (this.ohrmAvailableGroupFieldPK != null && !this.ohrmAvailableGroupFieldPK.equals(other.ohrmAvailableGroupFieldPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmAvailableGroupField[ ohrmAvailableGroupFieldPK=" + ohrmAvailableGroupFieldPK + " ]";
    }
    
}
