package com.strell.driver.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.strell.driver.models.License;
import com.strell.driver.repositories.LicenseRepository;

@Service
public class LicenseService {
	private static String newNumber = "000000";
	private final LicenseRepository LicenRepo;
    
    public LicenseService(LicenseRepository x) {
        this.LicenRepo = x;
    }
    //creando licencia.
    public License createLicense(License c) {
    	c.setNumber(newNumber);
		newNumber = String.format("%06d", Integer.parseInt(newNumber)+1);
        return LicenRepo.save(c);
    }
    //Devolviendo todas las licencias.
    public List<License> allLicense() {
        return LicenRepo.findAll();
    }
    //Busca una licencia por id de una persona
    public License getLicenseById(Long id) {
		return LicenRepo.getLicenseByPersonId(id);
	}
    //Devolviendo a una Persona por ID.
    public License findLicense(Long id) {
    	Optional<License> user = LicenRepo.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    //Actualizar Datos de una Persona.
    public License updateLicense(License b) {
    	Optional<License> user = LicenRepo.findById(b.getId());
    	if(user.isPresent()) {
        	user.get().setDate(b.getDate());
        	user.get().setState(b.getState());
        	return LicenRepo.save(user.get());
        } else {
            return null;
        }   
    }
    //Eliminando a una Persona.
    public void deleteLicense(Long id) {
    	LicenRepo.deleteById(id);
    }
}
