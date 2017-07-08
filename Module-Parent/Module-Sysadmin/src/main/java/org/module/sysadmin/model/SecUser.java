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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tekosulaiman@yahoo.com
 */
@Entity
@Table(name = "sec_user", schema = "schema_admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SecUser.findAll", query = "SELECT s FROM SecUser s"),
    @NamedQuery(name = "SecUser.findByUsrId", query = "SELECT s FROM SecUser s WHERE s.usrId = :usrId"),
    @NamedQuery(name = "SecUser.findByUsrAccountnonexpired", query = "SELECT s FROM SecUser s WHERE s.usrAccountnonexpired = :usrAccountnonexpired"),
    @NamedQuery(name = "SecUser.findByUsrAccountnonlocked", query = "SELECT s FROM SecUser s WHERE s.usrAccountnonlocked = :usrAccountnonlocked"),
    @NamedQuery(name = "SecUser.findByUsrCredentialsnonexpired", query = "SELECT s FROM SecUser s WHERE s.usrCredentialsnonexpired = :usrCredentialsnonexpired"),
    @NamedQuery(name = "SecUser.findByUsrEmail", query = "SELECT s FROM SecUser s WHERE s.usrEmail = :usrEmail"),
    @NamedQuery(name = "SecUser.findByUsrEnabled", query = "SELECT s FROM SecUser s WHERE s.usrEnabled = :usrEnabled"),
    @NamedQuery(name = "SecUser.findByUsrFirstname", query = "SELECT s FROM SecUser s WHERE s.usrFirstname = :usrFirstname"),
    @NamedQuery(name = "SecUser.findByUsrLastname", query = "SELECT s FROM SecUser s WHERE s.usrLastname = :usrLastname"),
    @NamedQuery(name = "SecUser.findByUsrLocale", query = "SELECT s FROM SecUser s WHERE s.usrLocale = :usrLocale"),
    @NamedQuery(name = "SecUser.findByUsrLoginname", query = "SELECT s FROM SecUser s WHERE s.usrLoginname = :usrLoginname"),
    @NamedQuery(name = "SecUser.findByUsrPassword", query = "SELECT s FROM SecUser s WHERE s.usrPassword = :usrPassword"),
    @NamedQuery(name = "SecUser.findByUsrToken", query = "SELECT s FROM SecUser s WHERE s.usrToken = :usrToken"),
    @NamedQuery(name = "SecUser.findByVersion", query = "SELECT s FROM SecUser s WHERE s.version = :version")})
public class SecUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id")
    private Long usrId;
    
    @Basic(optional = false)
    @Column(name = "usr_accountnonexpired")
    private boolean usrAccountnonexpired;
    
    @Basic(optional = false)
    @Column(name = "usr_accountnonlocked")
    private boolean usrAccountnonlocked;
    
    @Basic(optional = false)
    @Column(name = "usr_credentialsnonexpired")
    private boolean usrCredentialsnonexpired;
    
    @Column(name = "usr_email")
    private String usrEmail;
    
    @Basic(optional = false)
    @Column(name = "usr_enabled")
    private boolean usrEnabled;
    
    @Column(name = "usr_firstname")
    private String usrFirstname;
    
    @Column(name = "usr_lastname")
    private String usrLastname;
    
    @Column(name = "usr_locale")
    private String usrLocale;
    
    @Basic(optional = false)
    @Column(name = "usr_loginname")
    private String usrLoginname;
    
    @Basic(optional = false)
    @Column(name = "usr_password")
    private String usrPassword;
    
    @Column(name = "usr_token")
    private String usrToken;
    
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    private List<SecUserrole> secUserroleList;

    public SecUser() {
    	
    }

    public SecUser(Long usrId) {
        this.usrId = usrId;
    }

    public SecUser(Long usrId, boolean usrAccountnonexpired, boolean usrAccountnonlocked, boolean usrCredentialsnonexpired, boolean usrEnabled, String usrLoginname, String usrPassword, int version) {
        this.usrId = usrId;
        this.usrAccountnonexpired = usrAccountnonexpired;
        this.usrAccountnonlocked = usrAccountnonlocked;
        this.usrCredentialsnonexpired = usrCredentialsnonexpired;
        this.usrEnabled = usrEnabled;
        this.usrLoginname = usrLoginname;
        this.usrPassword = usrPassword;
        this.version = version;
    }

    public Long getUsrId() {
        return usrId;
    }

    public void setUsrId(Long usrId) {
        this.usrId = usrId;
    }

    public boolean getUsrAccountnonexpired() {
        return usrAccountnonexpired;
    }

    public void setUsrAccountnonexpired(boolean usrAccountnonexpired) {
        this.usrAccountnonexpired = usrAccountnonexpired;
    }

    public boolean getUsrAccountnonlocked() {
        return usrAccountnonlocked;
    }

    public void setUsrAccountnonlocked(boolean usrAccountnonlocked) {
        this.usrAccountnonlocked = usrAccountnonlocked;
    }

    public boolean getUsrCredentialsnonexpired() {
        return usrCredentialsnonexpired;
    }

    public void setUsrCredentialsnonexpired(boolean usrCredentialsnonexpired) {
        this.usrCredentialsnonexpired = usrCredentialsnonexpired;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public boolean getUsrEnabled() {
        return usrEnabled;
    }

    public void setUsrEnabled(boolean usrEnabled) {
        this.usrEnabled = usrEnabled;
    }

    public String getUsrFirstname() {
        return usrFirstname;
    }

    public void setUsrFirstname(String usrFirstname) {
        this.usrFirstname = usrFirstname;
    }

    public String getUsrLastname() {
        return usrLastname;
    }

    public void setUsrLastname(String usrLastname) {
        this.usrLastname = usrLastname;
    }

    public String getUsrLocale() {
        return usrLocale;
    }

    public void setUsrLocale(String usrLocale) {
        this.usrLocale = usrLocale;
    }

    public String getUsrLoginname() {
        return usrLoginname;
    }

    public void setUsrLoginname(String usrLoginname) {
        this.usrLoginname = usrLoginname;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public String getUsrToken() {
        return usrToken;
    }

    public void setUsrToken(String usrToken) {
        this.usrToken = usrToken;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<SecUserrole> getSecUserroleList() {
        return secUserroleList;
    }

    public void setSecUserroleList(List<SecUserrole> secUserroleList) {
        this.secUserroleList = secUserroleList;
    }
}