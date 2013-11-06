/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author vannaraloch
 */
@Entity
public class Borrow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long borrowId;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date borrowDate;
    
    @ManyToMany
    @JoinTable(
      name="Bororw_Item",
      joinColumns={@JoinColumn(name="itemId", referencedColumnName="itemId")},
      inverseJoinColumns={@JoinColumn(name="borrowId", referencedColumnName="borrowId")})
    private Collection<Item> items;

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public Borrow(){
        
    }
    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (borrowId != null ? borrowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the borrowId fields are not set
        if (!(object instanceof Borrow)) {
            return false;
        }
        Borrow other = (Borrow) object;
        if ((this.borrowId == null && other.borrowId != null) || (this.borrowId != null && !this.borrowId.equals(other.borrowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enterprise.web_jpa_war.entity.Borrow[ id=" + borrowId + " ]";
    }
    
}
