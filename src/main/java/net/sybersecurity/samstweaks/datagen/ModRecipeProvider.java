package net.sybersecurity.samstweaks.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.book.RecipeCategory;
import net.sybersecurity.samstweaks.block.ModBlocks;
import net.sybersecurity.samstweaks.item.ModItems;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    // Create a list of all grouped smeltable items (ores, raw variants) to be called later
    // to be smelted or blasted into the result
    private static final List<ItemConvertible> RUBY_SMELTABLES =
            List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);

    // Used in a crafting recipe. Datagen may not like a long list, so add a for loop.
    private static final List<ItemConvertible> ALL_WOOL = List.of(
            Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL,
            Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL,
            Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL,
            Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL
    );


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

        for (ItemConvertible wool : ALL_WOOL) {
            offerShapelessRecipe(exporter, Items.STRING, wool, "string", 4);
        }

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, ModItems.CHAINMAIL, Items.CHAIN);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET, 1)
                // Crafting table pattern, 3x3
                .pattern("CCC")
                .pattern("C C")
                .pattern("   ")
                // Crafting table keymap
                .input('C', ModItems.CHAINMAIL)
                // Criteria of the user having these items
                .criterion(hasItem(ModItems.CHAINMAIL), conditionsFromItem(ModItems.CHAINMAIL))
                // Shows the recipe name
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE, 1)
                // Crafting table pattern, 3x3
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                // Crafting table keymap
                .input('C', ModItems.CHAINMAIL)
                // Criteria of the user having these items
                .criterion(hasItem(ModItems.CHAINMAIL), conditionsFromItem(ModItems.CHAINMAIL))
                // Shows the recipe name
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS, 1)
                // Crafting table pattern, 3x3
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                // Crafting table keymap
                .input('C', ModItems.CHAINMAIL)
                // Criteria of the user having these items
                .criterion(hasItem(ModItems.CHAINMAIL), conditionsFromItem(ModItems.CHAINMAIL))
                // Shows the recipe name
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS, 1)
                // Crafting table pattern, 3x3
                .pattern("C C")
                .pattern("C C")
                .pattern("   ")
                // Crafting table keymap
                .input('C', ModItems.CHAINMAIL)
                // Criteria of the user having these items
                .criterion(hasItem(ModItems.CHAINMAIL), conditionsFromItem(ModItems.CHAINMAIL))
                // Shows the recipe name
                .offerTo(exporter);

    }
}
