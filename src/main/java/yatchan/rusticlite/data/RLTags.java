package yatchan.rusticlite.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraft.util.ResourceLocation;

public class RLTags {
    public static final class Blocks {
        public static final INamedTag<Block> ORES_COPPER = forgeTag("ores/copper");
        public static final INamedTag<Block> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");

        private static INamedTag<Block> mcTag(String path) {
            return BlockTags.bind(new ResourceLocation("minecraft", path).toString());
        }

        private static INamedTag<Block> forgeTag(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }
    }

    public static final class Items {
        public static final INamedTag<Item> INGOTS_COPPER = forgeTag("ingots/copper");

        public static final INamedTag<Item> ORES_COPPER = forgeTag("ores/copper");
        public static final INamedTag<Item> STORAGE_BLOCKS_COPPER = forgeTag("storage_blocks/copper");

        private static INamedTag<Item> mcTag(String path) {
            return ItemTags.bind(new ResourceLocation("minecraft", path).toString());
        }

        private static INamedTag<Item> forgeTag(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }
    }
}
