package com.ensimag.rie.mvcexo.model.impl;

import com.ensimag.rie.mvcexo.controller.ConnectToDb;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.model.dao.PersonDAO;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAOImpl {


    public PersonDAOImpl() throws SQLException {
    }

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

    public void addPerson(Person person, Connection dbConnection) throws SQLException {
        try {
            PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO PERSON(NOM,PRENOM) VALUES (?,?)");
            statement.setString(1,person.getSurname());
            statement.setString(2,person.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatePerson(Person person, Connection dbConnection) {

    }

    public void removePerson(Integer personId, Connection dbConnection) {
        try {
            PreparedStatement statement = dbConnection.prepareStatement("DELETE FROM PERSON WHERE ID = ?");
            statement.setInt(1,personId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
