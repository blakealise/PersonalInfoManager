module com.example.personalinfomanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.personalinfomanager to javafx.fxml;
    exports com.example.personalinfomanager;
}