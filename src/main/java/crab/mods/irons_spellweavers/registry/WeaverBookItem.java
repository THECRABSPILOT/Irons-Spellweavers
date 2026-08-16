package crab.mods.irons_spellweavers.registry;

import crab.mods.irons_spellweavers.IronsSpellweavers;
import crab.mods.irons_spellweavers.weaver.client.gui.SpellweaverScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;

public class WeaverBookItem extends Item {

    public WeaverBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // This will print in the console every time you right-click the book
        IronsSpellweavers.LOGGER.info("Spellweaver Book used! isClientSide = {}", level.isClientSide);

        if (level.isClientSide) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
                Minecraft.getInstance().setScreen(new SpellweaverScreen());
            });
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}