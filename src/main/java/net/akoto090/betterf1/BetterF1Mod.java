package net.akoto090.betterf1;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(BetterF1Mod.MOD_ID)
public class BetterF1Mod {
    public static final String MOD_ID = "betterf1";
    public static HudState state = HudState.ALL_VISIBLE;
    public static KeyMapping toggleHudKey;

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
            toggleHudKey = new KeyMapping(
                    "key.betterf1.toggle_hud",
                    org.lwjgl.glfw.GLFW.GLFW_KEY_F1,
                    "key.categories.misc"
            );
            event.register(toggleHudKey);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
