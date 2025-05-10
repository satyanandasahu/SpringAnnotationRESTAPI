package com.example.satya.rest.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.satya.rest.api.exception.InvalidDataException;
import com.example.satya.rest.api.exception.ResourceNotFoundException;
import com.example.satya.service.IPersonService;
import com.example.satya.vo.Person;


@Configuration
@RestController
public class PersonalInformationAPI {
	
//	private ApplicationContext applicationContext = null;
	private static final Logger logger = LogManager.getLogger();
	
	public PersonalInformationAPI(){
		super();
		//applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}

	@Autowired
	private IPersonService personService;
	
	@GetMapping(value="/user/api",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Person getPersonBiography(@RequestParam(name="id") String id) {
		logger.info("Entered getPersonBiography id = " + id);
	//	personService = (IPersonService)applicationContext.getBean("personService");		

		Person person = null;
		
		if (id != null && !id.isBlank() && !id.isEmpty()) {
			Person personObject = new Person();
			personObject.setPersonId(id);
			person = personService.getPerson(personObject);
			if (person == null) 
				throw new ResourceNotFoundException("Id " + id + " is not found");
		} else
			throw new InvalidDataException("Invalid input data");
		logger.info("Exited getPersonBiography person = " + person);
		return person;	
	}
	
		
	
	
	@PostMapping(value="/user/api/create")
	public String createPerson(@RequestBody Person person) {
		logger.info("Entered createPerson id = " + person);
		
		if (person != null) {
		//	personService = (IPersonService)applicationContext.getBean("personService");		
			personService.createPerson(person);
		} else
			throw new InvalidDataException("Person data is missing");
		
		logger.info("Exited createPerson person = " + person);
		return person.getPersonId() + " is created";
	}
	
	
	/**
	 * @return the personService
	 */
	public IPersonService getPersonService() {
		return personService;
	}


	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(IPersonService personService) {
		this.personService = personService;
	}

}
