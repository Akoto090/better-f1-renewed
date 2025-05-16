package net.akoto090.betterf1.mixin;

import net.akoto090.betterf1.BetterF1Mod;
import net.akoto090.betterf1.HudState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.KeyboardHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyboardHandler.class)
public class KeyboardMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "keyPress", at = @At("HEAD"), cancellable = true)
    private void onKeyPress(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci) {
        if (key == 292 && action == 1) { // GLFW_KEY_F1 = 292
            BetterF1Mod.state = BetterF1Mod.state.next();
            Options options = minecraft.options;
            options.hideGui = !BetterF1Mod.state.equals(HudState.ALL_VISIBLE);
            ci.cancel();
            // Optionally add logging here
        }
    }
}
