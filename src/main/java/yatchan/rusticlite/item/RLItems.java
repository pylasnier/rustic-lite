package yatchan.rusticlite.item;

import java.util.function.Supplier;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import yatchan.rusticlite.RusticLite;

public class RLItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RusticLite.MODID);

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }

    // ITEMS
    // Item.Properties gives item properties e.g. edible, using method chaining property setters.
    // Construction slightly different to block properties for some reason
    
    public static final RegistryObject<Item> COPPER = register("copper", () -> new Item(new Item.Properties().food(new Food.Builder().alwaysEat().build()).tab(ItemGroup.TAB_MATERIALS)));
}