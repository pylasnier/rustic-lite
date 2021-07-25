package yatchan.rusticlite.data.client;

import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.item.RLItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class RLItemModelProvider extends ItemModelProvider {
    public RLItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RusticLite.MODID, existingFileHelper);
    }
    
    // Every block must be registered, preferably through appropriate helper methods.
    @Override
    protected void registerModels() {
        generatedItem(RLItems.COPPER);

        blockItem(RLBlocks.COPPER_ORE);
        blockItem(RLBlocks.COPPER_BLOCK);

        blockItem(RLBlocks.IRONWOOD_LOG);
        blockItem(RLBlocks.OLIVE_LOG);

        blockItem(RLBlocks.IRONWOOD_PLANKS);
        blockItem(RLBlocks.OLIVE_PLANKS);

        blockItem(RLBlocks.IRONWOOD_LEAVES);
        blockItem(RLBlocks.OLIVE_LEAVES);

        generatedBlockItem(RLBlocks.IRONWOOD_SAPLING);
        generatedBlockItem(RLBlocks.OLIVE_SAPLING);
    }

    // Helper methods, first two just take RegistryObject to make passing them nicer.
    private <T extends Block> ItemModelBuilder blockItem(RegistryObject<T> blockHandle) {
        String blockName = blockHandle.get().getRegistryName().getPath();
        return withExistingParent(blockName, modLoc("block/" + blockName));
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> itemHandle) {
        String itemName = itemHandle.get().getRegistryName().getPath();
        return withExistingParent(itemName, mcLoc("item/generated")).texture("layer0", "item/" + itemName);
    }

    // Specifically for block items which don't use the block model as the item model, instead
    // using the texture as a flat item model e.g. saplings
    private <T extends Block> ItemModelBuilder generatedBlockItem(RegistryObject<T> blockHandle) {
        String blockName = blockHandle.get().getRegistryName().getPath();
        return withExistingParent(blockName, mcLoc("item/generated")).texture("layer0", "block/" + blockName);
    }
}