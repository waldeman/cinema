module org.example.cinema {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cinema to javafx.fxml;
    exports org.example.cinema;
}