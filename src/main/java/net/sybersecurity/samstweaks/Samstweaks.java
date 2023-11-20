package net.sybersecurity.samstweaks;

import net.fabricmc.api.ModInitializer;

import net.sybersecurity.samstweaks.block.ModBlocks;
import net.sybersecurity.samstweaks.utils.CustomText;
import net.sybersecurity.samstweaks.item.ModItemGroups;
import net.sybersecurity.samstweaks.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Samstweaks implements ModInitializer {

	public static final String MOD_ID = "samstweaks";
	public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {
		// Initialize the Item Groups (tabs)
		ModItemGroups.registerItemGroups();
		// Initialize the Mod Items
		ModItems.registerModItems();
		// Initialize the Mod Blocks
		ModBlocks.registerModBlocks();
		// Initialize the Custom text methods
		CustomText.registerModCustomText();
	}
}