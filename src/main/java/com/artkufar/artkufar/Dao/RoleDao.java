package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RoleDao extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
