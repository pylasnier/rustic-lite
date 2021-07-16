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
    
    @Override
    protected void registerModels() {
        generatedItem(RLItems.COPPER);

        blockItem(RLBlocks.COPPER_ORE);
        blockItem(RLBlocks.COPPER_BLOCK);
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> blockHandle) {
        String blockName = blockHandle.get().getRegistryName().getPath();
        return withExistingParent(blockName, modLoc("block/" + blockName));
    }

    private ItemModelBuilder generatedItem(RegistryObject<Item> itemHandle) {
        String itemName = itemHandle.get().getRegistryName().getPath();
        return withExistingParent(itemName, mcLoc("item/generated")).texture("layer0", "item/" + itemName);
    }
}