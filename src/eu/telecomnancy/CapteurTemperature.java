package eu.telecomnancy;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/11/13
 * Time: 10:05
 */
public class CapteurTemperature extends Thread {
    private boolean state=false;
    private double start=-20;
    private double end=100;
    private double value;
    public boolean onOff() {
        state=!state;
        if (state) this.start();
        return state;
    }

    public double getTemperature() {
        return value;
    }

    @Override
    public void run() {
        while (state) {
            double random = (new Random()).nextDouble();
            value = start + (random * (end - start));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

    }
}
