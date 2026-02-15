package net.squeebs.kingdoms;

import net.fabricmc.api.ModInitializer;

import net.squeebs.kingdoms.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KingdomsMod implements ModInitializer {
	public static final String MOD_ID = "kingdomsmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();

		LOGGER.info("Hello Fabric world!");
	}
}