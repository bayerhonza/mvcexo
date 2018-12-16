package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import java.util.ArrayList;

public class Model {

    private final View view;
    private ArrayList<Person> people = new ArrayList<>();

    public Model(View view) {
        this.view = view;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
        this.view.getTableModel().setRowCount(0);
        people.forEach(person -> {
            Object[] data = {person.getId(),person.getName(),person.getSurname()};
            this.view.getTableModel().addRow(data);
        });
        this.view.repaint();
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
