package com.alevat.spaceinvaders.awt;

import java.awt.*;
import javax.swing.*;

import com.alevat.spaceinvaders.game.Screen;

class ScreenPanel extends JPanel {

    void initialize() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(Screen.WIDTH, Screen.HEIGHT));
        setFocusable(true);
        requestFocus();
    }

}
