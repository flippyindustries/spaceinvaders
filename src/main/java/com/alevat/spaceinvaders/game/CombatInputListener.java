package com.alevat.spaceinvaders.game;

class CombatInputListener extends GameStateInputListenerAdapter {

    private final CombatState combatState;
    private boolean leftPressed;
    private boolean rightPressed;

    CombatInputListener(CombatState combatState) {
        this.combatState = combatState;
    }

    @Override
    public void leftPressed() {
        combatState.getPlayerCannon().setDirection(HorizontalDirection.LEFT);
    }

    @Override
    public void leftReleased() {
        combatState.getPlayerCannon().setDirection(HorizontalDirection.STILL);
    }

    @Override
    public void rightPressed() {
        combatState.getPlayerCannon().setDirection(HorizontalDirection.RIGHT);
    }

    @Override
    public void rightReleased() {
        combatState.getPlayerCannon().setDirection(HorizontalDirection.STILL);
    }

    @Override
    GameState getGameState() {
        return combatState;
    }
}
