package org.csc311.regexjavafxform;

import javafx.beans.value.ChangeListener;
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

    /**
     * Adds the listeners to the text fields in order to validate a user's input.
     */
    @FXML
    private void initialize() {
        firstNameField.textProperty().addListener(textFieldListener);
        lastNameField.textProperty().addListener(textFieldListener);
        emailField.textProperty().addListener(textFieldListener);
        dobField.textProperty().addListener(textFieldListener);
        zipcodeField.textProperty().addListener(textFieldListener);
    }

    private final ChangeListener<String> textFieldListener = (_, _, _) -> {
        boolean firstNameValid = validateFirstName();
        boolean lastNameValid = validateLastName();
        boolean dobValid = validateDOB();
        boolean emailValid = validateEmail();
        boolean zipcodeValid = validateZipcode();

        addButton.setDisable(!firstNameValid || !lastNameValid || !dobValid || !emailValid || !zipcodeValid);
    };

    /**
     * Validates the user's input in the first name field.
     *
     * @return True if the input is a valid first name. It only starts with a letter and does not contain digits.
     */
    private boolean validateFirstName() {
        String pattern = "^[a-zA-Z][a-zA-Z']{2,25}\\b$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(firstNameField.getText());
        boolean result = m.find();
        if (firstNameField.isFocused()) {
            //Checks if the beginning starts with a letter
            if (result) {
                firstNamePrompt.setText("");
                return true;
            }
            else {
                firstNamePrompt.setText("First Name must be between 2 and 25 characters and must start with a letter.");
            }
        }
        else {
            if (result) {
                firstNamePrompt.setText("");
                return true;
            }
            firstNamePrompt.setText("");
        }
        return false;
    }

    /**
     * Validates the user's input in the last name field.
     *
     * @return True if the input is a valid last name. It only starts with a letter and does not contain digits.
     */
    private boolean validateLastName() {
        //Checks if the beginning starts with a letter
        String pattern = "^[a-zA-Z][a-zA-Z']{2,25}\\b$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(lastNameField.getText());
        boolean result = m.find();
        if (lastNameField.isFocused()) {
            if (result) {
                lastNamePrompt.setText("");
                return true;
            }
            else {
                lastNamePrompt.setText("Last Name must be between 2 and 25 characters and must start with a letter.");
            }
        }
        else {
            if (result) {
                lastNamePrompt.setText("");
                return true;
            }
            lastNamePrompt.setText("");
        }
        return false;
    }

    /**
     * Validates the user's input in the email text field.
     *
     * @return True if the input is a valid Farmingdale email address.
     */
    private boolean validateEmail() {
        //Checks if the beginning is a letter and then continues matching the string to farmingdale and edu
        String pattern = "^([a-zA-Z])(\\w)*@(farmingdale).(edu)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(emailField.getText());
        boolean result = m.find();
        if (emailField.isFocused()) {
            if (result) {
                emailPrompt.setText("");
                return true;
            }
            else {
                emailPrompt.setText("Please enter a valid Farmingdale email address. It must not start with a digit.");
            }
        }
        else {
            if (result) {
                emailPrompt.setText("");
                return true;
            }
            emailPrompt.setText("");
        }
        return false;
    }

    /**
     * Validates a user's input in the date of birth text field
     *
     * @return True if the input is a valid date of birth.
     */
    private boolean validateDOB() {
        String pattern = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(dobField.getText());
        boolean result = m.find();
        if (dobField.isFocused()) {
            if (result) {
                dobPrompt.setText("");
                return true;
            }
            else {
                dobPrompt.setText("Please enter a valid date of birth in MM/DD/YYYY format.");
            }
        }
        else {
            if (result) {
                dobPrompt.setText("");
                return true;
            }
            dobPrompt.setText("");
        }
        return false;
    }

    /**
     * Validates the user's input in the zipcode text field.
     *
     * @return True if the input is a five-digit number.
     */
    private boolean validateZipcode() {
        //Checks if the input is only digits from 0-9 and that it is not bigger than five digits
        String pattern = "^[0-9]{5}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(zipcodeField.getText());
        boolean result = m.find();
        if (zipcodeField.isFocused()) {
            if (result) {
                zipcodePrompt.setText("");
                return true;
            }
            else {
                zipcodePrompt.setText("Please enter a 5 digit ZIP code");
            }
        }
        else {
            if (result) {
                zipcodePrompt.setText("");
                return true;
            }
            zipcodePrompt.setText("");
        }
        return false;
    }
}