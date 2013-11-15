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
 * @author vannaraloch
 */
@Entity
public class Oeuvre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oeuvreId;
    
    private String author;
    private String title;
    
    @Column(name = "creationDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<DeliveryContains> deliveryContains;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<OrderContain> orderContains;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<Item> items;

    public Long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    public Collection<DeliveryContains> getDeliveryContains() {
        return deliveryContains;
    }

    public void setDeliveryContains(Collection<DeliveryContains> deliveryContains) {
        this.deliveryContains = deliveryContains;
    }

    public Collection<OrderContain> getOrderContains() {
        return orderContains;
    }

    public void setOrderContains(Collection<OrderContain> orderContains) {
        this.orderContains = orderContains;
    }

    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getNumberofSearch() {
        return numberofSearch;
    }

    public void setNumberofSearch(int numberofSearch) {
        this.numberofSearch = numberofSearch;
    }
    private String genre;
    private String keyword;
    private int numberofSearch;
    
    public Oeuvre(){
        
    }

    public Long getCatalogueId() {
        return oeuvreId;
    }

    public void setCatalogueId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oeuvreId != null ? oeuvreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the oeuvreId fields are not set
        if (!(object instanceof Oeuvre)) {
            return false;
        }
        Oeuvre other = (Oeuvre) object;
        if ((this.oeuvreId == null && other.oeuvreId != null) || (this.oeuvreId != null && !this.oeuvreId.equals(other.oeuvreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Catalogue[ id=" + oeuvreId + " ]";
    }
    
}
