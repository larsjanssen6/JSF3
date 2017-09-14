/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf31_w03_os_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jsf3
 */
public class Run extends Thread {
    
    String command;
    String param;
    
    Run(String command, String param) {
        this.command = command;
        this.param = param;
    }

    @Override
    public void run() {
        ProcessBuilder pb2 = new ProcessBuilder(this.command, this.param);
        Process proc3 = null;
        
        try {
            proc3 = pb2.start();
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        InputStream is = proc3.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line;

        try {
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Command " + this.command + " is terminated");
        proc3.destroy();
    }
    
}
