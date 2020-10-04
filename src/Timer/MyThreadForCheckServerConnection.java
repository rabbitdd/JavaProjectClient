package Timer;

import main.Client;

import java.util.TimerTask;
public class MyThreadForCheckServerConnection implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(30000);
            System.out.println("Время ожидания сервера превышено.");
            System.exit(0);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }

    }

}
