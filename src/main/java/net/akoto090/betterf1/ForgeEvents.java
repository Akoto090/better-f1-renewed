package net.akoto090.betterf1;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterF1Mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEvents {

    @SubscribeEvent
    public static void onRenderGuiOverlay(RenderGuiOverlayEvent.Pre event) {
        if (BetterF1Mod.state == HudState.HUD_ONLY_HIDDEN || BetterF1Mod.state == HudState.ALL_HIDDEN) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        if (BetterF1Mod.state == HudState.ALL_HIDDEN) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft.getInstance().options.hideGui = false;

            if (BetterF1Mod.toggleHudKey != null) {
                while (BetterF1Mod.toggleHudKey.consumeClick()) {
                    BetterF1Mod.state = BetterF1Mod.state.next();
                }
            }
        }
    }
}