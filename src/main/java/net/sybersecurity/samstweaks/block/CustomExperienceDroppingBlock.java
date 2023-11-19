package net.sybersecurity.samstweaks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CustomExperienceDroppingBlock extends ExperienceDroppingBlock {

    public CustomExperienceDroppingBlock(Settings settings, float minExperience, float maxExperience) {
        super(settings);
    }

    public static float minExperience;
    public static float maxExperience;

    public List<ItemStack> getDroppedStacks(World world, BlockState state, BlockPos pos, net.minecraft.loot.context.LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();

        // Logic for determining other item drops

        // Calculate the experience points to drop within the range 3f-7f
        float experiencePoints = minExperience + world.random.nextFloat() * (maxExperience - minExperience);

        // Drop the experience points
        if (experiencePoints > 0) {
            world.spawnEntity(new ExperienceOrbEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, (int) experiencePoints));
        }

        return drops;
    }
}
