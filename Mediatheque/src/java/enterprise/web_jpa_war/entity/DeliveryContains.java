/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
@IdClass(DeliveryContainsKey.class)
class DeliveryContains implements Serializable {
    @Id
    private long deliveryId;
    @Id
    private long oeuvreId;
    
    @ManyToOne
    private Delivery delivery;
    
    @ManyToOne
    private Oeuvre oeuvre;
 
    @Column(name = "quantityItemCopies")
    private int quantityItemCopies;

    
    public DeliveryContains() {
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public int getQuantityItemCopies() {
        return quantityItemCopies;
    }

    public void setQuantityItemCopies(int quantityItemCopies) {
        this.quantityItemCopies = quantityItemCopies;
    }

    public long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    
    
}
