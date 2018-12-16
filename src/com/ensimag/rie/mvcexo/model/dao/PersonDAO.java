package com.ensimag.rie.mvcexo.model.dao;

import com.ensimag.rie.mvcexo.model.Person;

import java.sql.Connection;
import java.util.ArrayList;

public interface PersonDAO {

    Person getPerson(int id, Connection dbConnection);

    void addPerson(Person person,Connection dbConnection);

    void updatePerson(Person person, Connection dbConnection);

    void removePerson(Person person,Connection dbConnection);

    ArrayList<Person> getAllPeople(Connection dbConnection);
}
