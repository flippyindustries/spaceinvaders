package com.alevat.spaceinvaders;

class Game {

    private boolean running;
    private Screen screen = new Screen();
    private Player player = new Player();

    void start() {
        running = true;
        screen.open();
        while (running) {
            try {
                Thread.sleep(1000);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
