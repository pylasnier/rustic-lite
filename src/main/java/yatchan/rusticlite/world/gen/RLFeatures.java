package yatchan.rusticlite.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpread;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.TwoLayerFeature;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import yatchan.rusticlite.block.RLBlocks;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;

public class RLFeatures {

    // Register trees. Tree configuration takes log type (particularly default i.e. vertical, log block state), leaves type,
    // foliage placer, and trunk placer (both of which can be custom).
    // Custom tree classes need to be able to select one of these in overridden Tree#getConfiguredFeature
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> IRONWOOD = register("ironwood", Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(RLBlocks.IRONWOOD_LOG.get().defaultBlockState()), new SimpleBlockStateProvider(RLBlocks.IRONWOOD_LEAVES.get().defaultBlockState()), new RLIronwoodFoliagePlacer(FeatureSpread.fixed(3), FeatureSpread.fixed(0)), new StraightTrunkPlacer(5, 2, 0), new TwoLayerFeature(1, 0, 1)).ignoreVines().build()));
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> OLIVE = register("olive", Feature.TREE.configured(new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(RLBlocks.OLIVE_LOG.get().defaultBlockState()), new SimpleBlockStateProvider(RLBlocks.OLIVE_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(FeatureSpread.fixed(2), FeatureSpread.fixed(0), 3), new StraightTrunkPlacer(4, 2, 0), new TwoLayerFeature(1, 0, 1)).ignoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, id, configuredFeature);
    }
}
