package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ArtistDao extends CrudRepository<Artist, Long> {
}
