package speedview;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SpeedCheckGui extends GuiContainer {
    public SpeedCheckGui() {
        super(new Container() {
            @Override
            public boolean canInteractWith(EntityPlayer p_75145_1_) {
                return true;
            }
        });
    }

    @Override
    public void initGui(){
        this.buttonList.add(new GuiButton(0, this.width-70, this.height - 60, 40,20,"hold"));
        this.buttonList.add(new GuiButton(1, this.width-150, this.height - 60, 40,20,"print"));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            Vars.toggleHoldSpeed();
        }else
        if (button.id == 1) {
            if(Vars.holdSpeed) {
                Date dateObj = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH;mm");
                String time = format.format(dateObj);
                String kmph = String.format("%5.2f", Vars.holdedSpeed * 20 * 3.6);
                String commandString = "/give @p minecraft:paper 1 0 {display:{Name:\"Speed Ticket\",Lore:[\"" + time + "  " + kmph + "[km/h] \"]}}";
                this.mc.thePlayer.sendChatMessage(commandString);
            }
        }
    }

    @Override
    public void drawWorldBackground(int p_146270_1_) {
        if (this.mc.theWorld != null) {
            this.drawGradientRect(this.width - 170, this.height - 70, this.width - 10, this.height - 20, -804253680, -804253680);
        } else {
            this.drawBackground(p_146270_1_);
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
//        GL11.glPushMatrix();
//        this.fontRendererObj.drawString("Airport Name  : ", this.width / 2 - 140, this.height / 2 - 30, -1, false);
//        GL11.glPopMatrix();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
