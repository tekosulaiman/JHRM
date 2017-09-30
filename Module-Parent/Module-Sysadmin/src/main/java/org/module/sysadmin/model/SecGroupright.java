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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Entity
@Table(name = "sec_groupright", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecGroupright.findAll", query = "SELECT s FROM SecGroupright s"),
    @NamedQuery(name = "SecGroupright.findByGriId", query = "SELECT s FROM SecGroupright s WHERE s.griId = :griId"),
    @NamedQuery(name = "SecGroupright.findByVersion", query = "SELECT s FROM SecGroupright s WHERE s.version = :version")})
public class SecGroupright implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SecGroupright_gri_id_GENERATOR", sequenceName="SCHEMA_ADMIN.SecGroupright_griId_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SecGroupright_gri_id_GENERATOR")
    @Column(name = "gri_id")
    private Long griId;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @JoinColumn(name = "grp_id", referencedColumnName = "grp_id")
    @ManyToOne(optional = false)
    private SecGroup grpId;
    
    @JoinColumn(name = "rig_id", referencedColumnName = "rig_id")
    @ManyToOne(optional = false)
    private SecRight rigId;

    public SecGroupright() {
    	
    }

    public SecGroupright(Long griId) {
        this.griId = griId;
    }

    public SecGroupright(Long griId, int version) {
        this.griId = griId;
        this.version = version;
    }

    public Long getGriId() {
        return griId;
    }

    public void setGriId(Long griId) {
        this.griId = griId;
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

    public SecRight getRigId() {
        return rigId;
    }

    public void setRigId(SecRight rigId) {
        this.rigId = rigId;
    }
}