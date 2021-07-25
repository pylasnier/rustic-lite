package yatchan.rusticlite.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.ResourceLocation;

public class RLTags {

    // All custom tags for block are generated here. Mostly for forge mod compat
    public static final class Blocks {
        
        public static final INamedTag<Block> ORES_COPPER = forgeTag("ores/copper");
        public static final INamedTag<Block> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");

        public static final INamedTag<Block> LOGS_IRONWOOD = mcTag("logs/logs_that_burn/ironwood_logs");
        public static final INamedTag<Block> LOGS_OLIVE = mcTag("logs/logs_that_burn/olive_logs");

        // Helper methods to make generating tags easier
        private static INamedTag<Block> mcTag(String path) {
            return BlockTags.bind(new ResourceLocation("minecraft", path).toString());
        }

        private static INamedTag<Block> forgeTag(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }
    }

    // All custom tags for blocks items corresponding to each block tag above are generated here,
    // and custom item tags.
    public static final class Items {

        public static final INamedTag<Item> INGOTS_COPPER = forgeTag("ingots/copper");

        public static final INamedTag<Item> ORES_COPPER = forgeTag("ores/copper");
        public static final INamedTag<Item> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");

        public static final INamedTag<Item> LOGS_IRONWOOD = mcTag("logs/logs_that_burn/ironwood_logs");
        public static final INamedTag<Item> LOGS_OLIVE = mcTag("logs/logs_that_burn/olive_logs");

        // Helper methods to make generating tags easier
        private static INamedTag<Item> mcTag(String path) {
            return ItemTags.bind(new ResourceLocation("minecraft", path).toString());
        }

        private static INamedTag<Item> forgeTag(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }
    }
}
