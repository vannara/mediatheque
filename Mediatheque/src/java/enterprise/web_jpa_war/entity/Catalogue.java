/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author vannaraloch
 */
@Entity
public class Catalogue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long catalogueId;
    
    private String author;
    private String title;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

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
    
    public Catalogue(){
        
    }

    public Long getCatalogueId() {
        return catalogueId;
    }

    public void setCatalogueId(Long catalogueId) {
        this.catalogueId = catalogueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogueId != null ? catalogueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the catalogueId fields are not set
        if (!(object instanceof Catalogue)) {
            return false;
        }
        Catalogue other = (Catalogue) object;
        if ((this.catalogueId == null && other.catalogueId != null) || (this.catalogueId != null && !this.catalogueId.equals(other.catalogueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Catalogue[ id=" + catalogueId + " ]";
    }
    
}
