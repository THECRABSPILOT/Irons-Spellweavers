package crab.mods.irons_spellweavers;

import com.mojang.logging.LogUtils;
import crab.mods.irons_spellweavers.registry.ItemRegistry;
import crab.mods.irons_spellweavers.registry.ExampleSpellRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(IronsSpellweavers.MODID)
public class IronsSpellweavers {
    public static final String MODID = "irons_spellweavers";
    public static final Logger LOGGER = LogUtils.getLogger();

    // Creative tab
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> SPELLWEAVERS_TAB = CREATIVE_TABS.register("spellweavers_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.irons_spellweavers"))
                    .icon(() -> new ItemStack(ItemRegistry.SPELLWEAVER_BOOK.get()))
                    .displayItems((parameters, output) -> {
                        // Book first
                        output.accept(ItemRegistry.SPELLWEAVER_BOOK.get());

                        // Add more items under it later
                        // output.accept(ItemRegistry.SOME_OTHER_ITEM.get());
                    })
                    .build()
    );

    public IronsSpellweavers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // Register everything
        CREATIVE_TABS.register(modEventBus);
        ExampleSpellRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}