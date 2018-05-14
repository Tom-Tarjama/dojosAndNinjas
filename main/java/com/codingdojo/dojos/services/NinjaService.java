package com.codingdojo.dojos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojos.models.Dojo;
import com.codingdojo.dojos.models.Ninja;
import com.codingdojo.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
    public Ninja findById(Long id) {
	    Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
	    if(optionalNinja.isPresent()) {
	        return optionalNinja.get();
	    } else {
	        return null;
	    }
	}

}
