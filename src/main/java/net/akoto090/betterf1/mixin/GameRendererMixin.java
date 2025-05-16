package net.akoto090.betterf1.mixin;

import net.akoto090.betterf1.BetterF1Mod;
import net.akoto090.betterf1.HudState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Options;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Shadow @Final
    private Minecraft minecraft;

    @Inject(method = "renderLevel", at = @At("HEAD"))
    private void onRenderLevelHead(float partialTicks, long nanoTime, PoseStack poseStack, CallbackInfo ci) {
        if (BetterF1Mod.state.equals(HudState.NO_HUD)) {
            minecraft.options.hideGui = false;
        }
    }

    @Inject(method = "renderLevel", at = @At("TAIL"))
    private void onRenderLevelTail(float partialTicks, long nanoTime, PoseStack poseStack, CallbackInfo ci) {
        if (BetterF1Mod.state.equals(HudState.NO_HUD)) {
            minecraft.options.hideGui = true;
        }
    }
}
