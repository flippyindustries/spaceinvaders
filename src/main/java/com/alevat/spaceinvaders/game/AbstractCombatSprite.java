package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.AudioEngine;
import com.alevat.spaceinvaders.io.Sprite;

abstract class AbstractCombatSprite extends AbstractSprite implements CombatSprite {

    private final CombatState combatState;

    AbstractCombatSprite(CombatState combatState){
        this.combatState = combatState;
        this.combatState.getScreen().addSprite(this);
    }

    @Override
    public boolean detectCollision(CombatSprite source) {
        return detectBoundsOverlap(source) && detectPixelCollision(source);
    }

    private boolean detectBoundsOverlap(CombatSprite source) {
        return getBounds().intersects(source.getBounds());
    }

    private boolean detectPixelCollision(CombatSprite source) {
        return true;
    }

    CombatState getCombatState() {
        return combatState;
    }

    Screen getScreen() {
        return getCombatState().getScreen();
    }

    Console getConsole() {
        return getCombatState().getConsole();
    }

    AudioEngine getAudioEngine() {
        return getCombatState().getGame().getIOResources().getAudioEngine();
    }

}
