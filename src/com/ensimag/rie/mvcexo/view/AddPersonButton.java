package com.ensimag.rie.mvcexo.view;

import javax.swing.*;

public class AddPersonButton extends JButton {

    private JTextArea  nameTextArea;
    private JTextArea surnameTextArea;

    public AddPersonButton(JTextArea nameTextArea, JTextArea surnameTextArea, String label) {
        super(label);
        this.nameTextArea = nameTextArea;
        this.surnameTextArea = surnameTextArea;
    }

    public String getName() {
        return nameTextArea.getText();
    }

    public String getSurname() {
        return surnameTextArea.getText();
    }
}
