package net.akoto090.betterf1;

public enum HudState {
    ALL_VISIBLE,
    HUD_ONLY_HIDDEN,
    ALL_HIDDEN;

    public HudState next() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}