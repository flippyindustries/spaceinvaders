package com.alevat.spaceinvaders.awt;

import javax.sound.sampled.Clip;

import com.alevat.spaceinvaders.game.Console;
import com.alevat.spaceinvaders.io.AudioEngine;
import com.alevat.spaceinvaders.io.SoundResource;

class JavaAudioEngine implements AudioEngine {

    private final Console console;

    JavaAudioEngine(Console console) {
        this.console = console;
    }

    @Override
    public void play(SoundResource sound) {
        Clip clip = sound.getClip();
        clip.setFramePosition(0);
        clip.start();
    }
}
