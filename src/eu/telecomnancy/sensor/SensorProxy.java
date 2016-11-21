package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.Observer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SensorProxy implements ISensor {
	
	private ISensor sensor;
	private SensorLogger logger = new SimpleSensorLogger();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private LocalDateTime now;
	
	public SensorProxy(ISensor sensor) {
		this.sensor = sensor;
	}

	public void attach(Observer o) {
		if (sensor != null) {
			sensor.attach(o);
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", attach(Observer o), void");
		}
	}

	public void detach(Observer o) {
		if (sensor != null) {
			sensor.detach(o);
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", detach(Observer o), void");
		}
	}

	public void notifyObserver() {
		if (sensor != null) {
			sensor.notifyObserver();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", notifyObserver(), void");
		}
	}

	public void on() {
		if (sensor != null) {
			sensor.on();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", on(), void");
		}
	}

	public void off() {
		if (sensor != null) {
			sensor.off();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", off(), void");
		}
	}

	public boolean getStatus() {
		boolean res = false;
		if (sensor != null) {
			res = sensor.getStatus();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", getStatus(), " + res);	
		}	
		return res;
	}

	public void update() throws SensorNotActivatedException {
		if (sensor != null) {
			sensor.update();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", update(), void");
		}
	}

	public double getValue() throws SensorNotActivatedException {
		double res = 0;
		if (sensor != null) {
			res = sensor.getValue();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", getValue(), " + res);	
		}	
		return res;
	}

}
