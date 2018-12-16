package com.ensimag.rie.mvcexo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MvcMenuBar extends JMenuBar {
    private JMenu menu;
    private JMenuItem quitMenuItem ;

    public MvcMenuBar(String menuName) {
        menu = new JMenu(menuName);
        menu.getAccessibleContext().setAccessibleDescription("Ffirst menu");
        add(menu);
        quitMenuItem = new JMenuItem("Quit");
        quitMenuItem.setMnemonic(KeyEvent.VK_Q);
    }

    public void init() {
    }

    public JMenuItem getQuitMenuItem() {
        return quitMenuItem;
    }

}
