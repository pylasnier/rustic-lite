package yatchan.rusticlite.data.common;

import java.util.function.Consumer;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.IForgeRegistryEntry;
import yatchan.rusticlite.block.RLBlocks;
import yatchan.rusticlite.block.RLPlanksBlock;
import yatchan.rusticlite.data.RLTags;
import yatchan.rusticlite.item.RLItems;

public class RLRecipeProvider extends RecipeProvider {

    public RLRecipeProvider(DataGenerator generator) {
        super(generator);
    }
    
    // Registers recipes. Method name really dumb, change pls
    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        blockShape(consumer, RLItems.COPPER, RLBlocks.COPPER_BLOCK);
        blockToComponent(consumer, RLBlocks.COPPER_BLOCK, RLItems.COPPER);

        blastingSmelting(consumer, RLBlocks.COPPER_ORE, RLItems.COPPER, 0.7f, 200);

        planksFromLog(consumer, RLBlocks.IRONWOOD_PLANKS, RLTags.Items.LOGS_IRONWOOD);
        planksFromLog(consumer, RLBlocks.OLIVE_PLANKS, RLTags.Items.LOGS_OLIVE);
    }

    // Recipe helper methods
    // Funky interface generics to be able to pass either RegistryObject<Block> or RegistryObject<Item>.
    // Block and Item both implementing IItemProvider means either can be used just fine for recipes.

    // Simplified smelting
    private static <T extends IForgeRegistryEntry<? super T> & IItemProvider, E extends IForgeRegistryEntry<? super E> & IItemProvider>
     void genericSmelting(Consumer<IFinishedRecipe> consumer, RegistryObject<T> ingredient, RegistryObject<E> result, float experience, int time) {
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, time).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer);
    }

    private static <T extends IForgeRegistryEntry<? super T> & IItemProvider, E extends IForgeRegistryEntry<? super E> & IItemProvider>
     void blastingSmelting(Consumer<IFinishedRecipe> consumer, RegistryObject<T> ingredient, RegistryObject<E> result, float experience, int time) {
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, time).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer, result.get().getRegistryName() + "_from_smelting");
        CookingRecipeBuilder.blasting(Ingredient.of(ingredient.get()), result.get(), experience, time / 2).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer, result.get().getRegistryName() + "_from_blasting");
    }

    private static <T extends IForgeRegistryEntry<? super T> & IItemProvider, E extends IForgeRegistryEntry<? super E> & IItemProvider>
     void cookingSmelting(Consumer<IFinishedRecipe> consumer, RegistryObject<T> ingredient, RegistryObject<E> result, float experience, int time) {
        CookingRecipeBuilder.smelting(Ingredient.of(ingredient.get()), result.get(), experience, time).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer, result.get().getRegistryName() + "_from_smelting");
        CookingRecipeBuilder.cooking(Ingredient.of(ingredient.get()), result.get(), experience, time / 2, CookingRecipeSerializer.SMOKING_RECIPE).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer, result.get().getRegistryName() + "_from_smoking");
        CookingRecipeBuilder.cooking(Ingredient.of(ingredient.get()), result.get(), experience, time * 3, CookingRecipeSerializer.CAMPFIRE_COOKING_RECIPE).unlockedBy("has_ingredient", has(ingredient.get())).save(consumer, result.get().getRegistryName() + "_from_campfire_cooking");
    }

    // Common single-material shapes
    private static <T extends IForgeRegistryEntry<? super T> & IItemProvider, E extends IForgeRegistryEntry<? super E> & IItemProvider>
     void blockShape(Consumer<IFinishedRecipe> consumer, RegistryObject<T> input, RegistryObject<E> result) {
        ShapedRecipeBuilder.shaped(result.get()).define('#', input.get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_material", has(input.get())).save(consumer);
    }
    
    // Common shapeless recipes
    private static <T extends IForgeRegistryEntry<? super T> & IItemProvider, E extends IForgeRegistryEntry<? super E> & IItemProvider>
    void blockToComponent(Consumer<IFinishedRecipe> consumer, RegistryObject<T> input, RegistryObject<E> result) {
       ShapelessRecipeBuilder.shapeless(result.get(), 9).requires(input.get()).unlockedBy("has_block", has(input.get())).save(consumer);
    }

    private static void planksFromLog(Consumer<IFinishedRecipe> consumer, RegistryObject<RLPlanksBlock> planks, ITag<Item> log) {
        ShapelessRecipeBuilder.shapeless(planks.get(), 4).requires(log).group("planks").unlockedBy("has_log", has(log)).save(consumer);
    }
}
