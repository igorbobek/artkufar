package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Dao.ProductGenreCategoryDao;
import com.artkufar.artkufar.Model.ProductGenreCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGenreCategoryServiceImpl implements ProductGenreCategoryService{

    @Autowired
    ProductGenreCategoryDao productGenreCategoryDao;

    @Override
    public void save(ProductGenreCategory productGenreCategory) {
        productGenreCategoryDao.save(productGenreCategory);
    }
}
