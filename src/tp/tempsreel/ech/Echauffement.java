/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.ech;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp.tempsreel.TPTempsReel;

/**
 *
 * @author greg
 */
public class Echauffement extends Thread {
    public static final Semaphore mutex = new Semaphore(1,true); // Mutex partagé entre tous les threads
    public static int compteur = 0; // compteur commun à tout le monde
    Semaphore m_mutex;
    int i;
    public Echauffement(int i,Semaphore mutex) {
        super();
        this.i=i;
        this.m_mutex=mutex;
    }

    @Override
    public void run() {
            try {
                this.m_mutex.acquire(); //P(mutex)
                Echauffement.compteur++;
                this.m_mutex.release(); //V(mutex)
            } catch (InterruptedException ex) {
                Logger.getLogger(Echauffement.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Echauffement[] ech = new Echauffement[1000];
            
            for(int i = 0 ; i < ech.length;i++)
            {
                ech[i] = new Echauffement(i,Echauffement.mutex);
                ech[i].start();
            }
            for(int i = 0 ; i < ech.length;i++)
                ech[i].join();
            
            System.out.println(Echauffement.compteur);
        } catch (InterruptedException ex) {
            Logger.getLogger(Echauffement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
