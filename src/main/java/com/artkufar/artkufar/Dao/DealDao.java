package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface DealDao  extends CrudRepository<Deal, Long>{

}
