package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Dao.DealDao;
import com.artkufar.artkufar.Model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealServiceImpl implements DealService{

    @Autowired
    DealDao dealDao;

    @Override
    public void save(Deal deal) {
        dealDao.save(deal);
    }

    @Override
    public Deal getById(Long id) {

        if(dealDao.findById(id).isPresent()){
            return  dealDao.findById(id).get();
        }

        return null;
    }

    @Override
    public List<Deal> getAll() {
        List<Deal> deals = new ArrayList<>();
        dealDao.findAll().forEach(deals::add);
        return deals;
    }
}
