package com.strell.dojoninja.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.strell.dojoninja.models.Dojo;

public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{
}
