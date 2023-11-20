package net.sybersecurity.samstweaks.custom;

import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.sybersecurity.samstweaks.Samstweaks;

public class CustomText {

    public static final int CONFIRMATION_COLOR = 458547;
    public static final int FAILURE_COLOR = 16714291;

    // Add more color constants as needed

    public static Text withConfirmationColor(String text) {
        return withColor(text, CONFIRMATION_COLOR);
    }

    public static Text withFailureColor(String text) {
        return withColor(text, FAILURE_COLOR);
    }

    // Add more convenience methods for different colors and styles as needed

    private static Text withColor(String text, int customColor) {
        Style style = Style.EMPTY.withColor(customColor);
        return Text.literal(text).setStyle(style);
    }

    public static void registerModCustomText() {
        Samstweaks.LOGGER.info("Registering Mod Custom Texts for " + Samstweaks.MOD_ID);
    }
}
