package com.example.skladiste;

import Models.StiropornaPloca;
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

public class PloceController {

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
    private Label lblBrKomUPak;

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
    private TextField brKomUPak;
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
        File file = new File("ploce.txt");
        File tmpFile = new File("tmpFile.txt");
        tmpFile.createNewFile();

        String currentLine;

        try {
            FileWriter fw = new FileWriter("tmpFile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("ploce.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(naziv.getText())) {
                    continue;
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
        File f = new File("ploce.txt");
        tmpFile.renameTo(f);
        lblPromjena.setText("Ploca je uspjesno obrisana!");
    }

    @FXML
    void onDajPodatkeClicked() {
        File file = new File("ploce.txt");

        try {
            FileReader fr = new FileReader("ploce.txt");
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
                    lblBrKomUPak.setText(str[5]);
                }
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onUrediClicked() throws IOException {
        StiropornaPloca stiropornaPloca = new StiropornaPloca(naziv.getText(),Double.parseDouble(cijena.getText()),Integer.parseInt(kolicina.getText()),Integer.parseInt(sifra.getText()),proizvodac.getText(),Integer.parseInt(brKomUPak.getText()));
        stiropornaPloca.prikazi();
        stiropornaPloca.prikaziKolicinu();
        File file = new File("ploce.txt");
        File tmpFile = new File("tmpFile.txt");
        tmpFile.createNewFile();

        String currentLine;

        try {
            FileWriter fw = new FileWriter("tmpFile.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("ploce.txt");
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                if (currentLine.contains(naziv.getText())) {
                    pw.println(stiropornaPloca);
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
        File f = new File("ploce.txt");
        tmpFile.renameTo(f);
        lblPromjena.setText("Ploca je uspjesno uređena!");
    }

    @FXML
    void onDodajClicked() {
        StiropornaPloca stiropornaPloca = new StiropornaPloca(naziv.getText(),Double.parseDouble(cijena.getText()),Integer.parseInt(kolicina.getText()),Integer.parseInt(sifra.getText()),proizvodac.getText(),Integer.parseInt(brKomUPak.getText()));
        stiropornaPloca.prikazi();
        stiropornaPloca.prikaziKolicinu();
        try {
            File file = new File("ploce.txt");
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stiropornaPloca +"\n");
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        lblPromjena.setText("Ploca je uspjesno dodana!");
    }
}
