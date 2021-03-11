package speedview;

abstract class SpeedViewProxy {
    public void init() {
    }

    abstract void onRenderTickPost();

    abstract void onClientTick();
}
