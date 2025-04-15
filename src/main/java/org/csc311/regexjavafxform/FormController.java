package org.csc311.regexjavafxform;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.*;

/**
 * @author Jose Hernandez
 */
public class FormController {
    @FXML
    private Label firstNamePrompt;
    @FXML
    private Label lastNamePrompt;
    @FXML
    private Label dobPrompt;
    @FXML
    private Label emailPrompt;
    @FXML
    private TextField zipcodeField;
    @FXML
    private TextField emailField;
    @FXML
    private Label zipcodePrompt;
    @FXML
    private Button addButton;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField dobField;
}