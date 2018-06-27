package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.ImageResource;
import com.alevat.spaceinvaders.io.Sprite;

class Shield implements Sprite {

    static final int Y_POSITION = 56;
    static final int WIDTH = ImageResource.SHIELD.getBufferedImage().getWidth();

    private final CombatState state;
    private final int x;

    Shield(CombatState state, int x) {
        this.state = state;
        this.x = x;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return Y_POSITION;
    }

    @Override
    public ImageResource getImageResource() {
        return ImageResource.SHIELD;
    }

}
