package com.alevat.spaceinvaders;

import java.awt.*;
import javax.swing.*;

class Screen {

    private JFrame jFrame;
    private JPanel jPanel;

    void open() {
        initializeJPanel();
        initializeJFrame();
        displayScreen();
    }

    private void initializeJFrame() {
        jFrame = new JFrame("Space Invaders");
        jFrame.setUndecorated(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeJPanel() {
        jPanel = new JPanel();
        jPanel.setBackground(Color.BLACK);
        jPanel.setPreferredSize(new Dimension(800, 600));
    }

    private void displayScreen() {
        jFrame.setContentPane(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}
