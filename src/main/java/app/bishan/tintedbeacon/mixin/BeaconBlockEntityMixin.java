package app.bishan.tintedbeacon.mixin;

import app.bishan.tintedbeacon.TintedBeacon;
import app.bishan.tintedbeacon.TintedStainable;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Objects;

@Mixin(BeaconBlockEntity.class)
@Environment(EnvType.CLIENT)
public class BeaconBlockEntityMixin
{

	//	@Inject(at = @At(value="HEAD"), method = "tick")
	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;getBlock()Lnet/minecraft/block/Block;"))
	private static Block tick(BlockState instance)
	{
		var block = instance.getBlock();
		if (block instanceof TintedGlassBlock) return new TintedStainable();
		return block;
	}

	@Redirect(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/DyeColor;getColorComponents()[F"))
	private static float[] color(DyeColor instance)
	{
		if (instance == null) return TintedBeacon.TINTED_DYE_COLOR;
		return instance.getColorComponents();
	}

	@Redirect(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/block/entity/BeaconBlockEntity$BeamSegment;color:[F"))
	private static float[] lol(BeaconBlockEntity.BeamSegment instance)
	{
		return Objects.requireNonNullElse(instance.getColor(), TintedBeacon.TINTED_DYE_COLOR);
	}
}
