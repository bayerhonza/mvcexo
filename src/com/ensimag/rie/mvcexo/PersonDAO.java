package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import java.util.ArrayList;

public interface PersonDAO {

    Person getPerson(int id);

    void removePerson(int id);

    ArrayList<Person> getAllPeople();

    void addPerson(Person person);
}
