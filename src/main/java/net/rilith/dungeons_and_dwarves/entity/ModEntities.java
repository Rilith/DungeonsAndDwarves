package net.rilith.dungeons_and_dwarves.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.npc.Villager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rilith.dungeons_and_dwarves.DungeonsAndDwarves;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DungeonsAndDwarves.MOD_ID);

    public static final RegistryObject<EntityType<DwarfEntity>> DWARF = ENTITIES.register(
            "dwarf",
            () -> EntityType.Builder.<DwarfEntity>of(DwarfEntity::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.4F)
                    .build(new ResourceLocation(DungeonsAndDwarves.MOD_ID, "dwarf").toString()));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
