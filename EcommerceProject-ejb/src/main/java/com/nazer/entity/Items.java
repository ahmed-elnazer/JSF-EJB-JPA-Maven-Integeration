/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nazer.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Items.findByItemName", query = "SELECT i FROM Items i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Items.findByDescription", query = "SELECT i FROM Items i WHERE i.description = :description"),
    @NamedQuery(name = "Items.findByTitle", query = "SELECT i FROM Items i WHERE i.title = :title"),
    @NamedQuery(name = "Items.findByCost", query = "SELECT i FROM Items i WHERE i.cost = :cost"),
    @NamedQuery(name = "Items.findByRank", query = "SELECT i FROM Items i WHERE i.rank = :rank"),
    @NamedQuery(name = "Items.findByImage", query = "SELECT i FROM Items i WHERE i.image = :image"),
    @NamedQuery(name = "Items.findByDeleted", query = "SELECT i FROM Items i WHERE i.deleted = :deleted"),    @NamedQuery(name = "Items.findByTotalCount", query = "SELECT i FROM Items i WHERE i.totalCount = :totalCount"),
    @NamedQuery(name = "Items.findByCurrentCount", query = "SELECT i FROM Items i WHERE i.currentCount = :currentCount"),
    @NamedQuery(name = "Items.findByPriceCurrency", query = "SELECT i FROM Items i WHERE i.priceCurrency = :priceCurrency")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "itemId")
    private Long itemId;
    @Size(max = 500)
    @Column(name = "itemName")
    private String itemName;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 500)
    @Column(name = "title")
    private String title;
    @Size(max = 500)
    @Column(name = "cost")
    private String cost;
    @Column(name = "rank")
    private Integer rank;
    @Size(max = 500)
    @Column(name = "image")
    private String image;
    @Column(name = "deleted")
    private Integer deleted;
  
    @Column(name = "totalCount")
    private BigInteger totalCount;
    @Column(name = "currentCount")
    private BigInteger currentCount;
    @Size(max = 100)
    @Column(name = "priceCurrency")
    private String priceCurrency;
    @JoinTable(name = "shoppingcartItems", joinColumns = {
        @JoinColumn(name = "itemId", referencedColumnName = "itemId")}, inverseJoinColumns = {
        @JoinColumn(name = "shoppingcartId", referencedColumnName = "shoppingCartId")})
    @ManyToMany
    private Collection<ShoppingCart> shoppingCartCollection;
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    @ManyToOne
    private Categories categoryId;
    @OneToMany(mappedBy = "itemId")
    private Collection<ShoppingHistory> shoppingHistoryCollection;

    public Items() {
    }

    public Items(Long itemId) {
        this.itemId = itemId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public BigInteger getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigInteger totalCount) {
        this.totalCount = totalCount;
    }

    public BigInteger getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(BigInteger currentCount) {
        this.currentCount = currentCount;
    }

    public String getPriceCurrency() {
        return priceCurrency;
    }

    public void setPriceCurrency(String priceCurrency) {
        this.priceCurrency = priceCurrency;
    }

    @XmlTransient
    public Collection<ShoppingCart> getShoppingCartCollection() {
        return shoppingCartCollection;
    }

    public void setShoppingCartCollection(Collection<ShoppingCart> shoppingCartCollection) {
        this.shoppingCartCollection = shoppingCartCollection;
    }

    public Categories getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<ShoppingHistory> getShoppingHistoryCollection() {
        return shoppingHistoryCollection;
    }

    public void setShoppingHistoryCollection(Collection<ShoppingHistory> shoppingHistoryCollection) {
        this.shoppingHistoryCollection = shoppingHistoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nazer.entity.Items[ itemId=" + itemId + " ]";
    }
    
}
