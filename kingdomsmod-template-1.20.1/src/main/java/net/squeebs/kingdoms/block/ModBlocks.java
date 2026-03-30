package net.squeebs.kingdoms.block;



import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.squeebs.kingdoms.KingdomsMod;

public class ModBlocks {


    /*public static final Block CABBAGES = registerBlock("cabbages",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));*/

    /*public static final Block COOL_BLOCK =
            Registries.BLOCK.get(new Identifier("othermod", "cool_block"));*/


    //farmers delight blocks
    public static Block CABBAGES;
    public static Block BUDDING_TOMATOS;
    public static Block ONIONS;
    public static Block RICE;



    //check and load of farmersdelight
    static{
         if(FabricLoader.getInstance().isModLoaded("farmersdelight")){

             CABBAGES = registerFarmersDelightBlock("cabbages");
             BUDDING_TOMATOS = registerFarmersDelightBlock("budding tomatos");
             ONIONS = registerFarmersDelightBlock("onions");
             RICE = registerFarmersDelightBlock("rice");
        }
    }
    private static Block registerFarmersDelightBlock(String name){

        return Registries.BLOCK.get(new Identifier("farmersdelight", name));
    }




    private static Block registerBlock(String name,Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(KingdomsMod.MOD_ID,name),block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,new Identifier(KingdomsMod.MOD_ID,name),
                new BlockItem(block,new FabricItemSettings()));
    }



    public static void registerModBlocks() {

        KingdomsMod.LOGGER.info("registering ModBlocks for"+KingdomsMod.MOD_ID);
    }
}
