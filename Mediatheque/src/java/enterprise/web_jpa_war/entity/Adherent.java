/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enterprise.web_jpa_war.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author vannaraloch
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"firstName", "lastName","dateofBirth"}))
public class Adherent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer adherentId;
    
    @Column(nullable = false)
    private String firstname;
    
    @Column(nullable = false)
    private String lastname;
   
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateofBirth;
  
    @Temporal(TemporalType.DATE)
    private Date dateAdherent;
    
    @OneToMany(mappedBy = "adherent")
    private Collection<Borrow> borrows;

    public Collection<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Collection<Borrow> borrows) {
        this.borrows = borrows;
    }

    public Date getDateAdherent() {
        return dateAdherent;
    }

    public void setDateAdherent(Date dateAdherent) {
        this.dateAdherent = dateAdherent;
    }
    
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Adherent(){
        
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.dateofBirth = DateofBirth;
    }
    
    public Integer getAdherentId() {
        return adherentId;
    }

    public void setAdherentId(Integer adherentId) {
        this.adherentId = adherentId;
    }
}
