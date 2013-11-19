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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author vannaraloch
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"title", "author","genre", "releaseDate"}))
public class Oeuvre implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oeuvreId;
    
    @Column(name="author")
    private String author;
    
    @Column(name="title")
    private String title;
    
    @Column(name="genre")
    private String genre;
    
    @Column(name="keyword")
    private String keyword;
    
    @Column(name="numberofSearch")
    private int numberofSearch;
    
    @Column(name = "releaseDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date releaseDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<DeliveryContains> deliveryContains;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<OrderContain> orderContains;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private Collection<Item> items;

    public Oeuvre(){
        
    }
    public Oeuvre(String title,String author,String genre, String keyWords,Date releaseDate){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.keyword=keyWords;
        this.releaseDate=releaseDate;
        this.items=null;
        this.deliveryContains=null;
        this.orderContains=null;
    }
    public Long getOeuvreId() {
        return oeuvreId;
    }

    public void setOeuvreId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
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

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
    
    
}
