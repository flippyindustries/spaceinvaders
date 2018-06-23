package com.alevat.spaceinvaders.io;

/**
 * A renderable independent game element.
 */
public interface Sprite {

    /**
     * @return the x position of the left-most pixel of the sprite.
     */
    int getX();

    /**
     * @return the y position of the bottom-most pixel of the sprite.
     */
    int getY();

    ImageResource getImageResource();

}
