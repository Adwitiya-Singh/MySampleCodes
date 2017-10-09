package Looper;

/**
 * Created by adwitiyasingh on 3/25/17.
 */
public class looper {
   private OnTickListener l;

    public void setOnTickListener(OnTickListener l) {
        this.l = l;
    }

    public void Start() {
        for (int i = 1; i <= 10; i++) {
            if(l==null){
                System.out.println("Set OnTickListener First");
                return;
            }
            l.OnTick();
            oneLoop();
        }
    }

    private void oneLoop() {
        long timenow = System.currentTimeMillis();
        while (System.currentTimeMillis() - timenow < 1000) {

        }

    }
}
