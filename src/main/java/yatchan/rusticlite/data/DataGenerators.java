package yatchan.rusticlite.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import yatchan.rusticlite.RusticLite;
import yatchan.rusticlite.data.client.RLBlockStateProvider;
import yatchan.rusticlite.data.client.RLItemModelProvider;
import yatchan.rusticlite.data.common.RLBlockTagsProvider;
import yatchan.rusticlite.data.common.RLItemTagsProvider;
import yatchan.rusticlite.data.common.RLLootTableProvider;
import yatchan.rusticlite.data.common.RLRecipeProvider;

@Mod.EventBusSubscriber(modid = RusticLite.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // For each new data gen provider, it much be added here
        if (event.includeClient()) {
            generator.addProvider(new RLBlockStateProvider(generator, existingFileHelper));
            generator.addProvider(new RLItemModelProvider(generator, existingFileHelper));
        }
        if (event.includeServer()) {
            generator.addProvider(new RLLootTableProvider(generator));
            generator.addProvider(new RLRecipeProvider(generator));

            RLBlockTagsProvider blockTagsProvider = new RLBlockTagsProvider(generator, existingFileHelper);
            generator.addProvider(blockTagsProvider);
            generator.addProvider(new RLItemTagsProvider(generator, blockTagsProvider, existingFileHelper));
        }
    }
}
