/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author user
 */
@Entity
public class Delivery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer deliveryId;

    @Column(name = "deliveryDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deliveryDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "delivery")
    private Collection<DeliveryContains> deliveryContains;
    
    
    public Delivery(){
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Collection<DeliveryContains> getDeliveryContains() {
        return deliveryContains;
    }

    public void setDeliveryContains(Collection<DeliveryContains> deliveryContains) {
        this.deliveryContains = deliveryContains;
    }
    
    public Integer getDeliveryNumber() {
        return deliveryId;
    }

    public void setDeliveryNumber(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }  
}
