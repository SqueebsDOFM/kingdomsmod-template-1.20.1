package net.squeebs.kingdoms.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent RESIN_CANDY = new FoodComponent.Builder().hunger(3).saturationModifier(0.1667f).snack().build();
    public static final FoodComponent CARAMELIZED_ONIONS = new FoodComponent.Builder().hunger(6).saturationModifier(0.4167f).build();
    public static final FoodComponent CARAMELIZED_ONION_CHOWDER = new FoodComponent.Builder().hunger(13).saturationModifier(0.34615f).build();
}
