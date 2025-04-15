module org.csc311.regexjavafxform {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.csc311.regexjavafxform to javafx.fxml;
    exports org.csc311.regexjavafxform;
}