package eu.telecomnancy.commands;

import eu.telecomnancy.sensor.DecoratorRoundValue;
import eu.telecomnancy.sensor.ISensor;

public class RoundSensorValue implements Command {
	
	private ISensor sensor;
	
	public RoundSensorValue(ISensor sensor) {
		this.sensor = sensor;
	}

	public void execute() {
		if (sensor != null) {
			((DecoratorRoundValue) sensor).round();
		}
	}
}
