package com.ensimag.rie.mvcexo.model;

import com.ensimag.rie.mvcexo.view.View;

import java.util.ArrayList;

public class Model {

    private final View view;
    private final ArrayList<Person> people = new ArrayList<>();

    public Model(View view) {
        this.view = view;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public Person createPerson(String name, String surname) {
        Person newPerson = new Person(name,surname);
        addPerson(newPerson);
        return newPerson;
    }

    public void addPerson(Person person) {
        people.add(person);
        view.addPersonPanel(person);
    }

    public void removePerson(Person person) {
        people.remove(person);
        view.removePersonPanel(person);
    }

    public void removeAll() {
        people.clear();
        view.revalidate();
    }

}
