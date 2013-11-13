package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;
import eu.telecomnancy.sensor.TemperatureSensor;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class App {

    private ISensor sensor;
    private Scanner console;

    public App() {
        this.sensor = new TemperatureSensor();
        this.console = new Scanner(System.in);
        manageCLI();
    }

    public static void main(String[] args) {
        new App();
    }

    public void manageCLI() {
        String rep = "";
        System.out.println("quit|q: quitter - on|o: switch - off|O: switch - status|s: status - update|u: refresh - value|v: value");
        while (!"q".equals(rep)) {
            try {
                System.out.print(":> ");
                rep = this.console.nextLine();
                if ("on".equals(rep) || "o".equals(rep)) {
                    this.sensor.on();
                    System.out.println("sensor turned on.");
                } else if ("off".equals(rep) || "O".equals(rep)) {
                    this.sensor.off();
                    System.out.println("sensor turned off.");
                } else if ("status".equals(rep) || "s".equals(rep)) {
                    System.out.println("status: " + this.sensor.getStatus());
                } else if ("update".equals(rep) || "u".equals(rep)) {
                    this.sensor.update();
                    System.out.println("sensor value refreshed.");
                } else if ("value".equals(rep) || "v".equals(rep)) {
                    System.out.println("value: " + this.sensor.getValue());
                } else {
                    System.out.println("quit|q: quitter - on|o: switch - off|O: switch - status|s: status - update|u: refresh - value|v: value");
                }
            } catch (SensorNotActivatedException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
