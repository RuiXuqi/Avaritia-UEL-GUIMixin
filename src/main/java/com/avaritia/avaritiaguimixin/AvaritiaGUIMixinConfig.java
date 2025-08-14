package com.avaritia.avaritiaguimixin;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Tags.MOD_ID)
@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class AvaritiaGUIMixinConfig {
    @Config.Comment({
            "Use built-in dire crafting GUI textures.",
            "If you want to use a resource pack, disable it."
    })
    @Config.RequiresMcRestart
    @Config.Name("Use Builtin Dire GUI Texture")
    public static boolean useBuiltinDireGUITexture = true;

    @Config.Comment({
            "Use built-in dire crafting JEI textures.",
            "If you want to use a resource pack, disable it."
    })
    @Config.RequiresMcRestart
    @Config.Name("Use Builtin Dire JEI Texture")
    public static boolean useBuiltinDireJEITexture = true;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Tags.MOD_ID)) {
            ConfigManager.sync(Tags.MOD_ID, Config.Type.INSTANCE);
        }
    }

}
