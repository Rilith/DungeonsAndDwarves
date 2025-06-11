package net.rilith.dungeons_and_dwarves.entity;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rilith.dungeons_and_dwarves.DungeonsAndDwarves;

@Mod.EventBusSubscriber(modid = DungeonsAndDwarves.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DwarfEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DWARF.get(), DwarfEntity.createAttributes().build());
    }
}
