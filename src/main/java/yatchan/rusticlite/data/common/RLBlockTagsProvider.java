package yatchan.rusticlite.data.common;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.data.RLTags;

public class RLBlockTagsProvider extends BlockTagsProvider {

    public RLBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RusticLite.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags() {
        addTagToTag(Tags.Blocks.ORES, RLTags.Blocks.ORES_COPPER);
        addTagToTag(Tags.Blocks.STORAGE_BLOCKS, RLTags.Blocks.STORAGE_BLOCKS_COPPER);
        addBlockToTag(RLTags.Blocks.ORES_COPPER, RLBlocks.COPPER_ORE);
        addBlockToTag(RLTags.Blocks.STORAGE_BLOCKS_COPPER, RLBlocks.COPPER_BLOCK);

        addTagToTag(BlockTags.LOGS_THAT_BURN, RLTags.Blocks.LOGS_IRONWOOD);
        addTagToTag(BlockTags.LOGS_THAT_BURN, RLTags.Blocks.LOGS_OLIVE);
        addBlockToTag(RLTags.Blocks.LOGS_IRONWOOD, RLBlocks.IRONWOOD_LOG);
        addBlockToTag(RLTags.Blocks.LOGS_OLIVE, RLBlocks.OLIVE_LOG);

        addBlockToTag(BlockTags.PLANKS, RLBlocks.IRONWOOD_PLANKS);
        addBlockToTag(BlockTags.PLANKS, RLBlocks.OLIVE_PLANKS);

        addBlockToTag(BlockTags.LEAVES, RLBlocks.IRONWOOD_LEAVES);
        addBlockToTag(BlockTags.LEAVES, RLBlocks.OLIVE_LEAVES);

        addBlockToTag(BlockTags.SAPLINGS, RLBlocks.IRONWOOD_SAPLING);
        addBlockToTag(BlockTags.SAPLINGS, RLBlocks.OLIVE_SAPLING);
    }

    private <T extends Block> Builder<Block> addBlockToTag(INamedTag<Block> tag, RegistryObject<T> blockHandle) {
        return tag(tag).add(blockHandle.get());
    }

    private Builder<?> addTagToTag(INamedTag<Block> parentTag, INamedTag<Block> childTag) {
        return tag(parentTag).addTag(childTag);
    }
}
