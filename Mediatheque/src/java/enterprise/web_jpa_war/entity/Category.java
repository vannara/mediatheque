/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author vannaraloch
 */
@Entity
@Table(name = "Category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "maxBorrowQty")
    private double maxBorrowQty;

    @Column(name = "maxBorrowDuration")
    private double maxBorrowDuration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<Item> items;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public double getMaxBorrowDuration() {
        return maxBorrowDuration;
    }

    public void setMaxBorrowDuration(double maxBorrowDuration) {
        this.maxBorrowDuration = maxBorrowDuration;
    }

    public double getMaxBorrowQty() {
        return maxBorrowQty;
    }

    public void setMaxBorrowQty(double maxBorrowQty) {
        this.maxBorrowQty = maxBorrowQty;
    }

    public Category() {
    }

    public Category(String cateName, double maxBorDur, double maxBorQty){
        this.categoryName=cateName;
        this.maxBorrowDuration= maxBorDur;
        this.maxBorrowQty= maxBorQty;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setId(Integer id) {
        this.categoryId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryId == null && other.categoryId != null)
                || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Category[ id=" + categoryId + " ]";
    }

}
