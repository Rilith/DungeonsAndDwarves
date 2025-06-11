package net.rilith.dungeons_and_dwarves.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rilith.dungeons_and_dwarves.DungeonsAndDwarves;

import java.util.Random;

@Mod.EventBusSubscriber(modid = DungeonsAndDwarves.MOD_ID)
public class DwarfWorldGen {
    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        LevelAccessor level = event.getLevel();
        long seed = level instanceof net.minecraft.server.level.ServerLevel lvl ? lvl.getSeed() : 0L;
        Random random = new Random(seed);
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(1000) - 500;
            int z = random.nextInt(1000) - 500;
            int y = level.getMinBuildHeight() + random.nextInt(40);
            BlockPos pos = new BlockPos(x, y, z);
            buildSimpleHouse(level, pos);
        }
    }

    private static void buildSimpleHouse(LevelAccessor level, BlockPos origin) {
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 2; y++) {
                for (int z = 0; z <= 2; z++) {
                    BlockPos target = origin.offset(x, y, z);
                    level.setBlock(target, Blocks.STONE_BRICKS.defaultBlockState(), 2);
                }
            }
        }
        for (int x = -1; x <= 1; x++) {
            for (int y = 1; y <= 2; y++) {
                BlockPos target = origin.offset(x, y, 1);
                level.setBlock(target, Blocks.AIR.defaultBlockState(), 2);
            }
        }
        level.setBlock(origin.offset(0, 1, 0), Blocks.AIR.defaultBlockState(), 2);
        level.setBlock(origin.offset(0, 2, 0), Blocks.AIR.defaultBlockState(), 2);
    }
}
