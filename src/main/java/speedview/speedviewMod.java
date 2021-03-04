package speedview;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = speedviewMod.MOD_ID, name = "SpeedViewMod", version = "[1.7.10]-0.0")
public class speedviewMod {
    public static final String MOD_ID = "SpeedViewMod";
    public static final String DOMAIN = "speedview";

    @SidedProxy(clientSide = "speedview.SpeedViewClientProxy")
    public static SpeedViewProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        FMLCommonHandler.instance().bus().register(new TickEventManager());
    }
}