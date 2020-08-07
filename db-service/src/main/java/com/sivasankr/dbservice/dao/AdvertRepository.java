package com.sivasankr.dbservice.dao;

import com.sivasankr.dbservice.models.AdvertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "ads", path="ads")
public interface AdvertRepository extends JpaRepository<AdvertModel, Integer> {
}
