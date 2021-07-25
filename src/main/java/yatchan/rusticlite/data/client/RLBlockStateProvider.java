package yatchan.rusticlite.data.client;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.block.RLLeavesBlock;
import yatchan.rusticlite.block.RLLogBlock;

public class RLBlockStateProvider extends BlockStateProvider {
    public RLBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RusticLite.MODID, existingFileHelper);
    }

    // Every block must be registered, preferably through appropriate helper methods.
    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RLBlocks.COPPER_ORE);
        simpleBlock(RLBlocks.COPPER_BLOCK);

        logBlock(RLBlocks.IRONWOOD_LOG);
        logBlock(RLBlocks.OLIVE_LOG);

        simpleBlock(RLBlocks.IRONWOOD_PLANKS);
        simpleBlock(RLBlocks.OLIVE_PLANKS);

        coloredLeavesBlock(RLBlocks.IRONWOOD_LEAVES);
        coloredLeavesBlock(RLBlocks.OLIVE_LEAVES);

        simpleCross(RLBlocks.IRONWOOD_SAPLING);
        simpleCross(RLBlocks.OLIVE_SAPLING);
    }

    // Helper methods, first two just take RegistryObject to make passing them nicer.
    private <T extends Block> void simpleBlock(RegistryObject<T> blockHandle) {
        simpleBlock(blockHandle.get());
    }

    private void logBlock(RegistryObject<RLLogBlock> blockHandle) {
        logBlock(blockHandle.get());
    }

    private <T extends Block> void simpleCross(RegistryObject<T> blockHandle) {
        String blockName = blockHandle.get().getRegistryName().getPath();
        simpleBlock(blockHandle.get(), models().cross(blockName, modLoc("block/" + blockName)));
    }

    // Need this specifically to allow the leaves blocks to be tinted, by setting each face tintIndex to not -1
    private void coloredLeavesBlock(RegistryObject<RLLeavesBlock> blockHandle) {
        String blockName = blockHandle.get().getRegistryName().getPath();

        // Copying BlockStateProvider#cubeAll because it returns ModelFile instead of ModelProvider for some reason,
        // so element method isn't accessible
        BlockModelBuilder modelBuilder = models().cubeAll(blockName, modLoc("block/" + blockName));

        // Because element() returns a new element builder instead of the model builder, must be used separately
        modelBuilder.element().allFaces((direction, faceBuilder) -> { faceBuilder.tintindex(0).texture("#all"); });

        simpleBlock(blockHandle.get(), modelBuilder);
    }
}
