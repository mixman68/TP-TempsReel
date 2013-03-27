/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.lectrec;

import tp.tempsreel.lectrec.strat2.Ecrivain2;
import tp.tempsreel.lectrec.strat2.Lecteur2;
import tp.tempsreel.lectrec.strat1.Lecteur1;
import tp.tempsreel.lectrec.strat1.Ecrivain1;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author greg
 */
public class LectRect {
    private static int counter;
    public static Integer[] tab = new Integer[3];
        public static void main(String[] args) {
            final Semaphore MLecture = new Semaphore(1);
            final Semaphore MEcriture = new Semaphore(1);
            final Semaphore mutex2 = new Semaphore(1);
            
            //static counter = 0;
            for (int i = 0 ;i < 3 ; i++)
            {
                tab[i]=0;
            }
            
            //Stratégie 1
            
            Lecteur1[] lecteurs1 = new Lecteur1[5];
            Ecrivain1[] ecrivains1 = new Ecrivain1[5];
            
            lecteurs1[1] = new Lecteur1(MEcriture,MLecture);
            lecteurs1[2] = new Lecteur1(MEcriture,MLecture);
            lecteurs1[3] = new Lecteur1(MEcriture,MLecture);
            lecteurs1[4] = new Lecteur1(MEcriture,MLecture);
            lecteurs1[0] = new Lecteur1(MEcriture,MLecture);
            
            ecrivains1[1] = new Ecrivain1(MEcriture,MLecture);
            ecrivains1[2] = new Ecrivain1(MEcriture,MLecture);      
            ecrivains1[0] = new Ecrivain1(MEcriture,MLecture);
            
            ecrivains1[0].start();
            lecteurs1[0].start();
            lecteurs1[1].start();
            lecteurs1[2].start();
            ecrivains1[1].start();
            lecteurs1[3].start();
            ecrivains1[2].start();
            lecteurs1[4].start();
           
            /* Stratégie 2 */
            Lecteur2[] lecteurs2 = new Lecteur2[5];
            Ecrivain2[] ecrivains2 = new Ecrivain2[5];
            
            lecteurs2[1] = new Lecteur2(MEcriture,MLecture,mutex2);
            lecteurs2[2] = new Lecteur2(MEcriture,MLecture,mutex2);
            lecteurs2[3] = new Lecteur2(MEcriture,MLecture,mutex2);
            lecteurs2[4] = new Lecteur2(MEcriture,MLecture,mutex2);
            lecteurs2[0] = new Lecteur2(MEcriture,MLecture,mutex2);
            
            ecrivains2[1] = new Ecrivain2(MEcriture,MLecture,mutex2);
            ecrivains2[2] = new Ecrivain2(MEcriture,MLecture,mutex2);      
            ecrivains2[0] = new Ecrivain2(MEcriture,MLecture,mutex2);
               
            ecrivains2[0].start();
            lecteurs2[0].start();
            lecteurs2[1].start();
            lecteurs2[2].start();
            ecrivains2[1].start();
            lecteurs2[3].start();
            ecrivains2[2].start();
            lecteurs2[4].start();
                    
            
        }
}
