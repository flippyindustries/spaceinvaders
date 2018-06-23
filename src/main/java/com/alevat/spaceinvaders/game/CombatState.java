package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

class CombatState extends AbstractGameState {

    public static final int LEFT_X_BOUNDARY = 0;
    public static final int RIGHT_X_BOUNDARY = Screen.WIDTH;

    private PlayerCannon playerCannon = new PlayerCannon(this);

    private CombatInputListener inputListener = new CombatInputListener(this);

    CombatState(Game game) {
        super(game);
        game.getScreen().addSprite(playerCannon);
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

