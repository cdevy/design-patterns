package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.ISensor;

public class TurnSensorOn implements Command {
	
	private ISensor sensor;

	public TurnSensorOn(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		sensor.on();
	}
}
