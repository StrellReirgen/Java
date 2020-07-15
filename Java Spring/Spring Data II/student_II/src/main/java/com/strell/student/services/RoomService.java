package com.strell.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.student.models.Room;
import com.strell.student.repositories.RoomRepository;

@Service
public class RoomService {
	private final RoomRepository RoomRepo;
    
    public RoomService(RoomRepository x) {
        this.RoomRepo = x;
    }
    //creando licencia.
    public Room createRoom(Room c) {
        return RoomRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<Room> allRoom() {
        return RoomRepo.findAll();
    }
    //Devolviendo a una Persona por ID.
    public Room findRoom(Long id) {
    	Optional<Room> user = RoomRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public Room updateRoom(Room b) {
    	Optional<Room> user = RoomRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setStudents(b.getStudents());
        	return RoomRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteRoom(Long id) {
    	RoomRepo.deleteById(id);
    }
}
