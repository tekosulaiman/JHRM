package org.module.sysadmin.model;

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
 * @author tekosulaiman@yahoo.com
 */
@Entity
@Table(name = "sec_rolegroup", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecRolegroup.findAll", query = "SELECT s FROM SecRolegroup s"),
    @NamedQuery(name = "SecRolegroup.findByRlgId", query = "SELECT s FROM SecRolegroup s WHERE s.rlgId = :rlgId"),
    @NamedQuery(name = "SecRolegroup.findByVersion", query = "SELECT s FROM SecRolegroup s WHERE s.version = :version")})
public class SecRolegroup implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rlg_id")
    private Long rlgId;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")
    @ManyToOne(optional = false)
    private SecGroup grpId;
    
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)
    private SecRole rolId;

    public SecRolegroup() {
    	
    }

    public SecRolegroup(Long rlgId) {
        this.rlgId = rlgId;
    }

    public SecRolegroup(Long rlgId, int version) {
        this.rlgId = rlgId;
        this.version = version;
    }

    public Long getRlgId() {
        return rlgId;
    }

    public void setRlgId(Long rlgId) {
        this.rlgId = rlgId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public SecGroup getGrpId() {
        return grpId;
    }

    public void setGrpId(SecGroup grpId) {
        this.grpId = grpId;
    }

    public SecRole getRolId() {
        return rolId;
    }

    public void setRolId(SecRole rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlgId != null ? rlgId.hashCode() : 0);
        return hash;
    }
}