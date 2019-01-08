package com.ensimag.rie.mvcexo.view;

import com.ensimag.rie.mvcexo.controller.Controller;
import com.ensimag.rie.mvcexo.exceptions.ServiceException;
import com.ensimag.rie.mvcexo.model.Model;
import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class View extends JFrame {

    private Model model;
    private Controller controller;

    ArrayList<PersonPanel> personPanels = new ArrayList<>();

    private JPanel mainPanel;
    private FlowLayout mainPanelLayout;

    private JTextArea newNameTextArea;
    private JTextArea newSurnameTextArea;
    private AddPersonButton addButton;
    private JButton refreshButton;
    private JPanel textPanel;


    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
                try {
                    view.init();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                view.pack();
                view.setVisible(true);
            }
        });
    }

    public void updatePersonPannels() {
        personPanels.clear();
        model.getPeople().forEach(person -> {
            PersonPanel personPanel = new PersonPanel(person,controller);
            personPanels.add(personPanel);
        } );
    }

    public void init() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        this.model = new Model(this);
        try {
            this.controller = new Controller(this.model, this);
            controller.loadAllPeople();
        } catch (ServiceException e) {
            e.printStackTrace();
        }


        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(800,400));
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        textPanel = new JPanel(new FlowLayout());
        textPanel.setPreferredSize(new Dimension(350,500));

        updatePersonPannels();
        personPanels.forEach(textPanel::add);
        add(textPanel,BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        buttonsPanel.setPreferredSize(new Dimension(500,100));

        newNameTextArea = new JTextArea("Name");
        newNameTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                newNameTextArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        buttonsPanel.add(newNameTextArea);
        newSurnameTextArea = new JTextArea("Surname");
        newSurnameTextArea.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                newSurnameTextArea.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        buttonsPanel.add(newSurnameTextArea);
        addButton = new AddPersonButton(newNameTextArea,newSurnameTextArea,"Add");
        addButton.addActionListener(controller);
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(controller);
        buttonsPanel.add(addButton);
        buttonsPanel.add(refreshButton);
        add(buttonsPanel,BorderLayout.SOUTH);
    }

    public void removePersonPanel(Person person) {
        PersonPanel personPanelToBeRemoved = personPanels.stream().filter(personPanel -> personPanel.getPersonId() == person.getId()).findFirst().get();
        textPanel.remove(personPanelToBeRemoved);
    }

}
