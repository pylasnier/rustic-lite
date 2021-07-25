package yatchan.rusticlite.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import yatchan.rusticlite.block.RLBlocks;

public class RLItemGroup {
    
    // Creative mode tab groups are defined here as ItemGroup constants

    public static final ItemGroup TAB_RUSTICLITE_BUILDING_BLOCKS = new ItemGroup("rusticlite_building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RLBlocks.IRONWOOD_LOG.get());
        }
    };
}
