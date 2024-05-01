package com.example.inventorybonus;
import java.io.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Inventory inventory = loadInventory("savedInventory.dat");



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void saveInventory(Inventory i, String file){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
            outputStream.writeObject(i);
        }catch (IOException exception){}
    }
    public static Inventory loadInventory(String file){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            return (Inventory) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException exception){return new Inventory();}
    }
    public static void main(String[] args) {
        launch(args);
    }
}