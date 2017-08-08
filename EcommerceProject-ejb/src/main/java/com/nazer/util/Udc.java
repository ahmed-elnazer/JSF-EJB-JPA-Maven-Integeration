/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.util;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "udc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Udc.findAll", query = "SELECT u FROM Udc u"),
    @NamedQuery(name = "Udc.findByUdcId", query = "SELECT u FROM Udc u WHERE u.udcId = :udcId"),
    @NamedQuery(name = "Udc.findByTypeId", query = "SELECT u FROM Udc u WHERE u.typeId = :typeId"),
    @NamedQuery(name = "Udc.findByValue", query = "SELECT u FROM Udc u WHERE u.value = :value"),
    @NamedQuery(name = "Udc.findByDeleted", query = "SELECT u FROM Udc u WHERE u.deleted = :deleted")})
public class Udc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "udcId")
    private Long udcId;
    @Column(name = "typeId")
    private BigInteger typeId;
    @Size(max = 500)
    @Column(name = "value")
    private String value;
    @Column(name = "deleted")
    private Integer deleted;

    public Udc() {
    }

    public Udc(Long udcId) {
        this.udcId = udcId;
    }

    public Long getUdcId() {
        return udcId;
    }

    public void setUdcId(Long udcId) {
        this.udcId = udcId;
    }

    public BigInteger getTypeId() {
        return typeId;
    }

    public void setTypeId(BigInteger typeId) {
        this.typeId = typeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (udcId != null ? udcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Udc)) {
            return false;
        }
        Udc other = (Udc) object;
        if ((this.udcId == null && other.udcId != null) || (this.udcId != null && !this.udcId.equals(other.udcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nazer.entity.Udc[ udcId=" + udcId + " ]";
    }
    
}
