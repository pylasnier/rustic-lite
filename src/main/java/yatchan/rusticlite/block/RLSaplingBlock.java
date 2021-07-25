package yatchan.rusticlite.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;

public class RLSaplingBlock extends SaplingBlock {

    public RLSaplingBlock(Tree tree) {
        super(tree, AbstractBlock.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS));
    }

    public RLSaplingBlock(Tree tree, Properties properties) {
        super(tree, properties);
    }

}
