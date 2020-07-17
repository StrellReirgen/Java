package com.strell.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.strell.student.models.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
	List<Room> findAll();
}
