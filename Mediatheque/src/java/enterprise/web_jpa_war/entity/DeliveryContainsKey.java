/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class DeliveryContainsKey implements Serializable {
    private Long deliveryNumber;
    private Long oeuvreId;

    public DeliveryContainsKey() {
    }

    public Long getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Long deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public Long getCatalogueId() {
        return oeuvreId;
    }

    public void setCatalogueId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
