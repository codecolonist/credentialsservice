package com.codecolonist.credentialsservice.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CredRepository extends CrudRepository<Credentials, Integer> {

	List<Credentials> findAll();
}
