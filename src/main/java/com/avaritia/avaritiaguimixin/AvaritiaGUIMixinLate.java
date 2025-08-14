package com.avaritia.avaritiaguimixin;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

public class AvaritiaGUIMixinLate implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.avaritiaguimixin.late.json");
    }

}
