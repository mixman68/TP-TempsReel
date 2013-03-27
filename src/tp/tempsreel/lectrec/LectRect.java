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
import tp.tempsreel.lectrec.strat3.Ecrivain3;
import tp.tempsreel.lectrec.strat3.Lecteur3;
import tp.tempsreel.lectrec.strat4.Ecrivain4;
import tp.tempsreel.lectrec.strat4.Lecteur4;


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
            final Semaphore mutex3 = new Semaphore(1);
            final Semaphore mutex1 = new Semaphore(1);
            
            //static counter = 0;
            for (int i = 0 ;i < 3 ; i++)
            {
                tab[i]=0;
            }
            
            //Stratégie 1
            /*
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
           */
            /* Stratégie 2 */
            /*
            Lecteur2[] lecteurs2 = new Lecteur2[5];
            Ecrivain2[] ecrivains2 = new Ecrivain2[5];
            
            lecteurs2[1] = new Lecteur2(MEcriture,MLecture,mutex2,3000,1);
            lecteurs2[2] = new Lecteur2(MEcriture,MLecture,mutex2,10,2);
            lecteurs2[3] = new Lecteur2(MEcriture,MLecture,mutex2,10,3);
            lecteurs2[4] = new Lecteur2(MEcriture,MLecture,mutex2,10,4);
            lecteurs2[0] = new Lecteur2(MEcriture,MLecture,mutex2,10,5);
            
            ecrivains2[1] = new Ecrivain2(MEcriture,MLecture,mutex2,10,2);
            ecrivains2[2] = new Ecrivain2(MEcriture,MLecture,mutex2,10,3);      
            ecrivains2[0] = new Ecrivain2(MEcriture,MLecture,mutex2,1000,1);
               
            lecteurs2[0].start();
            lecteurs2[1].start();
            ecrivains2[0].start();
            lecteurs2[2].start();
            ecrivains2[1].start();
            lecteurs2[3].start();
            ecrivains2[2].start();
            lecteurs2[4].start();
            
            */
            
            /* stratégie 3 */
            /*
            Lecteur3[] lecteurs3 = new Lecteur3[5];
            Ecrivain3[] ecrivains3 = new Ecrivain3[5];
            
            lecteurs3[1] = new Lecteur3(MEcriture,MLecture,mutex2,3000,2);
            lecteurs3[2] = new Lecteur3(MEcriture,MLecture,mutex2,10,3);
            lecteurs3[3] = new Lecteur3(MEcriture,MLecture,mutex2,10,4);
            lecteurs3[4] = new Lecteur3(MEcriture,MLecture,mutex2,10,5);
            lecteurs3[0] = new Lecteur3(MEcriture,MLecture,mutex2,10,1);
            
            ecrivains3[1] = new Ecrivain3(MEcriture,MLecture,mutex2,10,2);
            ecrivains3[2] = new Ecrivain3(MEcriture,MLecture,mutex2,10,3);      
            ecrivains3[0] = new Ecrivain3(MEcriture,MLecture,mutex2,1000,1);
               
            lecteurs3[0].start();
            lecteurs3[1].start();
            ecrivains3[0].start();
            lecteurs3[2].start();
            ecrivains3[1].start();
            lecteurs3[3].start();
            ecrivains3[2].start();
            lecteurs3[4].start();
            */
            /* stratégie 4 */
            Lecteur4[] lecteurs4 = new Lecteur4[5];
            Ecrivain4[] ecrivains4 = new Ecrivain4[5];
            
            lecteurs4[1] = new Lecteur4(MEcriture,MLecture,mutex1,mutex2,mutex3,3000,2);
            lecteurs4[2] = new Lecteur4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,3);
            lecteurs4[3] = new Lecteur4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,4);
            lecteurs4[4] = new Lecteur4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,5);
            lecteurs4[0] = new Lecteur4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,1);
            
            ecrivains4[1] = new Ecrivain4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,2);
            ecrivains4[2] = new Ecrivain4(MEcriture,MLecture,mutex1,mutex2,mutex3,10,3);      
            ecrivains4[0] = new Ecrivain4(MEcriture,MLecture,mutex1,mutex2,mutex3,1000,1);
               
            lecteurs4[0].start();
            lecteurs4[1].start();
            ecrivains4[0].start();
            lecteurs4[2].start();
            ecrivains4[1].start();
            lecteurs4[3].start();
            ecrivains4[2].start();
            lecteurs4[4].start();
            
                   
            
        }
}
