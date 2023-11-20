package net.sybersecurity.samstweaks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sybersecurity.samstweaks.Samstweaks;
import net.sybersecurity.samstweaks.item.custom.TestCustomItem;

public class ModItems {

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item TESTCUSTOMITEM = registerItem("testcustomitem", new TestCustomItem(new FabricItemSettings().maxDamage(64)));

    public static final Item COPPER_HELMET = registerItem("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item COPPER_BOOTS = registerItem("copper_boots", new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new FabricItemSettings()));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Samstweaks.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Samstweaks.LOGGER.info("Registering Mod Items for " + Samstweaks.MOD_ID);
    }
}
