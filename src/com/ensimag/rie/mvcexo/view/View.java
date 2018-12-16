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

public class View extends JFrame implements ActionListener, ComponentListener {

    private Model model;
    private Controller controller;

    private MvcMenuBar menuBar;
    private JPanel mainPanel;
    private FlowLayout mainPanelLayout;

    private Button add;

    boolean originalLabel = true;

    private JTextField addNameText;
    private JTextArea addSurnameText;
    private JTextArea addDateOfBirth;

    private Button remove;
    private Button refresh;

    public static void main(String[] args) {
        View view = new View();
        view.init();
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        });*/
    }

    public void init() {
        System.out.println("sfasdfasfd");
        JButton btn1 = new JButton("Screensize");
        JButton btn2 = new JButton("Screensize1");
        JButton btn3 = new JButton("Screensize2");
        JPanel pnl = new JPanel(new FlowLayout());
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        btn1.setPreferredSize(new Dimension(200,40));
        btn2.setPreferredSize(new Dimension(200,40));
        btn3.setPreferredSize(new Dimension(200,40));

        pnl.setPreferredSize(new Dimension(640,480));
        pnl.add(btn1,BorderLayout.CENTER);
        pnl.add(btn2,BorderLayout.CENTER);
        pnl.add(btn3,BorderLayout.CENTER);
        addComponentListener(this);

        add(pnl,BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        pack();
        setVisible(true);

        /*setPreferredSize(new Dimension(400,800));
        menuBar = new MvcMenuBar("About");
        setJMenuBar(menuBar);
        setLocationRelativeTo(null);

        FlowLayout flowLayout = new FlowLayout();
        mainPanel = new JPanel(flowLayout);


        this.add = new Button("Add");
        this.remove = new Button("Remove");
        this.refresh = new Button("Refresh");


        add(this.add);
        add(this.remove);
        add(this.refresh);

        setVisible(true);

        this.model = new Model(this);
        try {
            this.controller = new Controller(this.model,add,remove,refresh);
        } catch (ServiceException e) {
            return;
        }

        String col[] = {"ID","Name","Surname"};

        */

    }



    @Override
    public void paint(Graphics g) {
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {
            JButton button = (JButton) event.getSource();
            setOriginalLabel(!originalLabel);
            if (originalLabel) {
                button.setLabel("Original label");
            } else {
                button.setLabel("new label");
            }
            button.repaint();

            /*Button sourceButton = (Button) event.getSource();
            String cmd = sourceButton.getActionCommand();
            if (cmd.equals(addButton.getActionCommand())) {

            } else if (cmd.equals(removeButton.getActionCommand())) {
                model.removeAll();
            } else if (cmd.equals(refreshButton.getActionCommand())) {
                ArrayList<Person> allPeople = personService.getAllPeople();
                model.setPeople(allPeople);
                allPeople.forEach(p -> System.out.println("nom: " + p.getName() + " prenom: " + p.getSurname()));
            }*/
        }
    }

    public void setOriginalLabel(boolean isOriginal) {
        this.originalLabel = isOriginal;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println(e.paramString());
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println(e.paramString());
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println(e.paramString());
    }
}
