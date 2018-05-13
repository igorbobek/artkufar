package com.artkufar.artkufar.Model;


import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private long price;

    private String description;


    public Product(){}

    public Product(String name, String image, long price, String description, Artist artist){
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.artist = artist;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_artist")
    private Artist artist;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER )
    private Set<Deal> deals = new HashSet<>();


    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER )
    private Set<ProductGenreCategory> ProductGenreCategoryS = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_material", joinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_material", referencedColumnName = "id"))
    private Set<Material> materials = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

    public Set<ProductGenreCategory> getProductGenreCategoryS() {
        return ProductGenreCategoryS;
    }

    public void setProductGenreCategoryS(Set<ProductGenreCategory> productGenreCategoryS) {
        ProductGenreCategoryS = productGenreCategoryS;
    }

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if(obj instanceof Product){
            Product user = (Product) obj;
            if (user.id.equals(this.id)) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
