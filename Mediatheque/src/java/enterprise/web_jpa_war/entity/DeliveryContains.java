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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@IdClass(DeliveryContainsKey.class)
@Entity
class DeliveryContains implements Serializable {
    @ManyToOne
    @JoinColumn(name="deliveryNumber", referencedColumnName = "deliveryNumber")
    private Delivery delivery;
    

    @ManyToOne
    @JoinColumn(name="oeuvreId", referencedColumnName = "oeuvreId")
    private Oeuvre oeuvre;

    @Id
    private Long deliveryNumber;

    @Id
    private Long oeuvreId;
    
    @Column(name = "quantityExemplaires")
    private int quantityExemplaires;

    public DeliveryContains() {
    }

        public Long getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Long deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

        public Long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    public int getQuantityExemplaires() {
        return quantityExemplaires;
    }

    public void setQuantityExemplaires(int quantityExemplaires) {
        this.quantityExemplaires = quantityExemplaires;
    }
    
    
}
