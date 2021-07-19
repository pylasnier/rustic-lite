package yatchan.rusticlite.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class RLPlanksBlock extends Block {
    public RLPlanksBlock() {
        super(Properties.of(Material.WOOD).strength(2.0f, 3.0f).sound(SoundType.WOOD));
    }
    
    public RLPlanksBlock(Properties properties) {
        super(properties);
    }
    
}
