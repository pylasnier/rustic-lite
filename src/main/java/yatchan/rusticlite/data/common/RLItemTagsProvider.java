package yatchan.rusticlite.data.common;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag.INamedTag;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.data.RLTags;
import yatchan.rusticlite.item.RLItems;

public class RLItemTagsProvider extends ItemTagsProvider {

    public RLItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, RusticLite.MODID, existingFileHelper);
    }
    
    @Override
    protected void addTags() {
        addToTag(RLTags.Items.INGOTS_COPPER, RLItems.COPPER);

        copy(RLTags.Blocks.ORES_COPPER, RLTags.Items.ORES_COPPER);
        copy(RLTags.Blocks.STORAGE_BLOCKS_COPPER, RLTags.Items.STORAGE_BLOCKS_COPPER);

        copy(RLTags.Blocks.LOGS_IRONWOOD, RLTags.Items.LOGS_IRONWOOD);
        copy(RLTags.Blocks.LOGS_OLIVE, RLTags.Items.LOGS_OLIVE);

        copy(RLTags.Blocks.PLANKS, RLTags.Items.PLANKS);
        copy(RLTags.Blocks.LEAVES, RLTags.Items.LEAVES);
    }

    private Builder<Item> addToTag(INamedTag<Item> tag, RegistryObject<Item> blockHandle) {
        return tag(tag).add(blockHandle.get());
    }
}
