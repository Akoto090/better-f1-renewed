package net.akoto090.betterf1.mixin;

import net.akoto090.betterf1.BetterF1Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardHandlerMixin {
    @Inject(
            method = "keyPress",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onKeyPress(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (key == 292 && BetterF1Mod.toggleHudKey != null) {
            ci.cancel();
        }
    }
}