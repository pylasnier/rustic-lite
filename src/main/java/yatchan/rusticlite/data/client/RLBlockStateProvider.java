package yatchan.rusticlite.data.client;

import java.rmi.registry.Registry;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.block.RLLogBlock;

public class RLBlockStateProvider extends BlockStateProvider {
    public RLBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, RusticLite.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(RLBlocks.COPPER_ORE);
        simpleBlock(RLBlocks.COPPER_BLOCK);

        logBlock(RLBlocks.IRONWOOD_LOG);
        logBlock(RLBlocks.OLIVE_LOG);

        simpleBlock(RLBlocks.IRONWOOD_PLANKS);
        simpleBlock(RLBlocks.OLIVE_PLANKS);

        simpleBlock(RLBlocks.IRONWOOD_LEAVES);
        simpleBlock(RLBlocks.OLIVE_LEAVES);

        simpleCross(RLBlocks.IRONWOOD_SAPLING);
        simpleCross(RLBlocks.OLIVE_SAPLING);
    }

    // For consistency's sake with RLItemModelProvider; it's just nicer.
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
}
