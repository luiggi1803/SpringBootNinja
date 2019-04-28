package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOGGER=LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getPerson() {
		LOGGER.info(" HELLO FROM ExampleServiceImpl");
		List<Person> persons= new ArrayList<>();
		persons.add(new Person("Luiggi", 26));
		persons.add(new Person("Eder", 28));
		persons.add(new Person("Hernan", 13));
		persons.add(new Person("Fernando", 53));
		return persons;
	}

}
