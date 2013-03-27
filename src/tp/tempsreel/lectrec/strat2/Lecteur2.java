/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec.strat2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.ech.Echauffement;
import tp.tempsreel.lectrec.LectRect;

/**
 *
 * @author greg
 */
public class Lecteur2 extends Thread {
    Semaphore MLecture,MEcriture,mutex2;
    static Integer counter = 0;
    private int timeWait = 0;
    private int id;
    
    public Lecteur2( Semaphore ecriture, Semaphore lecture, Semaphore mutex2, int timeWait, int id)
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
            System.out.println("Lecteur "+id);
            MLecture.acquire();
                counter++;
                if(counter==1)
                    MEcriture.acquire();
            MLecture.release();
            StringBuffer buff = new StringBuffer();
            buff.append("Lecture en cours par "+id+" : ");
            for(int i = 0 ; i < 3 ; i ++)
            {
                buff.append(LectRect.tab[i]);
                buff.append("   ");
            }
            Thread.sleep(1000);
            System.out.println(buff.toString());
            MLecture.acquire();
                counter--;
                if(counter==0)
                    MEcriture.release();
            MLecture.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lecteur2.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
