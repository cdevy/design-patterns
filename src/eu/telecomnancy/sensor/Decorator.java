package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.Observer;
import eu.telecomnancy.ui.SensorView;

@SuppressWarnings("unused")
public abstract class Decorator implements ISensor {
	
	protected ISensor sensor;
	
	public Decorator(ISensor sensor) {
		this.sensor = sensor;
	}

	public void attach(Observer o) {
		if (sensor != null) {
			sensor.attach(o);
		}
	}

	public void detach(Observer o) {
		if (sensor != null) {
			sensor.detach(o);
		}
	}

	public void notifyObserver() {
		if (sensor != null) {
			sensor.notifyObserver();
		}
	}

	public void on() {
		if (sensor != null) {
			sensor.on();
		}
	}

	public void off() {
		if (sensor != null) {
			sensor.off();
		}
	}

	public boolean getStatus() {
		if (sensor != null) {
			return sensor.getStatus();
		}	
		return false;
	}

	public void update() throws SensorNotActivatedException {
		if (sensor != null) {
			if (sensor.getStatus()) {
				sensor.update();
			} else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
		}
	}

	public double getValue() throws SensorNotActivatedException {
		if (sensor != null) {
			if (sensor.getStatus()) {
				return sensor.getValue();
			} else throw new SensorNotActivatedException("Sensor must be activated to get its value.");	
		}
		return -1;
	}

}
