package com.avaritia.avaritiaguimixin.mixin;

import morph.avaritia.container.ContainerExtremeCrafting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = ContainerExtremeCrafting.class, remap = false)
public class ContainerExtremeCraftingMixin {
    @ModifyArgs(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/inventory/Slot;<init>(Lnet/minecraft/inventory/IInventory;III)V",
                    ordinal = 1
            )
    )
    private void modifyInvSlots(Args args) {
        int x = args.get(2);
        args.set(2, x + 27);
    }

    @ModifyArgs(
            method = "<init>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/inventory/Slot;<init>(Lnet/minecraft/inventory/IInventory;III)V",
                    ordinal = 2
            )
    )
    private void modifyBarSlots(Args args) {
        int x = args.get(2);
        args.set(2, x + 27);
    }

}
