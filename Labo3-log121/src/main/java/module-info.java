module org.example.labo3log121 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.labo3log121 to javafx.fxml;
    exports org.example.labo3log121;
}