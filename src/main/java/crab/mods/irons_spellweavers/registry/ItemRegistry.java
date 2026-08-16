package crab.mods.irons_spellweavers.registry;

import crab.mods.irons_spellweavers.IronsSpellweavers;
import crab.mods.irons_spellweavers.items.ExampleMagicSword;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IronsSpellweavers.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> EXAMPLE_MAGIC_SWORD = ITEMS.register("example_magic_sword",
            () -> new ExampleMagicSword(
                    new SpellDataRegistryHolder[]
                            {new SpellDataRegistryHolder(ExampleSpellRegistry.SUPER_HEAL_SPELL, 1)
                            }));

    public static final RegistryObject<Item> SPELLWEAVER_BOOK = ITEMS.register("spellweaver_book",
            () -> new Item(new Item.Properties()));
}