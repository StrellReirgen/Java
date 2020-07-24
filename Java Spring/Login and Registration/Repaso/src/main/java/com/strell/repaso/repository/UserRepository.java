package com.strell.repaso.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.strell.repaso.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {
	User findByEmail(String email);
}
