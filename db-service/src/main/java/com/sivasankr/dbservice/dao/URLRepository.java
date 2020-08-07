package com.sivasankr.dbservice.dao;

import com.sivasankr.dbservice.models.URLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URLModel, String> {
    public URLModel findByShortURL(String shortURL);
}
