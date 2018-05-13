package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long id);
    void delete(Long id);
}
