package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Model.ProductGenreCategory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public interface ProductGenreCategoryService {
    void save(ProductGenreCategory productGenreCategory);

}
