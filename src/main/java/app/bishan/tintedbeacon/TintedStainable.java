package app.bishan.tintedbeacon;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Material;
import net.minecraft.block.Stainable;
import net.minecraft.block.TintedGlassBlock;
import net.minecraft.item.DyeItem;
import net.minecraft.util.DyeColor;

@Environment(EnvType.CLIENT)
public class TintedStainable extends TintedGlassBlock implements Stainable
{
	public TintedStainable()
	{
		super(Settings.of(Material.GLASS));
	}

	@Override
	public DyeColor getColor()
	{
		return null;
	}
}
