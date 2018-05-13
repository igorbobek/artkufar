package com.artkufar.artkufar.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;


    public Category(){}

    public Category(String category){
        this.category = category;
    }

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER )
    Set<ProductGenreCategory> ProductGenreCategoryS = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<ProductGenreCategory> getProductGenreCategoryS() {
        return ProductGenreCategoryS;
    }

    public void setProductGenreCategoryS(Set<ProductGenreCategory> productGenreCategoryS) {
        ProductGenreCategoryS = productGenreCategoryS;
    }

    @Override
    public int hashCode() {
        return category.hashCode();
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if(obj instanceof Category){
            Category category = (Category) obj;
            if (category.category.equals(this.category)) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
