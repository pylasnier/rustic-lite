package yatchan.rusticlite.world.gen;

import java.util.Random;
import java.util.Set;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class RLIronwoodFoliagePlacer extends FoliagePlacer {
    public static final Codec<RLIronwoodFoliagePlacer> CODEC = RecordCodecBuilder.create((foliagePlacerInstance) -> {
        return foliagePlacerParts(foliagePlacerInstance).apply(foliagePlacerInstance, RLIronwoodFoliagePlacer::new);
    });

    public RLIronwoodFoliagePlacer(FeatureSpread radius, FeatureSpread offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return RLFoliagePlacerType.IRONWOOD_FOLIAGE_PLACER;
    }

    @Override
    protected void createFoliage(IWorldGenerationReader worldGenReader, Random random, BaseTreeFeatureConfig config, int unknown, Foliage foliage, int foliageHeight, int radius, Set<BlockPos> blockSet, int treeTopHeight, MutableBoundingBox mutableBoundingBox) {
        int radiusOffset = foliage.radiusOffset();
        Boolean doubleTrunk = foliage.doubleTrunk();
        BlockPos foliagePos = foliage.foliagePos().above(1);

        for (int i = 0; i < foliageHeight; i++) {
            int layerRadius = Math.min(foliageHeight - i, radius + radiusOffset);
            placeLeavesRow(worldGenReader, random, config, foliagePos, layerRadius, blockSet, treeTopHeight - foliageHeight + i, doubleTrunk, mutableBoundingBox);
        }
    }

    @Override
    public int foliageHeight(Random p_230374_1_, int p_230374_2_, BaseTreeFeatureConfig p_230374_3_) {
        return 4;
    }

    @Override
    protected boolean shouldSkipLocation(Random random, int x, int y, int z, int radius, boolean doubleTrunk) {
        return x * x + z * z > radius * radius || x > 2 || z > 2 || x == 2 && z == 2 && random.nextInt(2) == 1;
    }
    
}
