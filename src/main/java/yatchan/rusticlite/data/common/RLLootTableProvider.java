package yatchan.rusticlite.data.common;

import java.rmi.registry.Registry;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.block.RLLeavesBlock;
import yatchan.rusticlite.block.RLSaplingBlock;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;

public class RLLootTableProvider extends LootTableProvider {
    public RLLootTableProvider(DataGenerator generator) {
        super(generator);
    }
    
    @Override
    protected java.util.List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
            // Here, every set of loot tables must be declared. Each type of loot table
            // is given in LootParameterSets.
            Pair.of(RLBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    // Needs to be overriden to remove the check for vanilla loot tables, because we don't have them.
    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationTracker) {
        map.forEach((resourceLocation, lootTable) -> LootTableManager.validate(validationTracker, resourceLocation, lootTable));
    }

    public static class RLBlockLootTables extends BlockLootTables {

        // Here, all block loot tables are registered
        @Override
        protected void addTables() {
            dropSelf(RLBlocks.COPPER_ORE);
            dropSelf(RLBlocks.COPPER_BLOCK);

            dropSelf(RLBlocks.IRONWOOD_LOG);
            dropSelf(RLBlocks.OLIVE_LOG);

            dropSelf(RLBlocks.IRONWOOD_PLANKS);
            dropSelf(RLBlocks.OLIVE_PLANKS);

            leavesDrop(RLBlocks.IRONWOOD_LEAVES, RLBlocks.IRONWOOD_SAPLING);
            leavesDrop(RLBlocks.OLIVE_LEAVES, RLBlocks.OLIVE_SAPLING);

            dropSelf(RLBlocks.IRONWOOD_SAPLING);
            dropSelf(RLBlocks.OLIVE_SAPLING);
        }

        // This needs to be overriden to match the blocks of Rustic Lite instead of vanilla
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return RLBlocks.BLOCKS.getEntries().stream().map(RegistryObject<Block>::get).collect(Collectors.toList());
        }

        // Helper methods allow using RegistryObject, also copying normal leaves sapling chance,
        // because it's private in BlockLootTables. idk why, really sucks
        private <T extends Block> void dropSelf(RegistryObject<T> blockHandle) {
            dropSelf(blockHandle.get());
        }

        private void leavesDrop(RegistryObject<RLLeavesBlock> leavesHandle, RegistryObject<RLSaplingBlock> saplingHandle) {
            add(leavesHandle.get(), (leavesBlock) -> { return createLeavesDrops(leavesBlock, saplingHandle.get(), new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F}); });
        }
    }
}
