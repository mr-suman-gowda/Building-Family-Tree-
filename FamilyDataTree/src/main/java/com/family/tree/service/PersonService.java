package com.family.tree.service;

import com.family.tree.dtos.PersonDTO;
import com.family.tree.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDTO> getAllPersons() {
        return personRepository.fetchAllPersons();
    }
    
    public Integer getAllPerson() {
    	return personRepository.getTotalPerson();
    }
    
    public Integer getAllTotalPerson() {
    	return personRepository.getTotalPerson();
    }
}
