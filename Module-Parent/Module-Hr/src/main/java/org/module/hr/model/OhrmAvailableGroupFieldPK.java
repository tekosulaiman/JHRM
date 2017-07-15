/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Tom
 */
@Embeddable
public class OhrmAvailableGroupFieldPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "report_group_id")
    private long reportGroupId;
    @Basic(optional = false)
    @Column(name = "group_field_id")
    private long groupFieldId;

    public OhrmAvailableGroupFieldPK() {
    }

    public OhrmAvailableGroupFieldPK(long reportGroupId, long groupFieldId) {
        this.reportGroupId = reportGroupId;
        this.groupFieldId = groupFieldId;
    }

    public long getReportGroupId() {
        return reportGroupId;
    }

    public void setReportGroupId(long reportGroupId) {
        this.reportGroupId = reportGroupId;
    }

    public long getGroupFieldId() {
        return groupFieldId;
    }

    public void setGroupFieldId(long groupFieldId) {
        this.groupFieldId = groupFieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reportGroupId;
        hash += (int) groupFieldId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmAvailableGroupFieldPK)) {
            return false;
        }
        OhrmAvailableGroupFieldPK other = (OhrmAvailableGroupFieldPK) object;
        if (this.reportGroupId != other.reportGroupId) {
            return false;
        }
        if (this.groupFieldId != other.groupFieldId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmAvailableGroupFieldPK[ reportGroupId=" + reportGroupId + ", groupFieldId=" + groupFieldId + " ]";
    }
    
}
