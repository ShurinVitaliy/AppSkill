package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField login_field;

    @FXML
    private TextArea info_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        add_button.setOnAction(event -> {
            String surname = surname_field.getText().trim();
            String lastname = lastname_field.getText().trim();
            String login = login_field.getText().trim();
            String password = password_field.getText().trim();
            if (!surname.equals("")&&!lastname.equals("")&&!login.equals("")&&!password.equals("")){
                addUser(surname, lastname, login, password);
            }
        });
    }

    private void addUser(String surname, String lastname, String login, String password) {
        User user = new User(surname, lastname, login, password);
        DataBH dataBH = new DataBH();
        dataBH.siginUpUser(user);
    }
}
