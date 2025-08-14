package com.avaritia.avaritiaguimixin.mixin;

import morph.avaritia.compat.jei.extreme.ExtremeCraftingCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = ExtremeCraftingCategory.class, remap = false)
public class ExtremeCraftingCategoryMixin {
    @ModifyArgs(
            method = "setRecipe*",
            at = @At(
                    value = "INVOKE",
                    target = "Lmezz/jei/api/gui/IGuiItemStackGroup;init(IZII)V",
                    ordinal = 0
            )
    )
    private static void modifyCreateDrawable(Args args) {
        args.set(2, 167);
        args.set(3, 73);
    }

}
