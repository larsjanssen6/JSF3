/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timeutil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erik
 */
public class MetingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // maak een timestamp object t.b.v. tijdsmetingen
            TimeStamp ts = new TimeStamp();
            
            // start een periode
            ts.setBegin("begin van de meting");

            // uitvoering van te meten code, gesimuleerd door een sleep
            Thread.sleep(200);

            // tussentijdse timestamp
            ts.setEnd("na deel 1 van werk");

            // uitvoering van tweede deel te meten code, gesimuleerd door een sleep
            Thread.sleep(400);

            // zet eindtijd
            ts.setEnd("na deel 2 van werk");
            
            // uitvoering van derde deel te meten code, gesimuleerd door een sleep
            Thread.sleep(300);
            
            // zet eindtijd en begin nieuwe periode
            ts.setEndBegin("begin weekend");
            
            // uitvoering van weekend deel te meten code, gesimuleerd door een sleep
            Thread.sleep(666);
            
            // zet eindtijd
            ts.setEnd("eind weekend");
            
            //
            System.out.print(ts.toString());

        } catch (InterruptedException ex) {
            Logger.getLogger(MetingDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("sleep was interrupted. run programma opnieuw");
        }
    }
}
