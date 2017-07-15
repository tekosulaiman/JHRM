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
@Table(name = "ohrm_selected_display_field_group", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmSelectedDisplayFieldGroup.findAll", query = "SELECT o FROM OhrmSelectedDisplayFieldGroup o"),
    @NamedQuery(name = "OhrmSelectedDisplayFieldGroup.findById", query = "SELECT o FROM OhrmSelectedDisplayFieldGroup o WHERE o.id = :id")})
public class OhrmSelectedDisplayFieldGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    @ManyToOne(optional = false)
    private OhrmReport reportId;
    @JoinColumn(name = "display_field_group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OhrmDisplayFieldGroup displayFieldGroupId;

    public OhrmSelectedDisplayFieldGroup() {
    }

    public OhrmSelectedDisplayFieldGroup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OhrmReport getReportId() {
        return reportId;
    }

    public void setReportId(OhrmReport reportId) {
        this.reportId = reportId;
    }

    public OhrmDisplayFieldGroup getDisplayFieldGroupId() {
        return displayFieldGroupId;
    }

    public void setDisplayFieldGroupId(OhrmDisplayFieldGroup displayFieldGroupId) {
        this.displayFieldGroupId = displayFieldGroupId;
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
        if (!(object instanceof OhrmSelectedDisplayFieldGroup)) {
            return false;
        }
        OhrmSelectedDisplayFieldGroup other = (OhrmSelectedDisplayFieldGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedDisplayFieldGroup[ id=" + id + " ]";
    }
    
}
