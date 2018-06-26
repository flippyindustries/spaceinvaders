package com.alevat.spaceinvaders.io;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum SoundResource {

    FIRE_SHOT("shot.wav");

    private final Clip clip;

    SoundResource(String filename) {
        clip = loadClip(filename);
    }

    private Clip loadClip(String filename) {
        URL url = getClass().getResource("/sounds/" + filename);
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(url));
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            throw new IllegalStateException("Couldn't load sound at URL: " + url);
        }
        return clip;
    }

    public Clip getClip() {
        return clip;
    }
}
