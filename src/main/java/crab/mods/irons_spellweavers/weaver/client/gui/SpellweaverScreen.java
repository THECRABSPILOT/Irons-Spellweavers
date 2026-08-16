package crab.mods.irons_spellweavers.weaver.client.gui;   // change to your package

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpellweaverScreen extends Screen {

    // Your book texture
    private static final ResourceLocation BOOK_TEXTURE =
            new ResourceLocation("irons_spellweavers", "textures/gui/spellweaver_book.png");

    // Size of the book on screen
    private final int bookWidth = 256;
    private final int bookHeight = 180;

    private int leftPos;
    private int topPos;

    public SpellweaverScreen() {
        super(Component.literal("Spellweavers Book"));
    }

    @Override
    protected void init() {
        super.init();
        // Center the book
        this.leftPos = (this.width - bookWidth) / 2;
        this.topPos = (this.height - bookHeight) / 2;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Dark background
        this.renderBackground(graphics);

        // Draw the book texture
        graphics.blit(BOOK_TEXTURE, leftPos, topPos, 0, 0, bookWidth, bookHeight, bookWidth, bookHeight);

        // TODO: later draw blocks on left page and right page here

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // game keeps running behind the book
    }
}