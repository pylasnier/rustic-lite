package yatchan.rusticlite.data.common;

import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        addToTag(RLTags.Blocks.ORES_COPPER, RLBlocks.COPPER_ORE);
        addToTag(RLTags.Blocks.STORAGE_BLOCKS_COPPER, RLBlocks.COPPER_BLOCK);

        addToTag(RLTags.Blocks.LOGS_IRONWOOD, RLBlocks.IRONWOOD_LOG);
        addToTag(RLTags.Blocks.LOGS_OLIVE, RLBlocks.OLIVE_LOG);

        addToTag(RLTags.Blocks.PLANKS, RLBlocks.IRONWOOD_PLANKS);
        addToTag(RLTags.Blocks.PLANKS, RLBlocks.OLIVE_PLANKS);

        addToTag(RLTags.Blocks.LEAVES, RLBlocks.IRONWOOD_LEAVES);
        addToTag(RLTags.Blocks.LEAVES, RLBlocks.OLIVE_LEAVES);
    }

    private <T extends Block> Builder<Block> addToTag(INamedTag<Block> tag, RegistryObject<T> blockHandle) {
        return tag(tag).add(blockHandle.get());
    }
}
