package com.ensimag.rie.mvcexo.model;

import com.ensimag.rie.mvcexo.view.View;

import java.util.ArrayList;

/**
 * Model class which handles Person present in the memory.
 */
public class Model {

    private final View view;
    private final ArrayList<Person> people = new ArrayList<>();

    public Model(View view) {
        this.view = view;
    }

    /**
     * Getter of list of Person instances present in the memory.
     * @return
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * Creates new instance of Person.
     * @param name name of person
     * @param surname surname of person
     * @return new instance of Person
     */
    public Person createPerson(String name, String surname) {
        Person newPerson = new Person(name,surname);
        addPerson(newPerson);
        return newPerson;
    }

    /**
     * Adds instance to local list of Person object instances
     * @param person Person object instance
     */
    public void addPerson(Person person) {
        people.add(person);
        view.addPersonPanel(person);
    }

    /**
     * Removes instance from local list.
     * @param person Person object instance
     */
    public void removePerson(Person person) {
        people.remove(person);
        view.removePersonPanel(person);
    }

    /**
     * Removes all the instances present in the system.
     */
    public void removeAll() {
        people.clear();
        view.revalidate();
    }

}
