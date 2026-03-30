package net.squeebs.kingdoms.mixin;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BoneMealItem.class)
public class DisableBoneMeal {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    private void disableBonemeal(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block block = world.getBlockState(pos).getBlock();

        // ❌ Disable bonemeal on wheat
        if (block == Blocks.WHEAT) {
            cir.setReturnValue(ActionResult.FAIL);
        }

        // ❌ Disable on your mod block
        // if (block == ModBlocks.MY_PLANT) {
        //     cir.setReturnValue(ActionResult.FAIL);
        // }
    }
}
