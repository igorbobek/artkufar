package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.ProductGenreCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface ProductGenreCategoryDao extends CrudRepository<ProductGenreCategory, Long> {
    Set<ProductGenreCategory> findByProductId(Long userId);
    Set<ProductGenreCategory> findByGenreId(Long userId);
    Set<ProductGenreCategory> findByCategoryId(Long commentId);
    Set<ProductGenreCategory> findByCategoryIdAndGenreId(Long categoryId, Long genreId);
    Set<ProductGenreCategory> findAll();
}
