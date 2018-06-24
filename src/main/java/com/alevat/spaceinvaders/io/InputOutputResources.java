package com.alevat.spaceinvaders.io;

public interface InputOutputResources {

    AudioEngine getAudioEngine();

    RenderingEngine getRenderingEngine();

    void registerInputListener(InputListener listener);

    void close();

}
