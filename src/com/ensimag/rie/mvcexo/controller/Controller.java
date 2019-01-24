package com.ensimag.rie.mvcexo.controller;

import com.ensimag.rie.mvcexo.model.Model;
import com.ensimag.rie.mvcexo.services.impl.PersonService;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Person;
import com.ensimag.rie.mvcexo.view.AddPersonButton;
import com.ensimag.rie.mvcexo.view.DeletePersonButton;
import com.ensimag.rie.mvcexo.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {

    private PersonService personService;

    private Model model;
    private View view;

    public Controller(View view) throws ServiceException {
        this.model = new Model(view);
        this.view = view;
        this.personService = PersonService.getInstance();
    }

    public PersonService getPersonService() { return this.personService;}

    public void loadAllPeople()  {
        try {
            ArrayList<Person> personList = personService.getAllPeople();
            model.getPeople().addAll(personList);
            personList.forEach(view::addPersonPanel);
        } catch (SQLException e) {
            System.out.println("Unexpected SQL exception: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof DeletePersonButton) {
            DeletePersonButton deletePersonButton = (DeletePersonButton) source;
            Person deletedPerson = deletePersonButton.getPerson();
            try {
                model.removePerson(deletedPerson);
                personService.removePerson(deletedPerson);
                view.revalidate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } else if (source instanceof AddPersonButton) {
            AddPersonButton addPersonButton = (AddPersonButton) source;
            String newName = addPersonButton.getName();
            String newSurname = addPersonButton.getSurname();

            try {
                Person newPerson = model.createPerson(newName, newSurname);
                personService.addPerson(newPerson);
                view.revalidate();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
