package net.squeebs.kingdoms.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.squeebs.kingdoms.KingdomsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    //add items here * public static final Item EXAMPLE = registerItem("example",new Item(new FabricItemSettings()))
    public static final Item IRON_KNIFE_BLADE = registerItem("iron_knife_blade",new Item(new FabricItemSettings()));
    public static final Item IRON_SPEAR_HEAD = registerItem("iron_spear_head",new Item(new FabricItemSettings()));
    public static final Item IRON_EXCAVATOR_HEAD = registerItem("iron_excavator_head",new Item(new FabricItemSettings()));
    public static final Item IRON_HAMMER_HEAD = registerItem("iron_hammer_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_AXE_HEAD = registerItem("diamond_axe_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_EXCAVATOR_HEAD = registerItem("diamond_excavator_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_HAMMER_HEAD = registerItem("diamond_hammer_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_HOE_HEAD = registerItem("diamond_hoe_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_SHOVEL_HEAD = registerItem("diamond_shovel_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_SPEAR_HEAD = registerItem("diamond_spear_head",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_KNIFE_BLADE = registerItem("diamond_knife_blade",new Item(new FabricItemSettings()));
    public static final Item DIAMOND_SWORD_BLADE = registerItem("diamond_sword_blade",new Item(new FabricItemSettings()));
    public static final Item FLINT_ARROW_HEAD = registerItem("flint_arrow_head",new Item(new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(IRON_KNIFE_BLADE);
        entries.add(IRON_SPEAR_HEAD);
        entries.add(IRON_EXCAVATOR_HEAD);
        entries.add(IRON_HAMMER_HEAD);
        entries.add(DIAMOND_AXE_HEAD);
        entries.add(DIAMOND_EXCAVATOR_HEAD);
        entries.add(DIAMOND_HAMMER_HEAD);
        entries.add(DIAMOND_HOE_HEAD);
        entries.add(DIAMOND_SHOVEL_HEAD);
        entries.add(DIAMOND_SPEAR_HEAD);
        entries.add(DIAMOND_KNIFE_BLADE);
        entries.add(DIAMOND_SWORD_BLADE);
        entries.add(FLINT_ARROW_HEAD);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(KingdomsMod.MOD_ID, name), item);

    }

    public static void registerModItems(){
        KingdomsMod.LOGGER.info("Registering Mod Items for" + KingdomsMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}