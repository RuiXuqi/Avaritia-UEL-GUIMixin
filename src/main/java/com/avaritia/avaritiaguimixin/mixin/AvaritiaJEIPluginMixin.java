package com.avaritia.avaritiaguimixin.mixin;

import com.avaritia.avaritiaguimixin.AvaritiaGUIMixinConfig;
import morph.avaritia.compat.jei.AvaritiaJEIPlugin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = AvaritiaJEIPlugin.class, remap = false)
public class AvaritiaJEIPluginMixin {
    @ModifyArgs(
            method = "register",
            at = @At(
                    value = "INVOKE",
                    target = "Lmezz/jei/api/IModRegistry;addRecipeClickArea(Ljava/lang/Class;IIII[Ljava/lang/String;)V",
                    ordinal = 0
            )
    )
    private void modifyAddRecipeClickArea(Args args) {
        args.set(2, 79);
        args.set(3, 28);
    }

    @ModifyArgs(
            method = "setupDrawables",
            at = @At(
                    value = "INVOKE",
                    target = "Lmezz/jei/api/IGuiHelper;createDrawable(Lnet/minecraft/util/ResourceLocation;IIII)Lmezz/jei/api/gui/IDrawableStatic;",
                    ordinal = 0
            )
    )
    private static void modifyCreateDrawable(Args args) {
        args.set(3, 189);
        args.set(4, 163);
    }

    @ModifyArg(
            method = "setupDrawables",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/ResourceLocation;<init>(Ljava/lang/String;)V",
                    ordinal = 0
            )
    )
    private static String ResourceLocation(String resourceName) {
        return AvaritiaGUIMixinConfig.useBuiltinDireJEITexture ? "avaritiaguimixin:textures/gui/extreme_jei.png" : "avaritia:textures/gui/extreme_jei.png";
    }

}
