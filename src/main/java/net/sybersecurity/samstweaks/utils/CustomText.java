package net.sybersecurity.samstweaks.utils;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.sybersecurity.samstweaks.Samstweaks;

public class CustomText {

    // Set colors here
    public static final int CONFIRMATION_COLOR = 458547;
    public static final int FAILURE_COLOR = 16714291;

    // Create functions for calling in the future
    public static Text withConfirmationColor(String text) {
        return withColor(text, CONFIRMATION_COLOR);
    }

    public static Text withFailureColor(String text) {
        return withColor(text, FAILURE_COLOR);
    }

    // Handles the translation ex:
    // player.sendMessage(CustomText.withFailureColor("No valuables found!"));
    private static Text withColor(String text, int customColor) {
        Style style = Style.EMPTY.withColor(customColor);
        return Text.literal(text).setStyle(style);
    }

    // Console logging that this is registering.
    public static void registerModCustomText() {
        Samstweaks.LOGGER.info("Registering Mod Custom Texts for " + Samstweaks.MOD_ID);
    }
}
