package eu.telecomnancy.sensor;


public interface ISensor extends Observable {
    /**
     * Enable the sensor.
     */
    public void on();

    /**
     * Disable the sensor.
     */
    public void off();

    /**
     * Get the status (enabled/disabled) of the sensor.
     *
     * @return the current sensor's status.
     */
    public boolean getStatus();

    /**
     * Tell the sensor to acquire a new value.
     *
     * @throws SensorNotActivatedException if the sensor is not activated.
     */
    public void update() throws SensorNotActivatedException;

    /**
     * Get the latest value recorded by the sensor.
     *
     * @return the last recorded value.
     * @throws SensorNotActivatedException if the sensor is not activated.
     */
    public double getValue() throws SensorNotActivatedException;
    
    /**
     * Set the value recorded by the sensor.
     */
    public void setValue(double value);
    
    /**
     * Get the temperature scale used by the sensor.
     *
     * @return the temperature scale.
     */
    public TemperatureScale getScale();

    /**
     * Set the temperature scale used by the sensor.
     */
	public void setScale(TemperatureScale scale);

}
