package speedview;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TickEventManager {
    @SubscribeEvent
    public void onRenderTickEvent(TickEvent.RenderTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            SpeedViewMod.proxy.onRenderTickPost();
        }
    }

    @SubscribeEvent
    public void onClientTickEvent(TickEvent.ClientTickEvent event){
        if(event.phase == TickEvent.Phase.END){
            SpeedViewMod.proxy.onClientTick();
        }
    }
}
