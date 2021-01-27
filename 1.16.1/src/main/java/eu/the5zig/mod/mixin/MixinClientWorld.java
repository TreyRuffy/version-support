package eu.the5zig.mod.mixin;

import eu.the5zig.mod.The5zigMod;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public abstract class MixinClientWorld {

	@Inject(method = "<init>", at = @At("RETURN"))
	public void init(ClientPlayNetworkHandler networkHandler, ClientWorld.Properties properties,
					 RegistryKey<World> registryRef, DimensionType dimensionType, int loadDistance,
					 Supplier<Profiler> profiler, WorldRenderer worldRenderer, boolean debugWorld, long seed,
					 CallbackInfo ci) {
		The5zigMod.getListener().onWorldSwitch();
	}
}
