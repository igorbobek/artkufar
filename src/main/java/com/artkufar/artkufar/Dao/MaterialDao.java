package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MaterialDao extends CrudRepository<Material, Long> {
    Material findByName(String name);
}
