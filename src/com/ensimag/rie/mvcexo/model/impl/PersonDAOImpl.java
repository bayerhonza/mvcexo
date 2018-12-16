package com.ensimag.rie.mvcexo.model.impl;

import com.ensimag.rie.mvcexo.controller.ConnectToDb;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.model.dao.PersonDAO;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAOImpl implements PersonDAO {


    public PersonDAOImpl() throws SQLException {
    }

    @Override
    public Person getPerson(int id,Connection dbConnection) {
        Person person = new Person();
        try {
            PreparedStatement statement = dbConnection.prepareStatement("SELECT * FROM PERSON WHERE ID = ?");
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                person.setId(rs.getInt("ID"));
                person.setName(rs.getString("PRENOM"));
                person.setSurname(rs.getString("NOM"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void addPerson(Person person, Connection dbConnection) {

    }

    @Override
    public void updatePerson(Person person, Connection dbConnection) {

    }

    @Override
    public void removePerson(Person person, Connection dbConnection) {

    }

    @Override
    public ArrayList<Person> getAllPeople(Connection dbConnection) {
        ArrayList<Person> allPeople = new ArrayList<>();
        try {
            Statement statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(("SELECT * FROM PERSON"));
            while(rs.next()) {
                Person newPerson = new Person();
                newPerson.setId(rs.getInt("ID"));
                newPerson.setName(rs.getString("PRENOM"));
                newPerson.setSurname(rs.getString("NOM"));
                allPeople.add(newPerson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPeople;

    }
}
