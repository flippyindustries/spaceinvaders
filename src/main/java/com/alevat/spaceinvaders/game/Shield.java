package com.alevat.spaceinvaders.game;

import java.awt.image.BufferedImage;

import com.alevat.spaceinvaders.io.ImageResource;

class Shield extends AbstractCombatSprite {

    static final int Y_POSITION = 56;
    static final int WIDTH = ImageResource.SHIELD.getWidth();

    private final int x;
    private final BufferedImage image;

    Shield(CombatState state, int x) {
        super(state);
        this.x = x;
        this.image = ImageResource.SHIELD.copyBufferedImage();
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
    public BufferedImage getBufferedImage() {
        return image;
    }

}
