package com.avaritia.avaritiaguimixin.mixin;

import com.avaritia.avaritiaguimixin.AvaritiaGUIMixinConfig;
import morph.avaritia.client.gui.GUIExtremeCrafting;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = GUIExtremeCrafting.class, remap = false)
public class GuiExtremeCraftingMixin {
    @ModifyArg(
            method = "drawGuiContainerForegroundLayer",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/FontRenderer;drawString(Ljava/lang/String;III)I",
                    ordinal = 2
            ),
            index = 2
    )
    private int modifyDrawString(int y) {
        return y - 35; // this.ySize - 96 + 2
    }

    @SuppressWarnings("unused")
    @Shadow
    @Mutable
    private static final ResourceLocation GUI_TEX = AvaritiaGUIMixinConfig.useBuiltinDireGUITexture ?
            new ResourceLocation("avaritiaguimixin", "textures/gui/dire_crafting_gui.png") :
            new ResourceLocation("avaritia", "textures/gui/dire_crafting_gui.png");

}
