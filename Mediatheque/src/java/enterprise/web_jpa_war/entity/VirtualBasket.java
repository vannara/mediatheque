/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class VirtualBasket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketId;
    
    @OneToOne(mappedBy = "basket")
    private Adherent adherent;
    
    @Column(name = "dateLastAdded")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateLastAdded;
    
    @Column(name = "isReserved")
    private boolean isReserved;
    
    @OneToMany
    private Collection<ItemCopy> exemplaires;

    public VirtualBasket() {
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Date getDateLastAdded() {
        return dateLastAdded;
    }

    public void setDateLastAdded(Date dateLastAdded) {
        this.dateLastAdded = dateLastAdded;
    }

    public boolean isIsReserved() {
        return isReserved;
    }

    public void setIsReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }

    public Collection<ItemCopy> getExemplaires() {
        return exemplaires;
    }

    public void setExemplaires(Collection<ItemCopy> exemplaires) {
        this.exemplaires = exemplaires;
    }



    
}
