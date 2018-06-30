package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.Sprite;

abstract class AbstractSprite implements Sprite {


    @Override
    public int getWidth() {
        return getBufferedImage().getWidth();
    }

    @Override
    public int getHeight() {
        return getBufferedImage().getHeight();
    }

}
