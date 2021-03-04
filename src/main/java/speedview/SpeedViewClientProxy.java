package speedview;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;

public class SpeedViewClientProxy extends SpeedViewProxy{
    private SpeedViewGui speedViewGui;
    Minecraft mc;

    @Override
    public void init() {
        speedViewGui = new SpeedViewGui();
        mc = Minecraft.getMinecraft();
    }

    @Override
    public void onRenderTickPost() {
        if (mc != null && mc.thePlayer != null) {
            speedViewGui.drawGui(this.mc.thePlayer);
        } else {
            mc = Minecraft.getMinecraft();
        }
    }
}
