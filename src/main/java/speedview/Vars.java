package speedview;

import net.minecraft.client.Minecraft;

public class Vars {
    public static boolean holdSpeed = false;
    public static double holdedSpeed = 0.0;
    public static void toggleHoldSpeed(){
        if(Vars.holdSpeed){
            Vars.holdSpeed = false;
            Vars.holdedSpeed = 0.0;
        }else{
            Vars.holdSpeed = true;
            Vars.holdedSpeed = SpeedViewScreen.getSpeed(Minecraft.getMinecraft().thePlayer);
        }
    }
}
