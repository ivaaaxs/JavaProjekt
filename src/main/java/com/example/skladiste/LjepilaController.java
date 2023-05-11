package com.example.skladiste;

import Models.Ljepilo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LjepilaController {

    //labele
    @FXML
    private Label lblPromjena;
    @FXML
    private Label lblNaziv;
    @FXML
    private Label lblCijena;
    @FXML
    private Label lblKolicina;
    @FXML
    private Label lblSifra;
    @FXML
    private Label lblProizvodac;
    @FXML
    private Label lblRokTrajanja;

    //tekstualna polja
    @FXML
    private TextField naziv;
    @FXML
    private TextField cijena;
    @FXML
    private TextField kolicina;
    @FXML
    private TextField sifra;
    @FXML
    private TextField proizvodac;
    @FXML
    private TextField rokTrajanja;
    @FXML
    private TextField nazivPodaci;

    @FXML
    void onBackClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartMenu.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onObrisiClicked() throws IOException {
        File file = new File("ljepila.txt");
        File tmpFile = new File("tmpFile.txt");
        tmpFile.createNewFile();

        String currentLine;

        try {
            FileWriter fw = new FileWriter("tmpFile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("ljepila.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(naziv.getText())) {
                } else {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        file.delete();
        File f = new File("ljepila.txt");
        tmpFile.renameTo(f);
        lblPromjena.setText("Ljepilo je uspjesno obrisano!");
    }

    public static Date getDateWithoutTime() throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.parse(simpleDateFormat.format(new Date()));
    }


    @FXML
    void onDajPodatkeClicked() {
        File file = new File("ljepila.txt");

        try {
            FileReader fr = new FileReader("ljepila.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(nazivPodaci.getText())) {
                    String[] str = currentLine.split(",");
                    lblNaziv.setText(str[0]);
                    lblCijena.setText(str[1]);
                    lblKolicina.setText(str[2]);
                    lblSifra.setText(str[3]);
                    lblProizvodac.setText(str[4]);
                    lblRokTrajanja.setText(str[5]);
                }
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onUrediClicked() throws IOException, ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(rokTrajanja.getText());
        Ljepilo ljepilo = new Ljepilo(naziv.getText(),Double.parseDouble(cijena.getText()),Integer.parseInt(kolicina.getText()),Integer.parseInt(sifra.getText()),proizvodac.getText(),date);
        ljepilo.prikazi();
        ljepilo.prikaziKolicinu();
        File file = new File("ljepila.txt");
        File tmpFile = new File("tmpFile.txt");
        tmpFile.createNewFile();

        String currentLine;

        try {
            FileWriter fw = new FileWriter("tmpFile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("ljepila.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(naziv.getText())) {
                    pw.println(ljepilo);
                } else {
                    pw.println(currentLine);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        file.delete();
        File f = new File("ljepila.txt");
        tmpFile.renameTo(f);
        lblPromjena.setText("Ljepilo je uspjesno uredeno!");
    }

    @FXML
    void onDodajClicked() {
        Ljepilo ljepilo = new Ljepilo(naziv.getText(),Double.parseDouble(cijena.getText()),Integer.parseInt(kolicina.getText()),Integer.parseInt(sifra.getText()),proizvodac.getText(),new Date(rokTrajanja.getText()));
        ljepilo.prikazi();
        ljepilo.prikaziKolicinu();
        try {
            File file = new File("ljepila.txt");
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ljepilo +"\n");
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        lblPromjena.setText("Ljepilo je uspjesno dodano!");
    }
}
