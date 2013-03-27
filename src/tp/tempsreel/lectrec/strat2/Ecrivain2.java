/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec.strat2;

import tp.tempsreel.lectrec.strat1.Lecteur1;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.lectrec.LectRect;

/**
 *
 * @author greg
 */
public class Ecrivain2 extends Thread {
    Semaphore MLecture,MEcriture,mutex2;
    static Integer counter = 0;
    private int timeWait = 0;
    private int id;
    
    public Ecrivain2( Semaphore ecriture, Semaphore lecture, Semaphore mutex2, int timeWait, int id)
    {
        this.MEcriture = ecriture;
        this.MLecture = lecture;
        this.mutex2 = mutex2;
        this.timeWait=timeWait;
        this.id=id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Ecrivain "+id);
            mutex2.acquire();
            MEcriture.acquire();
            Thread.sleep(timeWait);
            int lower = 0;
            int higher = 3;
            int random = (int)(Math.random() * (higher-lower)) + lower;
            lower=0;
            higher=1000;
            int random2  = (int)(Math.random() * (higher-lower)) + lower;
            LectRect.tab[random]=random2;
            System.out.println("Je suis "+id+" et j'écris "+random2+" à la case "+random);
            MEcriture.release();
            mutex2.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lecteur1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
