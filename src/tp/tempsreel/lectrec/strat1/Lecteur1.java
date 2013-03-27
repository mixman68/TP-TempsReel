/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec.strat1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.ech.Echauffement;
import tp.tempsreel.lectrec.LectRect;

/**
 *
 * @author greg
 */
public class Lecteur1 extends Thread {
    Semaphore MLecture,MEcriture;
    static Integer counter = 0;
    
    public Lecteur1( Semaphore ecriture, Semaphore lecture)
    {
        this.MEcriture = ecriture;
        this.MLecture = lecture;
    }
        @Override
        public void run() {
        try {
            System.out.println("Lecteur");
            MLecture.acquire();
                counter++;
                if(counter==1)
                    MEcriture.acquire();
            MLecture.release();
            StringBuffer buff = new StringBuffer();
            buff.append("Lecture en cours \n");
            for(int i = 0 ; i < 3 ; i ++)
            {
                buff.append(LectRect.tab[i]);
                buff.append("   ");
            }
            System.out.println(buff.toString());
            MLecture.acquire();
                counter--;
                if(counter==0)
                    MEcriture.release();
            MLecture.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lecteur1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
