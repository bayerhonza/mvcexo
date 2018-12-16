package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

    private PersonService personService;

    private Model model;

    private Button addButton;
    private JTextArea addNameText;
    private JTextArea addSurnameText;
    private JTextArea addDateOfBirth;

    private Button removeButton;
    private Button refreshButton;

    public Controller(Model model, Button addButton, Button removeButton, Button refreshButton) throws ServiceException {
        System.out.println(this.getClass().getName() + " starting.");
        this.model = model;
        this.personService = PersonService.getInstance();

        this.addButton = addButton;
        this.removeButton = removeButton;
        this.refreshButton = refreshButton;
        this.addButton.addActionListener(this);
        this.removeButton.addActionListener(this);
        this.refreshButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            System.out.println("Entering action performed!");
            Button sourceButton = (Button) event.getSource();
            String cmd = sourceButton.getActionCommand();
            if (cmd.equals(addButton.getActionCommand())) {

            } else if (cmd.equals(removeButton.getActionCommand())) {
                model.removeAll();
            } else if (cmd.equals(refreshButton.getActionCommand())) {
                ArrayList<Person> allPeople = personService.getAllPeople();
                model.setPeople(allPeople);
                allPeople.forEach(p -> System.out.println("nom: " + p.getName() + " prenom: " + p.getSurname()));
            }
        }
    }

    public PersonService getPersonService() { return this.personService;}
}
