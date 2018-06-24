package com.alevat.spaceinvaders.awt;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.io.AudioEngine;
import com.alevat.spaceinvaders.io.InputListener;
import com.alevat.spaceinvaders.io.InputOutputResources;
import com.alevat.spaceinvaders.io.RenderingEngine;

class JavaInputOutputResources implements InputOutputResources {

    private final Console console;

    private JavaAWTRenderingEngine renderingEngine;

    public JavaInputOutputResources(Console console) {
        this.console = console;
        renderingEngine = new JavaAWTRenderingEngine(console);
    }

    @Override
    public AudioEngine getAudioEngine() {
        return null;
    }

    @Override
    public RenderingEngine getRenderingEngine() {
        return renderingEngine;
    }

    @Override
    public void registerInputListener(InputListener listener) {
        JavaAWTKeyListener keyListener = new JavaAWTKeyListener(console);
        keyListener.setInputListener(listener);
        renderingEngine.registerKeyListener(keyListener);
    }

    @Override
    public void close() {
        renderingEngine.close();
    }

}
