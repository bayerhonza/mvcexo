package com.ensimag.rie.mvcexo;

import com.ensimag.rie.mvcexo.model.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class View extends Applet {

    private Model model;
    private Controller controller;

    private JTable table;
    private DefaultTableModel tableModel;
    private Button add;

    private JTextField addNameText;
    private JTextArea addSurnameText;
    private JTextArea addDateOfBirth;

    private Button remove;
    private Button refresh;

    public static void main(String[] args) {
        View view = new View();
        view.init();
        ArrayList<Person> allPeople = view.controller.getPersonService().getAllPeople();
        view.model.setPeople(allPeople);
    }

    public void init() {
        System.out.println("sfasdfasfd");
        this.add = new Button("Add");
        this.remove = new Button("Remove");
        this.refresh = new Button("Refresh");

        this.model = new Model(this);
        try {
            this.controller = new Controller(this.model,add,remove,refresh);
        } catch (ServiceException e) {
            return;
        }

        String col[] = {"ID","Name","Surname"};
        tableModel = new DefaultTableModel(col,0);
        table = new JTable(tableModel);
        add(this.table);

        add(this.add);
        add(this.remove);
        add(this.refresh);


    }

    @Override
    public void paint(Graphics g) {
        String paint = "";
        g.drawString("Size of people is : " + model.getPeople().size(),20,50);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }


}
