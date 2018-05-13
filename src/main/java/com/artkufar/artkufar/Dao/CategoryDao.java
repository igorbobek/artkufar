package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryDao extends CrudRepository<Category, Long>{
    Category findByCategory(String category);
}
