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
public class OhrmSelectedFilterFieldPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "report_id")
    private long reportId;
    @Basic(optional = false)
    @Column(name = "filter_field_id")
    private long filterFieldId;

    public OhrmSelectedFilterFieldPK() {
    }

    public OhrmSelectedFilterFieldPK(long reportId, long filterFieldId) {
        this.reportId = reportId;
        this.filterFieldId = filterFieldId;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public long getFilterFieldId() {
        return filterFieldId;
    }

    public void setFilterFieldId(long filterFieldId) {
        this.filterFieldId = filterFieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reportId;
        hash += (int) filterFieldId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmSelectedFilterFieldPK)) {
            return false;
        }
        OhrmSelectedFilterFieldPK other = (OhrmSelectedFilterFieldPK) object;
        if (this.reportId != other.reportId) {
            return false;
        }
        if (this.filterFieldId != other.filterFieldId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmSelectedFilterFieldPK[ reportId=" + reportId + ", filterFieldId=" + filterFieldId + " ]";
    }
    
}
