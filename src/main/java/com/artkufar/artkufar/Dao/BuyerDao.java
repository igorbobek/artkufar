package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BuyerDao extends CrudRepository<Buyer, Long>{
}
