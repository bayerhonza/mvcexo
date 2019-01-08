package com.ensimag.rie.mvcexo.services.impl;

import com.ensimag.rie.mvcexo.controller.ConnectToDb;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.model.impl.PersonDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonService {
    private Connection dbConnection;
    private static PersonService personService;

    private final PersonDAOImpl personDAO;

    private PersonService() throws ServiceException {
        try {
            this.personDAO = new PersonDAOImpl();
            dbConnection = ConnectToDb.createConnection();
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

    public void addPerson(Person person) throws ServiceException {
        Connection connection = getCurrentDbConnection();
        try {
            personDAO.addPerson(person,connection);
        } catch (SQLException e) {
            throw new ServiceException();
        }
    }

    public void updatePerson(Person person) throws ServiceException {
        Connection connection = getCurrentDbConnection();
        personDAO.updatePerson(person,connection);
    }

    public void removePerson(Person person) throws ServiceException {
        Connection connection = getCurrentDbConnection();
        personDAO.removePerson(person.getId(),connection);
    }

    private Connection getCurrentDbConnection() {
        return this.dbConnection;
    }

    public ArrayList<Person> getAllPeople() throws ServiceException {
        Connection connection = getCurrentDbConnection();
        return personDAO.getAllPeople(connection);
    }
}
