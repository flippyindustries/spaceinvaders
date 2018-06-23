package com.alevat.spaceinvaders.io;

/**
 * A renderable independent game element.
 */
public interface Sprite {

    /**
     * Returns the x position of the left-most pixel of the sprite.
     */
    int getX();

    /**
     * Returns the y position of the bottom-most pixel of the sprite.
     */
    int getY();

    ImageResource getImageResource();

}
