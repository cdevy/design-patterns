package eu.telecomnancy;

/**
 * Created with IntelliJ IDEA.
 * User: charoy
 * Date: 13/11/13
 * Time: 10:27
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author charoy
 */
public class Client {
    ICapteur capteur;
    Scanner c=new Scanner(System.in);
    public Client(ICapteur c) {
        capteur=c;
    }

    public void menu()  {
        char rep='x';
        while (rep != 'q') {
            try {
                rep= c.nextLine().charAt(0);
                switch (rep) {
                    case 'o': {
                        capteur.on();
                        break;
                    }
                    case 'f': {
                        capteur.off();
                        break;
                    }
                    case 's': {
                        System.out.println("status :"+capteur.getStatus());
                        break;
                    }
                    case 'v': {
                        capteur.update();
                        System.out.println("value :"+capteur.getValue());
                        break;
                    }
                    default : System.out.println("q: quitter - o: on - f: off - s: status - v: value");
                }
            } catch (CapteurNotActivated ex) {
                System.out.println("Le capteur est éteint. Il faut d'abord l'allumer");
            }
        }
    }

}
