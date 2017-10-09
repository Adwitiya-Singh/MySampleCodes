package Looper;

/**
 * Created by adwitiyasingh on 3/25/17.
 */
public class Main {
    public static void main(String[] args){
        looper l=new looper();
        l.setOnTickListener(new OnTickListener() {
            @Override
            public void OnTick() {
                System.out.println("hello");
            }
        });
        l.Start();
    }
}
