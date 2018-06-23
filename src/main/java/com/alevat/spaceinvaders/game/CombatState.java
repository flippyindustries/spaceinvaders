package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

class CombatState extends AbstractGameState {

    private PlayerCannon playerCannon = new PlayerCannon(this);

    private CombatInputListener inputListener = new CombatInputListener(this);

    CombatState(Game game) {
        super(game);
    }

    @Override
    public InputListener getInputListener() {
        return inputListener;
    }

    @Override
    public void update() {
        playerCannon.update();
    }

    PlayerCannon getPlayerCannon() {
        return playerCannon;
    }
}

