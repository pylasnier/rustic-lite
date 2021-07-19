package yatchan.rusticlite.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RLLogBlock extends RotatedPillarBlock {

    public RLLogBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD));
    }

    public RLLogBlock(AbstractBlock.Properties properties) {
        super(properties);
    }
}
