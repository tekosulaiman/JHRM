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
@Table(name = "sec_right", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecRight.findAll", query = "SELECT s FROM SecRight s"),
    @NamedQuery(name = "SecRight.findByRigId", query = "SELECT s FROM SecRight s WHERE s.rigId = :rigId"),
    @NamedQuery(name = "SecRight.findByRigName", query = "SELECT s FROM SecRight s WHERE s.rigName = :rigName"),
    @NamedQuery(name = "SecRight.findByRigType", query = "SELECT s FROM SecRight s WHERE s.rigType = :rigType"),
    @NamedQuery(name = "SecRight.findByVersion", query = "SELECT s FROM SecRight s WHERE s.version = :version"),
    @NamedQuery(name = "allRightFromUserSqlQuery", 
    	query="SELECT distinct r FROM SecRight r "
			+ "JOIN r.secGrouprightList AS gr "
			+ "JOIN gr.grpId.secRolegroupList AS rg "
			+ "JOIN rg.rolId.secUserroleList AS ur "
			+ "JOIN ur.usrId AS u "
			+ "WHERE u.usrId = ?")})
public class SecRight implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SecRight_rig_id_GENERATOR", sequenceName="SCHEMA_ADMIN.SecRight_rigId_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SecRight_rig_id_GENERATOR")
    @Column(name = "rig_id")
    private Long rigId;
    
    @Basic(optional = false)
    @Column(name = "rig_name")
    private String rigName;
    
    @Column(name = "rig_type")
    private Integer rigType;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rigId")
    private List<SecGroupright> secGrouprightList;

    public SecRight() {
    	
    }

    public SecRight(Long rigId) {
        this.rigId = rigId;
    }

    public SecRight(Long rigId, String rigName, int version) {
        this.rigId = rigId;
        this.rigName = rigName;
        this.version = version;
    }

    public Long getRigId() {
        return rigId;
    }

    public void setRigId(Long rigId) {
        this.rigId = rigId;
    }

    public String getRigName() {
        return rigName;
    }

    public void setRigName(String rigName) {
        this.rigName = rigName;
    }

    public Integer getRigType() {
        return rigType;
    }

    public void setRigType(Integer rigType) {
        this.rigType = rigType;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<SecGroupright> getSecGrouprightList() {
        return secGrouprightList;
    }

    public void setSecGrouprightList(List<SecGroupright> secGrouprightList) {
        this.secGrouprightList = secGrouprightList;
    }
}