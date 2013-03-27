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
public class Consommateur extends Thread {
  
  private final int i;
  final List<Integer> q;
  
  Consommateur(int i, List<Integer> q) { 
    this.i = i;
    this.q = q;
  }

  public void run() {
      while(true) { 
	consomme(this.q.get(0)); 
        this.q.remove(0);
      }
  }

  void consomme(Integer x) { 
    try{
      System.out.println("Consommateur["+i+"] : "+x);
      Thread.currentThread().sleep(800);
    } catch (Exception e) {
    }
  }
}
