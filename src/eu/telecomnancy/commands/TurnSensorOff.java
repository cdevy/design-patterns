package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.ISensor;

public class TurnSensorOff implements Command {

	private ISensor sensor;
	
	public TurnSensorOff(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		sensor.off();
	}
}
