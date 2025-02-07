module org.example.two {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.two to javafx.fxml;
    exports org.example.two;
}