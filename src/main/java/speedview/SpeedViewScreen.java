package speedview;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

public class SpeedViewScreen extends GuiScreen {
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public double isDrawGui(EntityPlayer player) {
        if (mc == null) {
            mc = Minecraft.getMinecraft();
        }
        if (mc != null) {
            return Vars.lastSpeed;
        }
        return -1;
    }

    public void drawGui(EntityPlayer player) {
        double mpt = isDrawGui(player);
        if (mpt < 0) {
            return;
        }

        double viewSpeedMpt;
        if (Vars.holdSpeed) {
            viewSpeedMpt = Vars.holdedSpeed;
        } else {
            viewSpeedMpt = mpt;
        }
        double mps = viewSpeedMpt * 20;
        double kmph = mps * 3.6;
        double knot = mps * 0.5144;
        ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

        int color;
        if (Vars.holdSpeed) {
            color = -1;
        } else {
            color = 0xf3bd63;
        }
        mc.fontRenderer.drawString(String.format("%5.2f", kmph) + "km/h (" + String.format("%03.2f", knot) + "knot) " + (Vars.holdSpeed ? "(Hold)" : ""),
                scaledresolution.getScaledWidth() - 150,
                scaledresolution.getScaledHeight() - mc.fontRenderer.FONT_HEIGHT - 20,
                color);
    }
}
