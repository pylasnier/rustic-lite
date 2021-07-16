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
    }

    private Builder<Block> addToTag(INamedTag<Block> tag, RegistryObject<Block> blockHandle) {
        return tag(tag).add(blockHandle.get());
    }
}
