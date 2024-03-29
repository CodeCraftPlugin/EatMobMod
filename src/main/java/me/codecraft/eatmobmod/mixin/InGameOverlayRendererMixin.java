package me.codecraft.eatmobmod.mixin;


import me.codecraft.eatmobmod.effect.Effects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {

    @Inject(at = @At("HEAD"), method = "renderFireOverlay", cancellable = true)
    private static void removeFireOverlay(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        if (client.player != null&& (client.player.isInLava()|| (client.player.isOnFire()))&&client.player.hasStatusEffect(Effects.LAVA_VISION)) {
            ci.cancel();
        }
    }
}