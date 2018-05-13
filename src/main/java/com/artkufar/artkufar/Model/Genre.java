package com.artkufar.artkufar.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genre;

    @OneToMany(mappedBy = "genre",fetch = FetchType.EAGER )
    Set<ProductGenreCategory> ProductGenreCategoryS = new HashSet<>();

    public Genre(){}

    public Genre(String genre){
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<ProductGenreCategory> getProductGenreCategoryS() {
        return ProductGenreCategoryS;
    }

    public void setProductGenreCategoryS(Set<ProductGenreCategory> productGenreCategoryS) {
        ProductGenreCategoryS = productGenreCategoryS;
    }
}
