package yatchan.rusticlite.world.gen;

import com.mojang.serialization.Codec;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;

public class RLFoliagePlacerType<P extends FoliagePlacer> extends FoliagePlacerType<P> {
    // Register custom foliage placers. Custom foliage placer classes need to be able to give one of these
    // as their type. Don't quite know why this is necessary, who looks for foliage placers other than the
    // foliage places classes themselves?
    public static final RLFoliagePlacerType<RLIronwoodFoliagePlacer> IRONWOOD_FOLIAGE_PLACER = register("ironwood_foliage_placer", RLIronwoodFoliagePlacer.CODEC);

    public RLFoliagePlacerType(Codec<P> codec) {
        super(codec);
    }
    
    private static <P extends FoliagePlacer> RLFoliagePlacerType<P> register(String id, Codec<P> codec) {
        return Registry.register(Registry.FOLIAGE_PLACER_TYPES, id, new RLFoliagePlacerType<>(codec));
    }
}
