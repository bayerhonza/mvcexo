package com.ensimag.rie.mvcexo.model;

import com.ensimag.rie.mvcexo.view.View;

import java.util.ArrayList;

public class Model {

    private final View view;
    private ArrayList<Person> people = new ArrayList<>();

    public Model(View view) {
        this.view = view;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
        view.repaint();
    }

    public void removeAll() {
        people.clear();
        view.repaint();
    }

}
