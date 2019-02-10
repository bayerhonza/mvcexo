package com.ensimag.rie.mvcexo.view;

import javax.swing.*;

/**
 * Class for button per person. Instances of this class are assigned to a person.
 */
public class AddPersonButton extends JButton {

    private JTextArea  nameTextArea;
    private JTextArea surnameTextArea;

    public AddPersonButton(JTextArea nameTextArea, JTextArea surnameTextArea, String label) {
        super(label);
        this.nameTextArea = nameTextArea;
        this.surnameTextArea = surnameTextArea;
    }

    /**
     * Getter of name added in nameTextArea
     * @return name
     */
    public String getNewName() {
        return nameTextArea.getText();
    }

    /**
     * Getter of name added in surnameTextArea
     * @return surname
     */
    public String getSurname() {
        return surnameTextArea.getText();
    }
}
