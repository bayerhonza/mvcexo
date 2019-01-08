package com.ensimag.rie.mvcexo.view;

import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;

public class DeletePersonButton extends JButton {

    private Person person;

    public DeletePersonButton(Person personId, String label) {
        super(label);
        this.person = personId;
    }

    public Person getPerson() {
        return person;
    }

}
