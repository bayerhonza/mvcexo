package com.ensimag.rie.mvcexo.view;

import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;

/**
 * Delete button for Person
 */
public class DeletePersonButton extends JButton {

    private Person person;

    public DeletePersonButton(Person personId, String label) {
        super(label);
        this.person = personId;
    }

    /**
     * Get Person instance to which is this button assigned to
     * @return Person instance
     */
    public Person getPerson() {
        return person;
    }

}
