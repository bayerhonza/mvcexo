package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonDAOImpl implements PersonDAO {

    private Connection dbConnection;

    public PersonDAOImpl() throws SQLException {
        dbConnection = ConnectToDb.createConnection();
    }

    @Override
    public Person getPerson(int id) {
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
    public void removePerson(int id) {

    }

    @Override
    public ArrayList<Person> getAllPeople() {
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

    @Override
    public void addPerson(Person person) {

    }
}
