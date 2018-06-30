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
    public boolean detectCollision(Sprite sprite) {
        return false;
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
