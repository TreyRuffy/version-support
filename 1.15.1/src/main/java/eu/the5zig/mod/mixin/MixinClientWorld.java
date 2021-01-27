package eu.the5zig.mod.mixin;

import eu.the5zig.mod.The5zigMod;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.profiler.IProfiler;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class MixinClientWorld {

	@Inject(method = "<init>", at = @At("RETURN"))
	public void init(ClientPlayNetHandler p_i51056_1_, WorldSettings p_i51056_2_, DimensionType p_i51056_3_, int p_i51056_4_, IProfiler p_i51056_5_, WorldRenderer p_i51056_6_, CallbackInfo ci) {
		The5zigMod.getListener().onWorldSwitch();
	}
	
}
