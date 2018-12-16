package com.ensimag.rie.mvcexo.controller;

import com.ensimag.rie.mvcexo.model.Model;
import com.ensimag.rie.mvcexo.services.impl.PersonService;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    private PersonService personService;

    private Model model;

    public Controller(Model model, Button addButton, Button removeButton, Button refreshButton) throws ServiceException {
        System.out.println(this.getClass().getName() + " starting.");
        this.model = model;
        this.personService = PersonService.getInstance();
    }

    public PersonService getPersonService() { return this.personService;}
}
