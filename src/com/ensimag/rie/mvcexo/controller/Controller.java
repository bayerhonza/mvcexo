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
import java.util.ArrayList;
import java.util.List;

public class Controller implements ActionListener {

    private PersonService personService;

    private Model model;
    private View view;

    public Controller(Model model, View view) throws ServiceException {
        this.model = model;
        this.view = view;
        this.personService = PersonService.getInstance();
    }

    public PersonService getPersonService() { return this.personService;}

    public void loadAllPeople() throws ServiceException {
        ArrayList<Person> personList = personService.getAllPeople();
        model.setPeople(personList);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof DeletePersonButton) {
            DeletePersonButton deletePersonButton = (DeletePersonButton) source;
            Person deletedPerson = deletePersonButton.getPerson();
            try {
                personService.removePerson(deletedPerson);
                view.removePersonPanel(deletedPerson);
                model.removePerson(deletedPerson);
            } catch (ServiceException e1) {
                e1.printStackTrace();
            }
        } else if (source instanceof AddPersonButton) {
            AddPersonButton addPersonButton = (AddPersonButton) source;
            String newName = addPersonButton.getName();
            String newSurname = addPersonButton.getSurname();
            Person newPerson = model.createPerson(newName, newSurname);
            try {
                personService.addPerson(newPerson);
            } catch (ServiceException e1) {
                e1.printStackTrace();
            }
        }
    }
}
