/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeenvironmentvariables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Properties;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jsf3
 */
public class StoreEnvironmentVariables extends Application {
    
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
    public static void main(String[] args) {
        
        try {
            boolean makeNew = true;
            String key = "";
            String value = "";
            
            Properties properties = new Properties();
            File file = new File("envvari.properties");
            
            
            FileOutputStream fileOut = new FileOutputStream(file);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            
            System.out.println("Type een key + value typ quit om op te slaan");

               while (line.equalsIgnoreCase("quit") == false) {
                   line = in.readLine();
                   
                   if(makeNew) {
                       key = line;
                       makeNew = false;
                   }
                   
                   else {
                       properties.setProperty(key, line);
                       makeNew = true;                    
                   }                  
               }

               in.close();
            
                properties.store(fileOut, "Environment variables");
                fileOut.close();                       
        }
        
         catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    } 
}
