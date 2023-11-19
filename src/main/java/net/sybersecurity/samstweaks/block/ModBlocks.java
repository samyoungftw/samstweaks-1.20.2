package net.sybersecurity.samstweaks.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sybersecurity.samstweaks.Samstweaks;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_ORE)));
     public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_EMERALD_ORE)));

    /*
    EMERALD_ORE = register((String)"emerald_ore", new ExperienceDroppingBlock
            (AbstractBlock.Settings.create()
    .mapColor(MapColor.STONE_GRAY).instrument(Instrument.BASEDRUM)
    .requiresTool().strength(3.0F, 3.0F), UniformIntProvider.create(3, 7)));

    DEEPSLATE_EMERALD_ORE = register((String)"deepslate_emerald_ore",
    new ExperienceDroppingBlock(AbstractBlock.Settings.copy(EMERALD_ORE)
    .mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F)
    .sounds(BlockSoundGroup.DEEPSLATE), UniformIntProvider.create(3, 7)));
     */

    // Helper methods, do not touch
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Samstweaks.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Samstweaks.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        Samstweaks.LOGGER.info("Registering Mod Blocks for " + Samstweaks.MOD_ID);
    }
}
