package com.example.skladiste;

import Models.Stanje;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class StartMenuController implements Initializable {

    //labele
    @FXML
    public Label lblBordure;
    @FXML
    public Label lblPloce;
    @FXML
    public Label lblLjepila;
    @FXML
    public Label lblStanjeBordura;
    @FXML
    public Label lblStanjePloca;
    @FXML
    public Label lblStanjeLjepila;
    @FXML
    private Label lblOdaberi;

    //buttoni
    @FXML
    public Button btnStanjeBordure;
    @FXML
    public Button btnProvjeraPloce;
    @FXML
    public Button btnProvjeraLjepila;
    @FXML
    public Button izmijeni;

    //choice box-ovi
    @FXML
    private ChoiceBox<String> odabirBordure;
    @FXML
    private ChoiceBox<String> odabirPloce;
    @FXML
    private ChoiceBox<String> odabirLjepila;
    @FXML
    private ChoiceBox<String> odabirVrsteProizvoda;


    private final String[] vrsteProizvoda = {"Bordura","Ploca","Ljepilo"};
    private final Map<String, String> mapaBordura = new HashMap<>();
    private final Map<String, String> mapaPloca = new HashMap<>();
    private final Map<String, String> mapaLjepila = new HashMap<>();

    //bordure
    private ArrayList<String> vrsteBordura() throws IOException {
        File file = new File("bordure.txt");

        try {
            FileReader fr = new FileReader("bordure.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] str = currentLine.split(",");
                mapaBordura.put(str[0],str[2]);
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList(mapaBordura.keySet());
    }

    public void onClickStanjeBordure () {
        String bordura = odabirBordure.getSelectionModel().getSelectedItem();
        //dohvat stanja pomoću lambda izraza
        Stanje sb = () -> mapaBordura.get(bordura);
        lblStanjeBordura.setText(sb.dohvatiStanje());
    }

    //ploce
    private ArrayList<String> vrstePloca() throws IOException {
        File file = new File("ploce.txt");

        try {
            FileReader fr = new FileReader("ploce.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] str = currentLine.split(",");
                mapaPloca.put(str[0],str[2]);
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>(mapaPloca.keySet());
    }

    public void onClickStanjePloca () {
        String ploca = odabirPloce.getSelectionModel().getSelectedItem();
        //dohvat stanja pomoću lambda izraza
        Stanje sp = () -> mapaPloca.get(ploca);
        lblStanjePloca.setText(sp.dohvatiStanje());
    }

    //ljepila
    private ArrayList<String> vrsteLjepila() throws IOException {
        File file = new File("ljepila.txt");

        try {
            FileReader fr = new FileReader("ljepila.txt");
            BufferedReader br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] str = currentLine.split(",");
                mapaLjepila.put(str[0],str[2]);
            }

            fr.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList(mapaLjepila.keySet());
    }

    public void onClickStanjeLjepila () {
        String ljepilo = odabirLjepila.getSelectionModel().getSelectedItem();
        //dohvat stanja pomoću lambda izraza
        Stanje sl = () -> mapaLjepila.get(ljepilo);
        lblStanjeLjepila.setText(sl.dohvatiStanje());
    }


    //to initialize a controller after it's root element has already been processed
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        odabirVrsteProizvoda.getItems().addAll(vrsteProizvoda);
        try {
            odabirBordure.getItems().addAll(vrsteBordura());
            odabirPloce.getItems().addAll(vrstePloca());
            odabirLjepila.getItems().addAll(vrsteLjepila());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void onEditBtnClicked (ActionEvent event) throws IOException {
        String odabir = odabirVrsteProizvoda.getValue();
        Parent root;
        Stage stage;
        Scene scene;

        if (Objects.equals(odabir, "Bordura")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Bordure.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,600,400);
            stage.setTitle("Bordure");
            stage.setScene(scene);
            stage.show();
        } else if (Objects.equals(odabir, "Ploca")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ploce.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,600,400);
            stage.setTitle("Ploce");
            stage.setScene(scene);
            stage.show();
        } else if (Objects.equals(odabir, "Ljepilo")) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ljepila.fxml"));
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root,600,400);
            stage.setTitle("Ljepila");
            stage.setScene(scene);
            stage.show();
        } else {
            lblOdaberi.setText("Morate odabrati");
        }
    }



}
