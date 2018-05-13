package com.artkufar.artkufar.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String biography;

    public Artist(){}

    public Artist(String biography){
        this.biography = biography;
    }

    @OneToOne(mappedBy = "artist", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private User user;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
