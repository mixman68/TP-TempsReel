/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.prodcons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author greg
 */
public class ProdCons {
    public static final List<Integer> q = new ArrayList<Integer>(1);
    //public static final Semaphore NVide, NPlein;
    
    public static void main(String[] args)
    {
        Producteur[] producteurs = new Producteur[2];
        Consommateur[] consommateurs = new Consommateur[5];
        
        //On génère les producteurs et on les lances
        for(int i = 0; i<producteurs.length; i++)
        {
            producteurs[i] = new Producteur(i,q);
            producteurs[i].start();
        }
        
        //On génère les consommateurs
        for(int i = 0; i<consommateurs.length; i++)
        {
            consommateurs[i] = new Consommateur(i,q);
            consommateurs[i].start();
        }
    }
}
