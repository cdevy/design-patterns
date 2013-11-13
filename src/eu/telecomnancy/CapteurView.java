package eu.telecomnancy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/11/13
 * Time: 11:30
 */
public class CapteurView extends JPanel {
    ICapteur capteur;
    JLabel value=new JLabel();
    JButton on=new JButton();
    JButton off=new JButton();
    JButton update=new JButton();

    public CapteurView(ICapteur c) {
        capteur=c;
        this.setLayout(new GridLayout(2, 2));
        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capteur.on();
            }
        });
        off.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capteur.off();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    capteur.update();
                } catch (CapteurNotActivated capteurNotActivated) {
                    capteurNotActivated.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        });
        this.add(value);
        this.add(update);
        this.add(on);
        this.add(off);
    }
}
