package com.artkufar.artkufar.Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String address;


    public Buyer(){}

    public Buyer(String address){
        this.address = address;
    }


    @OneToOne(mappedBy = "buyer", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private User user;

    @OneToMany(mappedBy = "buyer",fetch = FetchType.EAGER )
    private Set<Deal> deals = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }


}
