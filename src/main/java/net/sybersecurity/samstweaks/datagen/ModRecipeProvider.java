package net.sybersecurity.samstweaks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.sybersecurity.samstweaks.block.ModBlocks;
import net.sybersecurity.samstweaks.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    // Create a list of all grouped smeltable items (ores, raw variants) to be called later
    // to be smelted or blasted into the result
    private static final List<ItemConvertible> RUBY_SMELTABLES =
            List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Calling the list of smeltable items and providing the result (ruby), including the
        // experience and time.
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7f, 100, "ruby");

        // Allows for compacting recipes, from gems to blocks and reversible
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);

        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY, 1)
                // Crafting table pattern, 3x3
                .pattern("")
                .pattern("")
                .pattern("")
                // Crafting table keymap
                .input('#', ModItems.RUBY)
                .input('$', Items.STONE)
                // Criteria of the user having these items
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                // Shows the recipe name
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY)));
         */
    }
}
