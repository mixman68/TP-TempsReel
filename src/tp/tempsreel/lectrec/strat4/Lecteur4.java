/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec.strat4;

import tp.tempsreel.lectrec.strat3.*;
import tp.tempsreel.lectrec.strat2.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.ech.Echauffement;
import tp.tempsreel.lectrec.LectRect;

/**
 *
 * @author greg
 */
public class Lecteur4 extends Thread {
    Semaphore MLecture,MEcriture,mutex2,mutex3,mutex1;
    static Integer counter = 0;
    private int timeWait = 0;
    private int id;
    
    public Lecteur4( Semaphore ecriture, Semaphore lecture,Semaphore mutex1, Semaphore mutex2, Semaphore mutex3, int timeWait, int id)
    {
        this.MEcriture = ecriture;
        this.MLecture = lecture;
        this.mutex2 = mutex2;
        this.mutex3=mutex3;
        this.mutex1=mutex1;
        this.timeWait=timeWait;
        this.id=id;
    }
        @Override
        public void run() {
        try {
            System.out.println("Lecteur "+id);
            mutex3.acquire();
                MLecture.acquire();
                mutex1.acquire();
                    counter++;
                    if(counter==1)
                        MEcriture.acquire();
                mutex1.release();
                MLecture.release();
            mutex3.release();
            Thread.sleep(timeWait);
            StringBuffer buff = new StringBuffer();
            buff.append("Lecture en cours par "+id+" : ");
            for(int i = 0 ; i < 3 ; i ++)
            {
                buff.append(LectRect.tab[i]);
                buff.append("   ");
            }
            System.out.println(buff.toString());
            mutex1.acquire();
                counter--;
                if(counter==0)
                    MEcriture.release();
            mutex1.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lecteur4.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
