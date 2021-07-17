package yatchan.rusticlite.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import yatchan.rusticlite.block.RLBlocks;

public class RLItemGroup {
    public static final ItemGroup TAB_RUSTIC_LITE_BUILDING_BLOCKS = new ItemGroup("rustic_lite_building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RLBlocks.IRONWOOD_LOG.get());
        }
    };
}
