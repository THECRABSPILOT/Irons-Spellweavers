package crab.mods.irons_spellweavers.weaver.client.gui;

import crab.mods.irons_spellweavers.weaver.client.gui.SpellweaverScreen;
import net.minecraft.client.Minecraft;

public class ClientGUIHandler {

    public static void openSpellweaverScreen() {
        Minecraft.getInstance().setScreen(new SpellweaverScreen());
    }
}