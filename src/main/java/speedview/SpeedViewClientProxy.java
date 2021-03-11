package speedview;

import net.minecraft.client.Minecraft;

public class SpeedViewClientProxy extends SpeedViewProxy{
    private SpeedViewScreen speedViewGui;
    Minecraft mc;

    @Override
    public void init() {
        speedViewGui = new SpeedViewScreen();
        mc = Minecraft.getMinecraft();
        KeyInputObserver.registerClientActions();
    }

    @Override
    public void onRenderTickPost() {
        if (mc != null && mc.thePlayer != null) {
            speedViewGui.drawGui(this.mc.thePlayer);
        } else {
            mc = Minecraft.getMinecraft();
        }
    }

    @Override
    void onClientTick() {
        if (mc != null && mc.thePlayer != null) {
            Vars.updateSpeed(mc.thePlayer);
        } else {
            mc = Minecraft.getMinecraft();
        }
    }
}
