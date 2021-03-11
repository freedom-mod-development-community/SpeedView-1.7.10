package speedview;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public class Vars {
    public static double speedSum = 0.0;
    public static int sumCnt;
    public static double lastSpeed = 0.0;
    public static boolean holdSpeed = false;
    public static double holdedSpeed = 0.0;

    public static void toggleHoldSpeed() {
        if (Vars.holdSpeed) {
            Vars.holdSpeed = false;
            Vars.holdedSpeed = 0.0;
        } else {
            Vars.holdSpeed = true;
            Vars.holdedSpeed = lastSpeed;
        }
    }

    public static void updateSpeed(EntityPlayer player) {
        double nowSpeed;
        if (player.ridingEntity == null) {
            nowSpeed = Math.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
        } else {
            double x = player.ridingEntity.motionX;
            double y = player.ridingEntity.motionY;
            double z = player.ridingEntity.motionZ;
            nowSpeed = Math.sqrt(x * x + y * y + z * z);

        }
        if (sumCnt >= 10) {
            lastSpeed = speedSum / sumCnt;
            speedSum = 0;
            sumCnt = 0;
        }
        speedSum += nowSpeed;
        sumCnt++;
    }
}
