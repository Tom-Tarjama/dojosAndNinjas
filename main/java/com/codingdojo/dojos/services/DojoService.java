package com.codingdojo.dojos.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.repositories.DojoRepository;

@Service
public class DojoService {
	
	private DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public ArrayList<Dojo> getAllDojos(){
		return (ArrayList<Dojo>) dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
    public Dojo findById(Long id) {
	    Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	    if(optionalDojo.isPresent()) {
	        return optionalDojo.get();
	    } else {
	        return null;
	    }
	}

}
