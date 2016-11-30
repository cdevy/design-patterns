package eu.telecomnancy.sensor;

import eu.telecomnancy.ui.Observer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProxySensor implements ISensor {
	
	private ISensor sensor;
	private SensorLogger logger;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private LocalDateTime now;
	
	public ProxySensor(ISensor sensor) {
		this.sensor = sensor;
		logger = new SimpleSensorLogger();
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
			if (sensor.getStatus()) {
				now = LocalDateTime.now();
				logger.log(LogLevel.INFO, dtf.format(now) + ", update(), void");
				sensor.update();
			} else throw new SensorNotActivatedException("Sensor must be activated to get its value.");	
		}
	}

	public double getValue() throws SensorNotActivatedException {
		double res = -1;
		if (sensor != null) {
			if (sensor.getStatus()) {
				res = sensor.getValue();
				now = LocalDateTime.now();
				logger.log(LogLevel.INFO, dtf.format(now) + ", getValue(), " + res);
			} else throw new SensorNotActivatedException("Sensor must be activated to get its value.");	
		}	
		return res;
	}
	
	public void setValue(double value) {
		if (sensor != null) {
			if (sensor.getStatus()) {
				sensor.setValue(value);
				now = LocalDateTime.now();
				logger.log(LogLevel.INFO, dtf.format(now) + ", setValue(double value), void");
			}
		}
	}
	
	public TemperatureScale getScale() {
		TemperatureScale res = TemperatureScale.CELSIUS;
		if (sensor != null) {
			res = sensor.getScale();
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", getScale(), " + res);
		}	
		return res;
	}

	public void setScale(TemperatureScale scale) {
		if (sensor != null) {
			sensor.setScale(scale);
			now = LocalDateTime.now();
			logger.log(LogLevel.INFO, dtf.format(now) + ", setScale(TemperatureScale scale), void");
		}
	}

}
