package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.AudioEngine;

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

    @Override
    public void handleShotCollision(PlayerShot playerShot) {
        handleIllegalCollision(playerShot); // default, override where allowed
    }

    private void handleIllegalCollision(CombatSprite sprite) {
        throw new UnsupportedOperationException("Illegal collision between " + getClass().getSimpleName()
                + " + and " + sprite.getClass().getSimpleName());
    }

}
