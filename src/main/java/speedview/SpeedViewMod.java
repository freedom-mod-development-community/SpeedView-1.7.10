package speedview;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;

@Mod(modid = SpeedViewMod.MOD_ID, name = "SpeedViewMod", version = "[1.7.10]-1.2-Full")
public class SpeedViewMod {
    public static final String MOD_ID = "SpeedViewMod";
    public static final String DOMAIN = "speedview";
    @Mod.Instance("SpeedViewMod")
    public static SpeedViewMod instance;

    @SidedProxy(clientSide = "speedview.SpeedViewClientProxy")
    public static SpeedViewProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        FMLCommonHandler.instance().bus().register(new TickEventManager());
        FMLCommonHandler.instance().bus().register(new KeyInputObserver());
        if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            NetworkRegistry.INSTANCE.registerGuiHandler(SpeedViewMod.instance, new GuiHandler());
        }
    }
}