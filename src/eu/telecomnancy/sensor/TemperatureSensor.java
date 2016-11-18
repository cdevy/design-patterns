package eu.telecomnancy.sensor;

import java.util.Random;

import eu.telecomnancy.ui.Observer;

public class TemperatureSensor implements ISensor {
    private boolean state;
    private double value = 0;
    private Observer observer;

    public void on() {
        state = true;
    }

    public void off() {
        state = false;
    }

    public boolean getStatus() {
        return state;
    }

    public void update() throws SensorNotActivatedException {
        if (state) {
            value = (new Random()).nextDouble() * 100;
            notifyObserver();
        }
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }

	public void attach(Observer o) {
		if (observer == null) {
			observer = o;
		} else {
			System.out.println("Observer could not be attached to Adapter: Adapter must have only one Observer!");
		}
	}

	public void detach(Observer o) {
		if (observer.equals(o)) {
			observer = null;
		} else {
			System.out.println("Observer could not be detached from Adapter because it was not attached to it.");
		}
	}

	public void notifyObserver() {
		if (observer != null) {
			observer.update();
		}
	}
}
