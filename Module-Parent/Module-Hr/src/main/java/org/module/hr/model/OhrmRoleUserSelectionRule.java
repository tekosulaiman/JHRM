/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "ohrm_role_user_selection_rule", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmRoleUserSelectionRule.findAll", query = "SELECT o FROM OhrmRoleUserSelectionRule o"),
    @NamedQuery(name = "OhrmRoleUserSelectionRule.findByUserRoleId", query = "SELECT o FROM OhrmRoleUserSelectionRule o WHERE o.ohrmRoleUserSelectionRulePK.userRoleId = :userRoleId"),
    @NamedQuery(name = "OhrmRoleUserSelectionRule.findBySelectionRuleId", query = "SELECT o FROM OhrmRoleUserSelectionRule o WHERE o.ohrmRoleUserSelectionRulePK.selectionRuleId = :selectionRuleId")})
public class OhrmRoleUserSelectionRule implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OhrmRoleUserSelectionRulePK ohrmRoleUserSelectionRulePK;
    @Lob
    @Column(name = "configurable_params")
    private String configurableParams;

    public OhrmRoleUserSelectionRule() {
    }

    public OhrmRoleUserSelectionRule(OhrmRoleUserSelectionRulePK ohrmRoleUserSelectionRulePK) {
        this.ohrmRoleUserSelectionRulePK = ohrmRoleUserSelectionRulePK;
    }

    public OhrmRoleUserSelectionRule(int userRoleId, int selectionRuleId) {
        this.ohrmRoleUserSelectionRulePK = new OhrmRoleUserSelectionRulePK(userRoleId, selectionRuleId);
    }

    public OhrmRoleUserSelectionRulePK getOhrmRoleUserSelectionRulePK() {
        return ohrmRoleUserSelectionRulePK;
    }

    public void setOhrmRoleUserSelectionRulePK(OhrmRoleUserSelectionRulePK ohrmRoleUserSelectionRulePK) {
        this.ohrmRoleUserSelectionRulePK = ohrmRoleUserSelectionRulePK;
    }

    public String getConfigurableParams() {
        return configurableParams;
    }

    public void setConfigurableParams(String configurableParams) {
        this.configurableParams = configurableParams;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ohrmRoleUserSelectionRulePK != null ? ohrmRoleUserSelectionRulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OhrmRoleUserSelectionRule)) {
            return false;
        }
        OhrmRoleUserSelectionRule other = (OhrmRoleUserSelectionRule) object;
        if ((this.ohrmRoleUserSelectionRulePK == null && other.ohrmRoleUserSelectionRulePK != null) || (this.ohrmRoleUserSelectionRulePK != null && !this.ohrmRoleUserSelectionRulePK.equals(other.ohrmRoleUserSelectionRulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmRoleUserSelectionRule[ ohrmRoleUserSelectionRulePK=" + ohrmRoleUserSelectionRulePK + " ]";
    }
    
}
