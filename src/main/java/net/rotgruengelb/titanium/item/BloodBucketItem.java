package net.rotgruengelb.titanium.item;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BloodBucketItem extends BucketItem {
    private static final int MAX_USE_TIME = 200; // 10 seconds

    public BloodBucketItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (user instanceof PlayerEntity playerEntity) {
            return ItemUsage.exchangeStack(stack, playerEntity, new ItemStack(Items.BUCKET), false);
        } else {
            stack.decrementUnlessCreative(1, user);
            return stack;
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return MAX_USE_TIME;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // try to use the bucket as a normal item first
        TypedActionResult<ItemStack> result = super.use(world, user, hand);

        // if accepted and user not sneaking return result
        if (result.getResult().isAccepted() || !user.isSneaking()) {
            return result;
        }

        // other start consuming the item
        user.setCurrentHand(hand);
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
