package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Artist;
import com.artkufar.artkufar.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface ProductDao extends JpaRepository<Product, Long> {
    Set<Product> findAllByAndAndArtistIsNotNull();
    Set<Product> findByArtistAndDealsIsNotNull(Artist artist);
    void deleteById(Long id);
}
