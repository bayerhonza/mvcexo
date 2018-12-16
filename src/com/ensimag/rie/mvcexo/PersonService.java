package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonService {

    private static PersonService personService;

    private final PersonDAOImpl personDAO;

    private PersonService() throws ServiceException {
        try {
            this.personDAO = new PersonDAOImpl();
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    public static PersonService getInstance() throws ServiceException {
        if (personService == null) {
            personService = new PersonService();
            return personService;
        } else {
            return personService;
        }
    }

    public void addPerson(Person person) {
        personDAO.addPerson(person);
    }

    public ArrayList<Person> getAllPeople() {
        return personDAO.getAllPeople();
    }
}
