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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import timeutil.TimeStamp;

/**
 *
 * @author jsf3
 */
public class JSF31_w03_OS_process extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        TimeStamp ts = new TimeStamp();
        ts.setBegin("Begin program");
      
        
        //Opdracht 3
        Runtime rt = Runtime.getRuntime();
        System.out.println("Aantal processoren: " + Integer.toString(rt.availableProcessors()));
        System.out.println("Max geheugen: " + rt.maxMemory());
        System.out.println("Vrij geheugen: " + rt.freeMemory());
        System.out.println("Geheugen dat momenteel in gebruik is: " + (rt.maxMemory() - rt.freeMemory()));
        
        //Opdracht 4
        String s;
        for(int i=0; i<100000; i++) {
            s = "Hello" + i;
        }
        
        System.out.println("Geheugen dat momenteel in gebruik is: " + (rt.maxMemory() - rt.freeMemory()));
        System.gc();
        System.out.println("Geheugen dat momenteel in grtebruik is na de garabase collector: " + (rt.maxMemory() - rt.freeMemory()));
       
        //Opdracht 5
        ProcessBuilder pb = new ProcessBuilder("gnome-calculator");
        Process proc = pb.start();
        Thread.sleep(6000);
        proc.destroy();
        Process proc2 = rt.exec("gnome-calculator");
        Thread.sleep(6000);
        proc2.destroy();
        
        //Opdracht 6
        ProcessBuilder pb2 = new ProcessBuilder("ls");
        Process proc3 = pb2.start();
        InputStream is = proc3.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        String line;
        
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        
        br.close();
        proc3.destroy();
        
        //Opdracht 8 toon de totale duur van het programma        
        ts.setEnd("Einde programma");
        System.out.print(ts.toString());


        //Opdracht 9 
        for(int i=0; i<args.length; i++) {
            Run runnable = new Run(args[i], args[i + 1]);
            runnable.start();
            i++;
        }
    }   
}
