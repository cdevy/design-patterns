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
import java.rmi.RemoteException;


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

    public void menu() throws RemoteException {
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

//   Code pour JDK 1.6
//
//       public void menu6() {
//        String rep="";
//        while (!"q".equals(rep)) {
//            try {
//                rep= c.nextLine();
//                if ("o".equals(rep))
//                        sense.onOff();
//                else if ("s".equals(rep))
//                        System.out.println("status :"+sense.getStatus());
//                else if ("v".equals(rep))
//                        System.out.println("value :"+sense.getValue());
//                else System.out.println("q: quitter - o: switch - s: status - v: value");
//            } catch (SensorNotActivated ex) {
//                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
