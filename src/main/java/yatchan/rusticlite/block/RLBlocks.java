package yatchan.rusticlite.block;

import java.rmi.registry.Registry;
import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.item.RLItems;
import yatchan.rusticlite.setup.RLItemGroup;

public class RLBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RusticLite.MODID);

    private static <T extends Block> RegistryObject<T> registerWithoutItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, ItemGroup tab) {
        RegistryObject<T> result = registerWithoutItem(name, block);
        RLItems.ITEMS.register(name, () -> new BlockItem(result.get(), new Item.Properties().tab(tab)));

        return result;
    }

    // Blocks
    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () -> new Block(AbstractBlock.Properties.of(Material.STONE).strength(5.0f, 6.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops()), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL).sound(SoundType.METAL).strength(7.0f, 8.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<RotatedPillarBlock> IRONWOOD_LOG = register("ironwood_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).harvestLevel(1).harvestTool(ToolType.AXE)), RLItemGroup.TAB_RUSTIC_LITE_BUILDING_BLOCKS);

    
    // Helper methods
}
