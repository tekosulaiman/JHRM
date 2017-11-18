package org.module.sysadmin.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Entity
@Table(name = "sec_role", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecRole.findAll", query = "SELECT s FROM SecRole s"),
    @NamedQuery(name = "SecRole.findByRolId", query = "SELECT s FROM SecRole s WHERE s.rolId = :rolId"),
    @NamedQuery(name = "SecRole.findByRolLongdescription", query = "SELECT s FROM SecRole s WHERE s.rolLongdescription = :rolLongdescription"),
    @NamedQuery(name = "SecRole.findByRolShortdescription", query = "SELECT s FROM SecRole s WHERE s.rolShortdescription = :rolShortdescription"),
    @NamedQuery(name = "SecRole.findByVersion", query = "SELECT s FROM SecRole s WHERE s.version = :version")})
public class SecRole implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SecRole_rol_id_GENERATOR", sequenceName="SCHEMA_ADMIN.SecRole_rolId_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SecRole_rol_id_GENERATOR")
    @Column(name = "rol_id")
    private Long rolId;
   
    @Column(name = "rol_longdescription")
    private String rolLongdescription;
    
    @Basic(optional = false)
    @Column(name = "rol_shortdescription")
    private String rolShortdescription;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<SecRolegroup> secRolegroupList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolId")
    private List<SecUserrole> secUserroleList;

    public SecRole() {
    	
    }

    public SecRole(Long rolId) {
        this.rolId = rolId;
    }

    public SecRole(Long rolId, String rolShortdescription, int version) {
        this.rolId = rolId;
        this.rolShortdescription = rolShortdescription;
        this.version = version;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRolLongdescription() {
        return rolLongdescription;
    }

    public void setRolLongdescription(String rolLongdescription) {
        this.rolLongdescription = rolLongdescription;
    }

    public String getRolShortdescription() {
        return rolShortdescription;
    }

    public void setRolShortdescription(String rolShortdescription) {
        this.rolShortdescription = rolShortdescription;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<SecRolegroup> getSecRolegroupList() {
        return secRolegroupList;
    }

    public void setSecRolegroupList(List<SecRolegroup> secRolegroupList) {
        this.secRolegroupList = secRolegroupList;
    }

    @XmlTransient
    public List<SecUserrole> getSecUserroleList() {
        return secUserroleList;
    }

    public void setSecUserroleList(List<SecUserrole> secUserroleList) {
        this.secUserroleList = secUserroleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolId != null ? rolId.hashCode() : 0);
        return hash;
    }
}