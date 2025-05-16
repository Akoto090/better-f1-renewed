package net.akoto090.betterf1;

public enum HudState {
    ALL_VISIBLE,
    NO_HUD;

    public HudState next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}