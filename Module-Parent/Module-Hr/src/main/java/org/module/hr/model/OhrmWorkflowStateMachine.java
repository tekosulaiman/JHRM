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
@Table(name = "ohrm_workflow_state_machine", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmWorkflowStateMachine.findAll", query = "SELECT o FROM OhrmWorkflowStateMachine o"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findById", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByWorkflow", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.workflow = :workflow"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByState", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.state = :state"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByRole", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.role = :role"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByAction", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.action = :action"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByResultingState", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.resultingState = :resultingState"),
    @NamedQuery(name = "OhrmWorkflowStateMachine.findByPriority", query = "SELECT o FROM OhrmWorkflowStateMachine o WHERE o.priority = :priority")})
public class OhrmWorkflowStateMachine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "workflow")
    private String workflow;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @Column(name = "resulting_state")
    private String resultingState;
    @Lob
    @Column(name = "roles_to_notify")
    private String rolesToNotify;
    @Basic(optional = false)
    @Column(name = "priority")
    private int priority;

    public OhrmWorkflowStateMachine() {
    }

    public OhrmWorkflowStateMachine(Long id) {
        this.id = id;
    }

    public OhrmWorkflowStateMachine(Long id, String workflow, String state, String role, String action, String resultingState, int priority) {
        this.id = id;
        this.workflow = workflow;
        this.state = state;
        this.role = role;
        this.action = action;
        this.resultingState = resultingState;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResultingState() {
        return resultingState;
    }

    public void setResultingState(String resultingState) {
        this.resultingState = resultingState;
    }

    public String getRolesToNotify() {
        return rolesToNotify;
    }

    public void setRolesToNotify(String rolesToNotify) {
        this.rolesToNotify = rolesToNotify;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
        if (!(object instanceof OhrmWorkflowStateMachine)) {
            return false;
        }
        OhrmWorkflowStateMachine other = (OhrmWorkflowStateMachine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmWorkflowStateMachine[ id=" + id + " ]";
    }
    
}
