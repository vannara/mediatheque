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
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;
    
    @Column (name="isAvailable")
    private boolean isAvailable;

    @Column (name="itemNumber")
    private String itemNumber ;
    
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<ItemCopy> exemplaires;

    public Collection<ItemCopy> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Collection<ItemCopy> exemplaires) {
        this.exemplaires = exemplaires;
    }
    
    
@ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

        public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

        public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }
    
    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    
    public Item(){
        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the itemId fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Item[ id=" + itemId + " ]";
    }
    
}
