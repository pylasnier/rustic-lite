package yatchan.rusticlite.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.item.RLItems;

public class RLItemGroup {
    public static final ItemGroup TAB_RUSTICLITE_BUILDING_BLOCKS = new ItemGroup("rusticlite_building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RLBlocks.COPPER_BLOCK.get());
        }
    };

    public static final ItemGroup TAB_RUSTICLITE_MATERIALS = new ItemGroup("rusticlite_materials") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(RLItems.COPPER.get());
        }
    };
}