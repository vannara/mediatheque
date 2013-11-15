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

    @ManyToOne
    private Oeuvre oeuvre ;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<ItemCopy> exemplaires;

      
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    
    
    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public Collection<ItemCopy> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Collection<ItemCopy> exemplaires) {
        this.exemplaires = exemplaires;
    }
  
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

}
