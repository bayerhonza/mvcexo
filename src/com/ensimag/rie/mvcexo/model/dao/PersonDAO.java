package com.ensimag.rie.mvcexo.model.dao;

import com.ensimag.rie.mvcexo.model.Person;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * DAO for Person objects
 */
public interface PersonDAO {

    /**
     * Load person from DB and creates new instance of Person.
     * @param id person's id
     * @param dbConnection corresponding DB connection
     * @return object of person
     */
    Person getPerson(int id, Connection dbConnection);

    /**
     * Persists Person in DB.
     * @param person person to be persisted
     * @param dbConnection corresponding DB connection
     */
    void addPerson(Person person,Connection dbConnection);

    /**
     * Updates existing person in DB
     * @param person person to be updated
     * @param dbConnection corresponding DB connectino
     */
    void updatePerson(Person person, Connection dbConnection);

    /**
     * Remoes existing person from DB
     * @param person person to be removed.
     * @param dbConnection corresponding DB connection
     */
    void removePerson(Person person,Connection dbConnection);

    /**
     * Loads all people presenit in DB in new collection of Person objects.
     * @param dbConnection corresponding DB connection
     * @return list of people
     */
    ArrayList<Person> getAllPeople(Connection dbConnection);
}
