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
    private Adherent adherent;

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
    
    @ManyToMany
    @JoinTable(
      name="Bororw_Item",
      joinColumns={@JoinColumn(name="itemCopyId", referencedColumnName="itemCopyId")},
      inverseJoinColumns={@JoinColumn(name="borrowId", referencedColumnName="borrowId")})
    private Collection<ItemCopy> itemCopies;

    public Collection<ItemCopy> getItemCopies() {
        return itemCopies;
    }

    public void setItemCopies(Collection<ItemCopy> itemCopies) {
        this.itemCopies = itemCopies;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
    
    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }
    
    public Borrow(){
        
    }
}
