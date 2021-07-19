package yatchan.rusticlite.block;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;

public class RLLeavesBlock extends LeavesBlock {
    public RLLeavesBlock() {
        super(Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn((a, b, c, entityType) -> entityType == EntityType.OCELOT || entityType == EntityType.PARROT).isSuffocating((a, b, c) -> false).isViewBlocking((a, b, c) -> false));
    }

    public RLLeavesBlock(Properties properties) {
        super(properties);
    }
    
}
