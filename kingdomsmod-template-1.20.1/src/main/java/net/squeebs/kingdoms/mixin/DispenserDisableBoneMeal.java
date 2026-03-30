package net.squeebs.kingdoms.mixin;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BoneMealItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.squeebs.kingdoms.block.ModBlocks;

import java.util.Set;


@Mixin(BoneMealItem.class)
public class DispenserDisableBoneMeal {


    @Inject(method = "useOnFertilizable", at = @At("HEAD"), cancellable = true)
    private static void disableBonemeal(ItemStack stack, World world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {

        Block block = world.getBlockState(pos).getBlock();

        Set<Block> allowedBlocks = Set.of
                (
                        Blocks.WHEAT,
                        Blocks.CARROTS,
                        Blocks.POTATOES,
                        Blocks.BEETROOTS,
                        Blocks.SWEET_BERRY_BUSH,
                        Blocks.COCOA,
                        Blocks.CAVE_VINES,
                        Blocks.KELP,
                        Blocks.TORCHFLOWER_CROP,
                        Blocks.PITCHER_CROP
                );
        if (allowedBlocks.contains(block)) {
            cir.setReturnValue(false);
        }
        if (ModBlocks.CABBAGES != null) {
            Set<Block> allowedFarmersDelightBlocks = Set.of
                    (
                            ModBlocks.CABBAGES,
                            ModBlocks.RICE,
                            ModBlocks.BUDDING_TOMATOS,
                            ModBlocks.ONIONS
                    );
            if (FabricLoader.getInstance().isModLoaded("farmersdelight")) {
                if (allowedFarmersDelightBlocks.contains(block)) {
                    cir.setReturnValue(false);
                }
            }
        }



    }
}
