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
public class OhrmRoleUserSelectionRulePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "user_role_id")
    private int userRoleId;
    @Basic(optional = false)
    @Column(name = "selection_rule_id")
    private int selectionRuleId;

    public OhrmRoleUserSelectionRulePK() {
    }

    public OhrmRoleUserSelectionRulePK(int userRoleId, int selectionRuleId) {
        this.userRoleId = userRoleId;
        this.selectionRuleId = selectionRuleId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getSelectionRuleId() {
        return selectionRuleId;
    }

    public void setSelectionRuleId(int selectionRuleId) {
        this.selectionRuleId = selectionRuleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userRoleId;
        hash += (int) selectionRuleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmRoleUserSelectionRulePK)) {
            return false;
        }
        OhrmRoleUserSelectionRulePK other = (OhrmRoleUserSelectionRulePK) object;
        if (this.userRoleId != other.userRoleId) {
            return false;
        }
        if (this.selectionRuleId != other.selectionRuleId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmRoleUserSelectionRulePK[ userRoleId=" + userRoleId + ", selectionRuleId=" + selectionRuleId + " ]";
    }
    
}
