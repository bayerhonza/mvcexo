package com.ensimag.rie.mvcexo.view;

import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonPanel extends JPanel {

    private Integer personId;
    private Person person;

    DeletePersonButton deleteButton;

    public PersonPanel(Person person, ActionListener actionListener) {
        super(new FlowLayout(FlowLayout.RIGHT));
        //setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        setPreferredSize(new Dimension(300,30));
        this.personId = person.getId();
        this.person = person;

        JLabel nameText = new JLabel(person.getName());
        add(nameText);
        JLabel surnameText = new JLabel(person.getSurname());
        add(surnameText);
        deleteButton = new DeletePersonButton(person,"Delete");
        add(deleteButton);
        deleteButton.addActionListener(actionListener);
    }

    public Integer getPersonId() {
        return personId;
    }



}
