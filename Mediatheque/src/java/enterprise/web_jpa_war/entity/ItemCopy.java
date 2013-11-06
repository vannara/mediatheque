/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
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
    private Long sampleId;

    @Column (name="itemLineCode")
    private String itemLineCode;

    public ItemCopy(){
        
    }
    
    public String getItemLineCode() {
        return itemLineCode;
    }

    public void setItemLineCode(String itemLineCode) {
        this.itemLineCode = itemLineCode;
    }
    
    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sampleId != null ? sampleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the sampleId fields are not set
        if (!(object instanceof ItemCopy)) {
            return false;
        }
        ItemCopy other = (ItemCopy) object;
        if ((this.sampleId == null && other.sampleId != null) || (this.sampleId != null && !this.sampleId.equals(other.sampleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.ItemLine[ id=" + sampleId + " ]";
    }
    
}
