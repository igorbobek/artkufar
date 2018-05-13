package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface PhoneDao  extends CrudRepository<Phone,Long>{
}
