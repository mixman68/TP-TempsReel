/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec.strat1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.lectrec.LectRect;

/**
 *
 * @author greg
 */
public class Ecrivain1 extends Thread {

    Semaphore MLecture, MEcriture;

    public Ecrivain1(Semaphore ecriture, Semaphore lecture) {
        this.MEcriture = ecriture;
        this.MLecture = lecture;
    }

    @Override
    public void run() {
        try {
            System.out.println("Ecrivain");
            MEcriture.acquire();
            int lower = 0;
            int higher = 3;
            int random = (int)(Math.random() * (higher-lower)) + lower;
            lower=0;
            higher=1000;
            int random2  = (int)(Math.random() * (higher-lower)) + lower;
            LectRect.tab[random]=random2;
            System.out.println("J'écris "+random2+" à la case "+random);
            MEcriture.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lecteur1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
