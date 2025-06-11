package net.rilith.dungeons_and_dwarves;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rilith.dungeons_and_dwarves.entity.ModEntities;
import net.rilith.dungeons_and_dwarves.entity.DwarfEntity;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DungeonsAndDwarves.MOD_ID)
public class DungeonsAndDwarves
{
    public static final String MOD_ID = "dungeons_and_dwarves";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DungeonsAndDwarves()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            net.minecraft.world.entity.SpawnPlacements.register(
                    ModEntities.DWARF.get(),
                    net.minecraft.world.entity.SpawnPlacements.Type.ON_GROUND,
                    net.minecraft.world.level.levelgen.Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    DwarfEntity::canSpawn);
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
