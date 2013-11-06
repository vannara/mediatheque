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
import javax.persistence.ManyToOne;
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
    @Column(name = "deliveryNumber")
    private Long deliveryNumber;

    @Column(name = "deliveryDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deliveryDate;
    
    
    @OneToMany()
    private Collection<DeliveryContains> deliveryContains;
    
    
    public Delivery(){
    }
    
    public Long getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Long deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }  
}
