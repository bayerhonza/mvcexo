package com.ensimag.rie.mvcexo.model.impl;

import com.ensimag.rie.mvcexo.controller.ConnectToDb;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.model.dao.PersonDAO;

import java.sql.*;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class PersonDAOImpl {

    private final String DELETE_SQL = "DELETE FROM PERSON WHERE ID = ?";
    private final String EXISTS_SQL = "SELECT NOM FROM PERSON WHERE ID = ?";
    private final String INSERT_SQL = "INSERT INTO PERSON(NOM,PRENOM) VALUES (?,?)";

    public PersonDAOImpl() throws SQLException {
    }

    public boolean exists(int id, Connection dbConnection) {

        try {
            PreparedStatement statement = dbConnection.prepareStatement(EXISTS_SQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void addPerson(Person person, Connection dbConnection) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(INSERT_SQL);
        statement.setString(1, person.getSurname());
        statement.setString(2, person.getName());
        statement.executeUpdate();

    }

    public void updatePerson(Person person, Connection dbConnection) {

    }

    public void removePerson(Integer personId, Connection dbConnection) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement(DELETE_SQL);
        statement.setInt(1, personId);
        statement.executeUpdate();
    }

    public ArrayList<Person> getAllPeople(Connection dbConnection) throws SQLException {
        ArrayList<Person> allPeople = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet rs = statement.executeQuery(("SELECT * FROM PERSON"));
        while (rs.next()) {
            Person newPerson = new Person();
            newPerson.setId(rs.getInt("ID"));
            newPerson.setName(rs.getString("PRENOM"));
            newPerson.setSurname(rs.getString("NOM"));
            allPeople.add(newPerson);
        }
        return allPeople;

    }
}
