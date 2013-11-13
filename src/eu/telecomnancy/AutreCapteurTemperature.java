package eu.telecomnancy;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/11/13
 * Time: 13:38
 */
public class AutreCapteurTemperature implements ICapteur {
    boolean state;
    double value=0;
    @Override
    public void on() {
        state=true;
    }

    @Override
    public void off() {
        state=false;
    }

    @Override
    public void update() throws CapteurNotActivated {
        if (state)
            value=(new Random()).nextDouble()*100;
        else throw new CapteurNotActivated("allume moi d'abord");
    }

    @Override
    public double getValue() throws CapteurNotActivated {
        if (state)
            return value;
        else throw new CapteurNotActivated("allume moi d'abord");
    }

    @Override
    public boolean getStatus() {
        return state;
    }
}
