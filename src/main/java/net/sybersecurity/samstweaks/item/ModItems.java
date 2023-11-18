package net.sybersecurity.samstweaks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sybersecurity.samstweaks.Samstweaks;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Samstweaks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Samstweaks.LOGGER.info("Registering Mod Items for " + Samstweaks.MOD_ID);
    }
}
