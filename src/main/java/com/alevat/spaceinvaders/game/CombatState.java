package com.alevat.spaceinvaders.game;

import com.alevat.spaceinvaders.io.InputListener;

class CombatState extends AbstractGameState {

    public static final int LEFT_X_BOUNDARY = 20;
    public static final int RIGHT_X_BOUNDARY = Screen.WIDTH - 20;

    public static final int TOP_Y_BOUNDARY = Screen.HEIGHT - 34;

    private PlayerCannon playerCannon = new PlayerCannon(this);
    private PlayerShot playerShot;

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
        if (playerShot != null) {
            playerShot.update();
        }
    }

    PlayerCannon getPlayerCannon() {
        return playerCannon;
    }

    PlayerShot getPlayerShot() {
        return playerShot;
    }

    void setPlayerShot(PlayerShot playerShot) {
        this.playerShot = playerShot;
    }
}

