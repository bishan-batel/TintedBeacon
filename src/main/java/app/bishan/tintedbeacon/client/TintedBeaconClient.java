package app.bishan.tintedbeacon.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.StainedGlassBlock;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.block.entity.BeaconBlockEntity;

@Environment(EnvType.CLIENT)
public class TintedBeaconClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		StainedGlassBlock a;
			TintedGlassBlock b;
	}
}
