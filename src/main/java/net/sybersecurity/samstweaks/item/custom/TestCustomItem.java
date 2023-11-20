package net.sybersecurity.samstweaks.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sybersecurity.samstweaks.custom.CustomText;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestCustomItem extends Item {
    public TestCustomItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                player.sendMessage(CustomText.withFailureColor("No valuables found!"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(CustomText.withConfirmationColor("Found " + block.asItem().getName().getString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.samstweaks.testcustomitem.tooltip").setStyle(Style.EMPTY.withColor(14125107)));
        super.appendTooltip(stack, world, tooltip, context);
    }
}