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
        leftPressed = true;
        setPlayerCannonDirection();
    }

    @Override
    public void leftReleased() {
        leftPressed = false;
        setPlayerCannonDirection();
    }

    @Override
    public void rightPressed() {
        rightPressed = true;
        setPlayerCannonDirection();
    }

    @Override
    public void rightReleased() {
        rightPressed = false;
        setPlayerCannonDirection();
    }

    @Override
    public void firePressed() {
        combatState.getPlayerCannon().fire();
    }

    private void setPlayerCannonDirection() {
        HorizontalDirection direction = HorizontalDirection.STILL;
        if (leftPressed && !rightPressed) {
            direction = HorizontalDirection.LEFT;
        }
        if (rightPressed && !leftPressed) {
            direction = HorizontalDirection.RIGHT;
        }
        combatState.getPlayerCannon().setDirection(direction);
    }

    @Override
    GameState getGameState() {
        return combatState;
    }
}
