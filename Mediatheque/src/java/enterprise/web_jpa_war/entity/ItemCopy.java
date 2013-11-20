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
public class ItemCopy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemCopyId;

    private String itemCopyCode;
    
    @ManyToOne
    //@JoinColumn(name="basketId", referencedColumnName = "basketId")
    private VirtualBasket virtualBasket;
    
    @ManyToOne
    private Item item;
    
    @ManyToOne
    private Borrow borrow;   
    
    @ManyToMany
    @JoinTable(
      name="Return_Item",
      inverseJoinColumns={@JoinColumn(name="itemCopyId", referencedColumnName="itemCopyId")},
      joinColumns={@JoinColumn(name="returnId", referencedColumnName="returnId")})
    private Collection<Return> returns;

    public ItemCopy(String itemCopyCode, Item item) {
        this.itemCopyCode = itemCopyCode;
        this.item = item;
    }
    
    

    public ItemCopy(){
        
    }

    public Collection<Return> getReturns() {
        return returns;
    }

    public void setReturns(Collection<Return> returns) {
        this.returns = returns;
    }

    public String getItemCopyCode() {
        return itemCopyCode;
    }

    public void setItemCopyCode(String itemCopyCode) {
        this.itemCopyCode = itemCopyCode;
    }

    public VirtualBasket getVirtualBasket() {
        return virtualBasket;
    }

    public void setVirtualBasket(VirtualBasket virtualBasket) {
        this.virtualBasket = virtualBasket;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }
    
    public String getItemLineCode() {
        return itemCopyCode;
    }

    public void setItemLineCode(String itemLineCode) {
        this.itemCopyCode = itemLineCode;
    }
    
    public Long getItemCopyId() {
        return itemCopyId;
    }

    public void setItemCopyId(Long itemCopyId) {
        this.itemCopyId = itemCopyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCopyId != null ? itemCopyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the itemCopyId fields are not set
        if (!(object instanceof ItemCopy)) {
            return false;
        }
        ItemCopy other = (ItemCopy) object;
        if ((this.itemCopyId == null && other.itemCopyId != null) || (this.itemCopyId != null && !this.itemCopyId.equals(other.itemCopyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.ItemLine[ id=" + itemCopyId + " ]";
    }
    
}
