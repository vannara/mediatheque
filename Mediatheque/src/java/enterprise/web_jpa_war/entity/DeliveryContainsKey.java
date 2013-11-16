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

    private long deliveryId;
    private long oeuvreId;

    public long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    public long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(long deliveryId) {
        this.deliveryId = deliveryId;
    }

  
    public int hashCode() {
        return (int) (deliveryId + oeuvreId);
    }

    public boolean equals(Object object) {
        if (object instanceof DeliveryContainsKey) {
            DeliveryContainsKey otherId = (DeliveryContainsKey) object;
            return (otherId.deliveryId == this.deliveryId) && (otherId.oeuvreId == this.oeuvreId);
        }
        return false;
    }
}
