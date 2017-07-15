/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.module.hr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tom
 */
@Entity
@Table(name = "ohrm_upgrade_history", schema = "schema_hr")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OhrmUpgradeHistory.findAll", query = "SELECT o FROM OhrmUpgradeHistory o"),
    @NamedQuery(name = "OhrmUpgradeHistory.findById", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.id = :id"),
    @NamedQuery(name = "OhrmUpgradeHistory.findByStartVersion", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.startVersion = :startVersion"),
    @NamedQuery(name = "OhrmUpgradeHistory.findByEndVersion", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.endVersion = :endVersion"),
    @NamedQuery(name = "OhrmUpgradeHistory.findByStartIncrement", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.startIncrement = :startIncrement"),
    @NamedQuery(name = "OhrmUpgradeHistory.findByEndIncrement", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.endIncrement = :endIncrement"),
    @NamedQuery(name = "OhrmUpgradeHistory.findByUpgradedDate", query = "SELECT o FROM OhrmUpgradeHistory o WHERE o.upgradedDate = :upgradedDate")})
public class OhrmUpgradeHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "start_version")
    private String startVersion;
    @Column(name = "end_version")
    private String endVersion;
    @Basic(optional = false)
    @Column(name = "start_increment")
    private int startIncrement;
    @Basic(optional = false)
    @Column(name = "end_increment")
    private int endIncrement;
    @Column(name = "upgraded_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date upgradedDate;

    public OhrmUpgradeHistory() {
    }

    public OhrmUpgradeHistory(Integer id) {
        this.id = id;
    }

    public OhrmUpgradeHistory(Integer id, int startIncrement, int endIncrement) {
        this.id = id;
        this.startIncrement = startIncrement;
        this.endIncrement = endIncrement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartVersion() {
        return startVersion;
    }

    public void setStartVersion(String startVersion) {
        this.startVersion = startVersion;
    }

    public String getEndVersion() {
        return endVersion;
    }

    public void setEndVersion(String endVersion) {
        this.endVersion = endVersion;
    }

    public int getStartIncrement() {
        return startIncrement;
    }

    public void setStartIncrement(int startIncrement) {
        this.startIncrement = startIncrement;
    }

    public int getEndIncrement() {
        return endIncrement;
    }

    public void setEndIncrement(int endIncrement) {
        this.endIncrement = endIncrement;
    }

    public Date getUpgradedDate() {
        return upgradedDate;
    }

    public void setUpgradedDate(Date upgradedDate) {
        this.upgradedDate = upgradedDate;
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
        if (!(object instanceof OhrmUpgradeHistory)) {
            return false;
        }
        OhrmUpgradeHistory other = (OhrmUpgradeHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.module.hr.model.OhrmUpgradeHistory[ id=" + id + " ]";
    }
    
}
