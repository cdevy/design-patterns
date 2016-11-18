package eu.telecomnancy.ui;

import eu.telecomnancy.sensor.ISensor;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    private ISensor sensor;
    private SensorView sensorView;

    public MainWindow(ISensor sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);

        this.setLayout(new BorderLayout());
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
