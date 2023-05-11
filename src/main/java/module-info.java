module com.example.skladiste {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.skladiste to javafx.fxml;
    exports com.example.skladiste;
}