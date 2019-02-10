package com.ensimag.rie.mvcexo.services.impl;

import com.ensimag.rie.mvcexo.controller.ConnectToDb;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.model.impl.PersonDAOImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service handling DB connections and DB querying. This class is singleton.
 */
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

    /**
     * Get current instance of PersonService
     * @return service
     * @throws ServiceException throws {@link ServiceException} if DB connection fails.
     */
    public static PersonService getInstance() throws ServiceException {
        if (personService == null) {
            personService = new PersonService();
            return personService;
        } else {
            return personService;
        }
    }

    /**
     * Persist person
     * @param person person to be persisted
     * @throws SQLException throws {@link ServiceException} if DB connection fails.
     */
    public void addPerson(Person person) throws SQLException {
        Connection connection = getCurrentDbConnection();
        personDAO.addPerson(person,connection);
    }

    /**
     * Update person.
     * @param person person to be updated
     */
    public void updatePerson(Person person) {
        Connection connection = getCurrentDbConnection();
        personDAO.updatePerson(person,connection);
    }

    /**
     * Removes person
     * @param person person to be removed
     * @throws SQLException throws {@link ServiceException} if DB connection fails.
     */
    public void removePerson(Person person) throws SQLException {
        Connection connection = getCurrentDbConnection();
        personDAO.removePerson(person.getId(),connection);
    }

    /**
     * Getter for current DB connection.
     * @return current DB connection
     */
    private Connection getCurrentDbConnection() {
        return this.dbConnection;
    }

    /**
     * Return all people present in DB.
     * @return list of people in DB
     * @throws SQLException throws {@link ServiceException} if DB connection fails.
     */
    public ArrayList<Person> getAllPeople() throws SQLException {
        Connection connection = getCurrentDbConnection();
        return personDAO.getAllPeople(connection);
    }

    /**
     * Checks if person exists in DB
     * @param person person to be checked
     * @return true if exists, false if not
     */
    public boolean checkPerson(Person person) {
        Connection connection = getCurrentDbConnection();
        return personDAO.exists(person.getId(),connection);
    }
}
