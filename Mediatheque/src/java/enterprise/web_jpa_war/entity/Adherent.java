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
    private Date dateAdhesion;
    
    @OneToMany(mappedBy = "adherent")
    private Collection<Borrow> borrows;
    
    @OneToOne
    private VirtualBasket basket;
    
//    @OneToMany(mappedBy = "adherent")
//    private Collection<Reservation> reservations;
       
    @Embedded
    private Address address;
    
    @OneToOne(mappedBy = "adherent")
    private Card card;

    public Adherent(String lastName, String firstName, Date dateofBirth, Date registeredDate, Address adherentAdress){
        this.lastname=lastName;
        this.firstname=firstName;
        this.dateofBirth=dateofBirth;
        this.dateAdhesion=registeredDate;
        this.address=adherentAdress;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    

    public VirtualBasket getBasket() {
        return basket;
    }

    public void setBasket(VirtualBasket basket) {
        this.basket = basket;
    }

    public Collection<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Collection<Borrow> borrows) {
        this.borrows = borrows;
    }

    public Date getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(Date dateAdherent) {
        this.dateAdhesion = dateAdherent;
    }
 
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
