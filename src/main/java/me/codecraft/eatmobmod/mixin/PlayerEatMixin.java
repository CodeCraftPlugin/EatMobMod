package me.codecraft.eatmobmod.mixin;

import me.codecraft.eatmobmod.effect.Effects;
import me.codecraft.eatmobmod.items.Items;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEatMixin {
    @Shadow @Final public PlayerScreenHandler playerScreenHandler;
    public boolean blaze = false;
    public boolean cow_milk = false;
    public boolean spider = false;
    public boolean eat_carrot = false;
    public boolean flychick = false;
    public boolean creeper = false;

    @Inject(at = @At("HEAD"), method = "eatFood", cancellable = true)
    private void eatFood(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        if(stack.getItem()==null)return;
        if (stack.getItem().isFood()) {

            if (stack.getItem()== Items.EDIBLE_COW){
                spider = true;
            }
            if (stack.getItem()==Items.EDIBLE_PIG){
                eat_carrot = true;
            }
            if(eat_carrot && stack.getItem()== net.minecraft.item.Items.CARROT){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 50, 3));
            }
            if (stack.getItem()==Items.EDIBLE_CHICKEN){
                flychick = true;
            }
            if(stack.getItem() == Items.EDIBLE_DRAGON){
                player.getAbilities().allowFlying = true;
                player.getAbilities().invulnerable = true;
            }
            if(stack.getItem() == Items.EDIBLE_SPIDER){
                spider = true;
            }
            if(stack.getItem() == Items.EDIBLE_CREEPER){
                creeper = true;
            }
            if (stack.getItem()==Items.EDIBLE_GOLEM){
                // set player max health to 40
                player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(40);
                // set player health to 40
                player.setHealth(40);
            }
            if (stack.getItem()==Items.EDIBLE_BLAZE){
                blaze = true;
            }
        }
    }
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private  void tick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if(flychick && player.fallDistance>2){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 10, 3));
        }
        if (blaze&&(player.isInLava()||player.isOnFire())){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 10, 3));
            player.addStatusEffect(new StatusEffectInstance(Effects.LAVA_VISION, 10, 3));
            player.setFireTicks(0);
        }

                if (player.getMainHandStack().getItem() == net.minecraft.item.Items.BUCKET) {
                    if (cow_milk) {
                        UseItemCallback.EVENT.register((playerEntity, world, hand) -> {
                                playerEntity.getMainHandStack().decrement(1);
                                playerEntity.giveItemStack(new ItemStack(net.minecraft.item.Items.MILK_BUCKET));
                            return TypedActionResult.pass(playerEntity.getMainHandStack());
                        });
                    }
                }

                if (player.getMainHandStack().getItem() == net.minecraft.item.Items.GUNPOWDER) {
                    if(creeper) {
                        UseItemCallback.EVENT.register((playerEntity, world, hand) -> {
                            Vec3d playerDirection =  playerEntity.getRotationVector();
                            double x = playerEntity.getX() + playerDirection.x;
                            double y = playerEntity.getY() + playerDirection.y;
                            double z = playerEntity.getZ() + playerDirection.z;
                            playerEntity.world.createExplosion(playerEntity, x, y, z, 3, false, World.ExplosionSourceType.TNT);
                            return TypedActionResult.success(playerEntity.getMainHandStack());
                        });
                    }

                }


        if (player.isSneaking()&&spider) {
            // Get the block the player is standing on
            BlockPos blockPosx = new BlockPos((int) player.getX()-1, (int)player.getY(), (int)player.getZ());
            BlockPos blockPosz = new BlockPos((int)player.getX(), (int)player.getY(), (int)player.getZ()-1);
            BlockPos blockPosx2 = new BlockPos((int)player.getX()+1, (int)player.getY(), (int)player.getZ());
            BlockPos blockPosz2 = new BlockPos((int)player.getX(), (int)player.getY(), (int)player.getZ()+1);
            BlockState blockStatex = player.world.getBlockState(blockPosx);
            BlockState blockStatez = player.world.getBlockState(blockPosz);
            BlockState blockStatex1 = player.world.getBlockState(blockPosx2);
            BlockState blockStatez2= player.world.getBlockState(blockPosz2);
            Block blockx = blockStatex.getBlock();
            Block blockz = blockStatez.getBlock();
            Block blockx2 = blockStatex1.getBlock();
            Block blockz2 = blockStatez2.getBlock();
            // Set the player's motion to climb up the block

            if (!(blockx == Blocks.AIR)) {
                player.setVelocity(player.getVelocity().x, 0.2, player.getVelocity().z);
                System.out.println(blockx);
            }else if (!(blockz == Blocks.AIR)) {
                player.setVelocity(player.getVelocity().x, 0.2, player.getVelocity().z);
                System.out.println(blockz);
            }else if (!(blockx2 == Blocks.AIR)) {
                player.setVelocity(player.getVelocity().x, 0.2, player.getVelocity().z);
                System.out.println(blockz);
            } else if (!(blockz2 == Blocks.AIR)) {
                player.setVelocity(player.getVelocity().x, 0.2, player.getVelocity().z);
                System.out.println(blockz);
            }

        }
    }
}
