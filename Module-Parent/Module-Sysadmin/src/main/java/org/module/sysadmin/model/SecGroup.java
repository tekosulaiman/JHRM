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
@Table(name = "sec_group", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecGroup.findAll", query = "SELECT s FROM SecGroup s"),
    @NamedQuery(name = "SecGroup.findByGrpId", query = "SELECT s FROM SecGroup s WHERE s.grpId = :grpId"),
    @NamedQuery(name = "SecGroup.findByGrpLongdescription", query = "SELECT s FROM SecGroup s WHERE s.grpLongdescription = :grpLongdescription"),
    @NamedQuery(name = "SecGroup.findByGrpShortdescription", query = "SELECT s FROM SecGroup s WHERE s.grpShortdescription = :grpShortdescription"),
    @NamedQuery(name = "SecGroup.findByVersion", query = "SELECT s FROM SecGroup s WHERE s.version = :version")})
public class SecGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name="SecGroup_grp_id_GENERATOR", sequenceName="SCHEMA_ADMIN.SecGroup_grpId_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SecGroup_grp_id_GENERATOR")
    @Column(name = "grp_id")
    private Long grpId;
    
    @Column(name = "grp_longdescription")
    private String grpLongdescription;
    
    @Basic(optional = false)
    @Column(name = "grp_shortdescription")
    private String grpShortdescription;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private List<SecRolegroup> secRolegroupList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grpId")
    private List<SecGroupright> secGrouprightList;

    public SecGroup() {
    	
    }

    public SecGroup(Long grpId) {
        this.grpId = grpId;
    }

    public SecGroup(Long grpId, String grpShortdescription, int version) {
        this.grpId = grpId;
        this.grpShortdescription = grpShortdescription;
        this.version = version;
    }

    public Long getGrpId() {
        return grpId;
    }

    public void setGrpId(Long grpId) {
        this.grpId = grpId;
    }

    public String getGrpLongdescription() {
        return grpLongdescription;
    }

    public void setGrpLongdescription(String grpLongdescription) {
        this.grpLongdescription = grpLongdescription;
    }

    public String getGrpShortdescription() {
        return grpShortdescription;
    }

    public void setGrpShortdescription(String grpShortdescription) {
        this.grpShortdescription = grpShortdescription;
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
    public List<SecGroupright> getSecGrouprightList() {
        return secGrouprightList;
    }

    public void setSecGrouprightList(List<SecGroupright> secGrouprightList) {
        this.secGrouprightList = secGrouprightList;
    }
}