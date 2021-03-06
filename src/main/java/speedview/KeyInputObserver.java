package speedview;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

public class KeyInputObserver {
    static KeyInputObserver INSTANCE = new KeyInputObserver();
    private static final HashMap<KeyBinding, KeyInputActioner> map = new HashMap<KeyBinding, KeyInputActioner>();

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent e) {
        if (e.phase == TickEvent.Phase.START) {
            for (Map.Entry<KeyBinding, KeyInputActioner> entry : map.entrySet()) {
                if (entry.getKey().isPressed()) {
                    entry.getValue().action();
                }
            }
        }
    }

    public static void registerKeyAction(KeyInputActioner action) {
        KeyBinding keybinding = new KeyBinding(action.getKeyName(), action.getDefaultKeyID(), action.getCategoryName());
        map.put(keybinding, action);
        ClientRegistry.registerKeyBinding(keybinding);
    }

    public interface KeyInputActioner {
        String getKeyName();

        int getDefaultKeyID();

        String getCategoryName();

        void action();
    }

    public static void registerClientActions() {
        registerKeyAction(new SpeedViewGuiOpen());
        registerKeyAction(new SpeedHold());
    }


    public static class SpeedViewGuiOpen implements KeyInputObserver.KeyInputActioner {
        @Override
        public String getKeyName() {
            return "openSpeedViewGui";
        }

        @Override
        public int getDefaultKeyID() {
            return Keyboard.KEY_BACKSLASH;
        }

        @Override
        public String getCategoryName() {
            return "SpeedView Gui";
        }

        @Override
        public void action() {
            Minecraft mc = Minecraft.getMinecraft();
            mc.thePlayer.openGui(SpeedViewMod.instance, 0, mc.theWorld, 0, 0, 0);
        }
    }



    public static class SpeedHold implements KeyInputObserver.KeyInputActioner {
        @Override
        public String getKeyName() {
            return "SpeedHold";
        }

        @Override
        public int getDefaultKeyID() {
            return Keyboard.KEY_APOSTROPHE;
        }

        @Override
        public String getCategoryName() {
            return "SpeedView Gui";
        }

        @Override
        public void action() {
            Vars.toggleHoldSpeed();
        }
    }
}
