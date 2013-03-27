/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.tempsreel.prodcons;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author greg
 */
public class Producteur extends Thread {
    
    int i;
    final List<Integer> q;
    Producteur(int i,List<Integer> q)
    {
        this.i=i;
        this.q = q;
    }
  public void run() {
      while(true) { 
	this.q.add(produit()); 
      }
  }
  Integer produit() { 
    Integer nb = new Integer((int)(Math.random()*100));  
    try{
      System.out.println("Producteur["+i+"] : "+nb);
      Thread.currentThread().sleep(500);
    } catch (Exception e) {
       }
    return nb;
  }
}
