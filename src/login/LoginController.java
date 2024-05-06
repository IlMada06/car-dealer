
package login;

import main.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import management.CarDealer;
import vendita.VenditaController;

public class LoginController implements Initializable {
    
    @FXML TextField usr;
    @FXML TextField psw;
    @FXML Button btnLogin;
    @FXML Label errore;
    
    
    public static CarDealer gestione;
    
    
    public void setMainModel(CarDealer gestione) {
        this.gestione=gestione;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errore.setVisible(false);
    }    
    
    @FXML
    private void login(ActionEvent event) throws IOException {
        if (usr.getText().equals("admin") && psw.getText().equals("admin")) {
            Stage stage = new Stage(StageStyle.DECORATED);
            Parent root = FXMLLoader.load(getClass().getResource("/main/FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Car Dealer");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }
        else {
            errore.setVisible(true);
        }
    } 
}
