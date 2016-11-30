package eu.telecomnancy.ui;

import eu.telecomnancy.commands.Menu;
import eu.telecomnancy.sensor.ISensor;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

    private ISensor sensor;
    private SensorView sensorView;
    private Menu menu;

    public MainWindow(ISensor sensor) {
        this.sensor = sensor;
        this.sensorView = new SensorView(this.sensor);
        menu  = new Menu(this.sensor);
        
        setPreferredSize(new Dimension(450,200));

        this.setLayout(new BorderLayout());
        this.add(this.menu, BorderLayout.NORTH);
        this.add(this.sensorView, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }


}
