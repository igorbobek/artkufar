package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Model.Deal;

import java.util.List;

public interface DealService {
    void save(Deal deal);
    Deal getById(Long id);
    List<Deal> getAll();
}
