package com.alevat.spaceinvaders;

import java.awt.*;
import javax.swing.*;

public class FullScreenTest {

    private GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    private GraphicsDevice device = graphicsEnvironment.getDefaultScreenDevice();

    public static void main(String[] args) {
        try {
            FullScreenTest test = new FullScreenTest();
            test.showDevices();
//            test.showMaximizedScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void showDevices() {
        for (GraphicsDevice graphicsDevice : graphicsEnvironment.getScreenDevices()) {
            System.out.println(toInfoString(graphicsDevice));
            for (DisplayMode displayMode : graphicsDevice.getDisplayModes()) {
                System.out.println(toInfoString(displayMode));
            }

        }
    }

    private String toInfoString(GraphicsDevice graphicsDevice) {
        return graphicsDevice.getIDstring();
    }

    private String toInfoString(DisplayMode mode) {
        return mode.getWidth() + " x " + mode.getHeight() + ": "
                + mode.getBitDepth() + " bits, " + mode.getRefreshRate() + " Hz";
    }

    private void showDisplayModes() {
        System.out.println(device);
    }

    private void showMaximizedScreen() throws InterruptedException {
        try {
            Frame frame = new Frame(device.getDefaultConfiguration());
            frame.setUndecorated(true);
            frame.setIgnoreRepaint(true);
            device.setFullScreenWindow(frame);
            if (device.isDisplayChangeSupported()) {
                setBestDisplayMode();
            }
            Thread.sleep(5000);
        } finally {
            device.setFullScreenWindow(null);
        }
    }

    private void setBestDisplayMode() {

    }

}
