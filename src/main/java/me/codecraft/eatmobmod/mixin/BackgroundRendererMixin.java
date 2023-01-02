package me.codecraft.eatmobmod.mixin;


import com.mojang.blaze3d.systems.RenderSystem;
import me.codecraft.eatmobmod.effect.Effects;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {
    @Inject(method = "applyFog", at = @At(value = "TAIL"))
    private static void changeForInLava(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        CameraSubmersionType cameraSubmersionType = camera.getSubmersionType();

        PlayerEntity player = (PlayerEntity) camera.getFocusedEntity();

        if (cameraSubmersionType == CameraSubmersionType.LAVA&& player.hasStatusEffect(Effects.LAVA_VISION)) {
                RenderSystem.setShaderFogStart(0);
                RenderSystem.setShaderFogEnd(150F);
        }
    }
}
