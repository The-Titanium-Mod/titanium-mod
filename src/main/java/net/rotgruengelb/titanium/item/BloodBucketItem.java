package net.rotgruengelb.titanium.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
//? if 1.21.1 {
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.UseAnim;
//?}

public class BloodBucketItem extends BucketItem {
    private static final int MAX_USE_TIME = 120; // 6 seconds

    public BloodBucketItem(Fluid fluid, Properties settings) {
        super(fluid, settings);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
        super.finishUsingItem(stack, world, user);
        if (user instanceof ServerPlayer serverPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.awardStat(Stats.ITEM_USED.get(this));
        }

        //? if 1.21.1 {
        if (user instanceof Player playerEntity) {
            return ItemUtils.createFilledResult(stack, playerEntity, new ItemStack(Items.BUCKET), false);
        } else {
            stack.consume(1, user);
            return stack;
        }
        //?} else {
        /*return stack;
         *///?}
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity user) {
        return MAX_USE_TIME;
    }

    //? if 1.21.1 {
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
     //?}

    @Override
    //? if 1.21.1 {
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
    //?} else {
    /*public InteractionResult use(Level world, Player user, InteractionHand hand) {
    *///?}
        // try to use the bucket as a normal item first
        var result = super.use(world, user, hand);
        boolean resultAccepted = //? if 1.21.1 {
                result.getResult().consumesAction(); //?} else {
                /*result.consumesAction(); *///?}

        // if accepted and user not sneaking return result
        if (resultAccepted || !user.isShiftKeyDown()) {
            return result;
        }

        // other start consuming the item
        user.startUsingItem(hand);
        return ItemUtils.startUsingInstantly(world, user, hand);
    }
}
