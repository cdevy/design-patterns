package eu.telecomnancy;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/11/13
 * Time: 10:03
 */
public interface ICapteur {
    public void on();
    public void off();
    public void update() throws CapteurNotActivated ; // indique au capteur de mettre à jour sa valeur
    public double getValue() throws CapteurNotActivated;
    public boolean getStatus();
}
