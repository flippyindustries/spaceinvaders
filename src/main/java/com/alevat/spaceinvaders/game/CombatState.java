package com.alevat.spaceinvaders.game;

import java.util.ArrayList;
import java.util.List;

import com.alevat.spaceinvaders.io.InputListener;

class CombatState extends AbstractGameState {

    public static final int LEFT_X_BOUNDARY = 20;
    public static final int RIGHT_X_BOUNDARY = Screen.WIDTH - 20;

    public static final int TOP_Y_BOUNDARY = Screen.HEIGHT - 34;

    private static final int SHIELD_COUNT = 4;
    private static final int FIRST_SHIELD_OFFSET = 32;
    private static final int SHIELD_SPACING = 24;

    private PlayerCannon playerCannon = new PlayerCannon(this);
    private PlayerShot playerShot;
    private List<Shield> shields = new ArrayList<>();

    private CombatInputListener inputListener = new CombatInputListener(this);

    CombatState(Game game) {
        super(game);
        initialize();
    }

    private void initialize() {
        getScreen().addSprite(playerCannon);
        initializeShields();
    }

    private void initializeShields() {
        int shieldX = FIRST_SHIELD_OFFSET;
        for (int i = 0; i < SHIELD_COUNT; i++) {
            Shield shield = new Shield(this, shieldX);
            shields.add(shield);
            getScreen().addSprite(shield);
            shieldX += shield.WIDTH + SHIELD_SPACING;
        }
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

