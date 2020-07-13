package com.strell.driver.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.driver.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
	License getLicenseByPersonId(Long id);
}
