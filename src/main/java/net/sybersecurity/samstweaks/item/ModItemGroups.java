package net.sybersecurity.samstweaks.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sybersecurity.samstweaks.Samstweaks;
import net.sybersecurity.samstweaks.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SAMSTWEAKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Samstweaks.MOD_ID, "ruby"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.samstweaks"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.RUBY_BLOCK);

                        entries.add(ModItems.COPPER_HELMET);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_BOOTS);

                    }).build());

    public static void registerItemGroups() {
        Samstweaks.LOGGER.info("Registering Item Groups for " + Samstweaks.MOD_ID);
    }
}
