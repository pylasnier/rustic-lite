package yatchan.rusticlite.data.client;

import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.block.RLBlocks;

public class RLBlockStateProvider extends BlockStateProvider {
    public RLBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RusticLite.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RLBlocks.COPPER_ORE);
        simpleBlock(RLBlocks.COPPER_BLOCK);
        logBlock(RLBlocks.IRONWOOD_LOG);
    }

    // For consistency's sake with RLItemModelProvider; it's just nicer.
    private void simpleBlock(RegistryObject<Block> blockHandle) {
        simpleBlock(blockHandle.get());
    }

    private void logBlock(RegistryObject<RotatedPillarBlock> blockHandle) {
        logBlock(blockHandle.get());
    }
}
