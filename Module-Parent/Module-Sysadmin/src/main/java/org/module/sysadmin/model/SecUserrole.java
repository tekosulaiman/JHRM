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
@Table(name = "sec_userrole", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecUserrole.findAll", query = "SELECT s FROM SecUserrole s"),
    @NamedQuery(name = "SecUserrole.findByUrrId", query = "SELECT s FROM SecUserrole s WHERE s.urrId = :urrId"),
    @NamedQuery(name = "SecUserrole.findByVersion", query = "SELECT s FROM SecUserrole s WHERE s.version = :version")})
public class SecUserrole implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
    @Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "urr_id")
    private Long urrId;
	
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne(optional = false)   
    private SecRole rolId;
    
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private SecUser usrId;

    public SecUserrole() {
    	
    }

    public SecUserrole(Long urrId) {
        this.urrId = urrId;
    }

    public SecUserrole(Long urrId, int version) {
        this.urrId = urrId;
        this.version = version;
    }

    public Long getUrrId() {
        return urrId;
    }

    public void setUrrId(Long urrId) {
        this.urrId = urrId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public SecRole getRolId() {
        return rolId;
    }

    public void setRolId(SecRole rolId) {
        this.rolId = rolId;
    }

    public SecUser getUsrId() {
        return usrId;
    }

    public void setUsrId(SecUser usrId) {
        this.usrId = usrId;
    }
}