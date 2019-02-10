package com.ensimag.rie.mvcexo.view;

import com.ensimag.rie.mvcexo.controller.Controller;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Model;
import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * View vlass for the application with GUI and GUI logic.
 */
public class View extends JFrame {

    private Controller controller;

    ArrayList<PersonPanel> personPanels = new ArrayList<>();

    private JPanel mainPanel;

    private JTextArea newNameTextArea;
    private JTextArea newSurnameTextArea;
    private AddPersonButton addButton;
    private JButton refreshButton;
    private JPanel textPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            try {
                view.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
            view.pack();
            view.setVisible(true);
        });
    }

    /**
     * Initializastion of controller and layouts of application.
     * @throws ServiceException if DB connection fails
     */
    public void init() throws ServiceException {
        this.controller = new Controller(this);

        setMinimumSize(new Dimension(400,400));

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800,400));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.Y_AXIS));
        textPanel.setBorder(BorderFactory.createLineBorder(Color.blue));

        personPanels.forEach(personPanel -> textPanel.add(personPanel));
        add(textPanel,BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(500,100));

        newNameTextArea = new JTextArea("Name");
        newNameTextArea.setPreferredSize(new Dimension(40,20));
        addFocusListener(newNameTextArea);
        buttonsPanel.add(newNameTextArea);

        newSurnameTextArea = new JTextArea("Surname");
        newSurnameTextArea.setPreferredSize(new Dimension(40,20));
        addFocusListener(newSurnameTextArea);

        buttonsPanel.add(newSurnameTextArea);

        addButton = new AddPersonButton(newNameTextArea,newSurnameTextArea,"Add");
        addButton.addActionListener(controller);
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(controller);
        buttonsPanel.add(addButton);
        buttonsPanel.add(refreshButton);
        add(buttonsPanel,BorderLayout.SOUTH);

        controller.loadAllPeople();

    }

    /**
     * Removes panel assigned to Person from GUI while deletion.
     * @param person person whose panel is to be deleted.
     */
    public void removePersonPanel(Person person) {
        personPanels.stream()
                .filter(personPanel -> personPanel.getPersonId() == person.getId())
                .findFirst()
                .ifPresent(p -> {
                    textPanel.remove(p);
                    personPanels.remove(p);
                });
    }

    /**
     * Creates new panel for given person.
     * @param person object of panel
     */
    public void addPersonPanel(Person person) {
        PersonPanel newPersonPanel = new PersonPanel(person,controller);
        textPanel.add(newPersonPanel);
        personPanels.add(newPersonPanel);
    }

    /**
     * Handles emptying of text area after getting focus.
     * @param jTextArea text area to set
     */
    private void addFocusListener(JTextArea jTextArea) {
        jTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jTextArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

}
