package yatchan.rusticlite.data.common;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.data.RLTags;
import yatchan.rusticlite.item.RLItems;

public class RLItemTagsProvider extends ItemTagsProvider {

    public RLItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, RusticLite.MODID, existingFileHelper);
    }
    
    // All block tags that are set (i.e. custom tags defined, pre-existing tags modified) must be
    // copied here, and item tags are set here much like block tags, so add items to tags and
    // custom tags to their pre-existing parent tags.
    @Override
    protected void addTags() {
        addTagToTag(Tags.Items.INGOTS, RLTags.Items.INGOTS_COPPER);
        addItemToTag(RLTags.Items.INGOTS_COPPER, RLItems.COPPER);

        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(RLTags.Blocks.ORES_COPPER, RLTags.Items.ORES_COPPER);
        copy(RLTags.Blocks.STORAGE_BLOCKS_COPPER, RLTags.Items.STORAGE_BLOCKS_COPPER);

        copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        copy(RLTags.Blocks.LOGS_IRONWOOD, RLTags.Items.LOGS_IRONWOOD);
        copy(RLTags.Blocks.LOGS_OLIVE, RLTags.Items.LOGS_OLIVE);

        copy(BlockTags.PLANKS, ItemTags.PLANKS);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);
        copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
    }

    // Helper methods to add block to tag, or custom tag to pre-existing or other custom tags
    private Builder<Item> addItemToTag(INamedTag<Item> tag, RegistryObject<Item> blockHandle) {
        return tag(tag).add(blockHandle.get());
    }

    private Builder<?> addTagToTag(INamedTag<Item> parentTag, INamedTag<Item> childTag) {
        return tag(parentTag).addTag(childTag);
    }
}
