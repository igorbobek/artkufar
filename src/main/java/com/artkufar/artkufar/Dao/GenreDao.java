package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GenreDao extends CrudRepository<Genre, Long> {
    Genre findByGenre(String genre);
}
