package com.example.skladiste;

import Models.Ljepilo;
import Models.StiropornaBrodura;
import Models.StiropornaPloca;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Date;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Skladiste");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        //bordure
        StiropornaBrodura e1 = new StiropornaBrodura("E1",17.95,192,222,"Marbet","E");
        StiropornaBrodura e2 = new StiropornaBrodura("E2",12.24,256,223,"Marbet","E");
        StiropornaBrodura e3 = new StiropornaBrodura("E3",18.92,500,224,"Marbet","E");
        StiropornaBrodura e4 = new StiropornaBrodura("E4",28.92,121,225,"Marbet","E");
        StiropornaBrodura e5 = new StiropornaBrodura("E5",22.43,56,226,"Marbet","E");
        StiropornaBrodura e6 = new StiropornaBrodura("E6",25.60,300,227,"Marbet","E");
        StiropornaBrodura e10 = new StiropornaBrodura("E10",23.40,92,231,"Marbet","E");
        StiropornaBrodura e18 = new StiropornaBrodura("E18",10.50,353,239,"Marbet","E");
        StiropornaBrodura e19 = new StiropornaBrodura("E19",9.81,951,240,"Marbet","E");
        StiropornaBrodura e34 = new StiropornaBrodura("E34",35.60,12,255,"Marbet","E");

        StiropornaBrodura b1 = new StiropornaBrodura("B1", 27.57,52,346,"Marbet","B");
        StiropornaBrodura b2 = new StiropornaBrodura("B2", 29.13,50,347,"Marbet","B");
        StiropornaBrodura b3 = new StiropornaBrodura("B3", 35.65,122,348,"Marbet","B");
        StiropornaBrodura b7 = new StiropornaBrodura("B7", 32.92,66,352,"Marbet","B");
        StiropornaBrodura b8 = new StiropornaBrodura("B8", 22.12,11,353,"Marbet","B");
        StiropornaBrodura b11 = new StiropornaBrodura("B11", 41.51,55,356,"Marbet","B");
        StiropornaBrodura b13 = new StiropornaBrodura("B13", 42.15,44,358,"Marbet","B");
        StiropornaBrodura b17 = new StiropornaBrodura("B17", 52.16,49,362,"Marbet","B");
        StiropornaBrodura b18 = new StiropornaBrodura("B18", 35.75,54,363,"Marbet","B");
        StiropornaBrodura b19 = new StiropornaBrodura("B19", 24.64,55,364,"Marbet","B");


        //ploce
        StiropornaPloca anet = new StiropornaPloca("Anet",17.97,236,19,"Marbet",32);
        StiropornaPloca chicago = new StiropornaPloca("Chicago",19.18,300,22,"Marbet",32);
        StiropornaPloca grono = new StiropornaPloca("Grono",22.32,305,55,"Marbet",32);
        StiropornaPloca grys = new StiropornaPloca("Grys",12.11,222,57,"Marbet",50);
        StiropornaPloca jesien = new StiropornaPloca("Jesien",15.11,42,51,"Marbet",32);
        StiropornaPloca len = new StiropornaPloca("Len",19.96,252,44,"Marbet",32);
        StiropornaPloca manhattan = new StiropornaPloca("Manhattan",22.32,523,12,"Marbet",50);
        StiropornaPloca norma = new StiropornaPloca("Norma",11.15,36,15,"Marbet",32);
        StiropornaPloca paris = new StiropornaPloca("Paris",12.13,52,31,"Marbet",50);
        StiropornaPloca pyrmont = new StiropornaPloca("Pyrmont",12.20,65,32,"Marbet",32);
        StiropornaPloca putz = new StiropornaPloca("Putz",18.90,11,36,"Marbet",50);
        StiropornaPloca skora = new StiropornaPloca("Skora",35.65,0,44,"Marbet",32);
        StiropornaPloca welle2 = new StiropornaPloca("Welle2",12.11,182,46,"Marbet",32);
        StiropornaPloca zefir = new StiropornaPloca("Zefir",16.32,72,122,"Marbet",32);
        StiropornaPloca zima = new StiropornaPloca("Zima",18.11,42,131,"Marbet",50);

        //ljepila
        Ljepilo supr = new Ljepilo("Super",15.22,20,296,"Marbet",new Date(2025,04,12));
        Ljepilo akryl = new Ljepilo("Akryl",12.15,52,270,"Marbet",new Date(2025,04,12));
        Ljepilo premium = new Ljepilo("Premium",10.11,95,103,"Marbet",new Date(2025,04,12));
        Ljepilo plus15 = new Ljepilo("Plus1.5kg",27.19,100,105,"Marbet",new Date(2026,01,01));
        Ljepilo plus4 = new Ljepilo("Plus4kg",69.72,50,106,"Marbet",new Date(2025,01,01));



        try {
            File file = new File("bordure.txt");

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(e1.toString()+"\n");
            bw.write(e2.toString()+"\n");
            bw.write(e3.toString()+"\n");
            bw.write(e4.toString()+"\n");
            bw.write(e5.toString()+"\n");
            bw.write(e6.toString()+"\n");
            bw.write(e10.toString()+"\n");
            bw.write(e18.toString()+"\n");
            bw.write(e19.toString()+"\n");
            bw.write(e34.toString()+"\n");
            bw.write(b1.toString()+"\n");
            bw.write(b2.toString()+"\n");
            bw.write(b3.toString()+"\n");
            bw.write(b7.toString()+"\n");
            bw.write(b8.toString()+"\n");
            bw.write(b11.toString()+"\n");
            bw.write(b13.toString()+"\n");
            bw.write(b17.toString()+"\n");
            bw.write(b18.toString()+"\n");
            bw.write(b19.toString()+"\n");
            bw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            File file = new File("ploce.txt");

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(anet.toString()+"\n");
            bw.write(chicago.toString()+"\n");
            bw.write(grono.toString()+"\n");
            bw.write(grys.toString()+"\n");
            bw.write(jesien.toString()+"\n");
            bw.write(len.toString()+"\n");
            bw.write(manhattan.toString()+"\n");
            bw.write(norma.toString()+"\n");
            bw.write(paris.toString()+"\n");
            bw.write(pyrmont.toString()+"\n");
            bw.write(putz.toString()+"\n");
            bw.write(skora.toString()+"\n");
            bw.write(welle2.toString()+"\n");
            bw.write(zefir.toString()+"\n");
            bw.write(zima.toString()+"\n");
            bw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            File file = new File("ljepila.txt");

            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(supr.toString()+"\n");
            bw.write(akryl.toString()+"\n");
            bw.write(premium.toString()+"\n");
            bw.write(plus15.toString()+"\n");
            bw.write(plus4.toString()+"\n");
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        launch();
    }
}