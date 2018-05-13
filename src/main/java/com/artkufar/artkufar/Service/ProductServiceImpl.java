package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Dao.ProductDao;
import com.artkufar.artkufar.Dao.UserDao;
import com.artkufar.artkufar.Model.Artist;
import com.artkufar.artkufar.Model.Product;
import com.artkufar.artkufar.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Autowired
    UserDao userDao;

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productDao.findAllByAndAndArtistIsNotNull().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Long id) {
        if(productDao.findById(id).isPresent())
        {
            return  productDao.findById(id).get();
        }
        return null;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Product product = productDao.findById(id).get();
        product.setArtist(null);
        productDao.save(product);
    }
}
