package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class UpdateSensor implements Command {

	private ISensor sensor;
	
	public UpdateSensor(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		try {
			sensor.update();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
	}
}
