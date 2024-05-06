
package main;

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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import management.CarDealer;
import vendita.VenditaController;

public class MainController implements Initializable {
    
    @FXML Button RegistraCliente;
    @FXML Button Vendita;
    @FXML Button Noleggio;
    
    public void setMainModel(CarDealer gestione) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    private void openRegistraCliente(ActionEvent event) throws IOException {
        Stage stage = new Stage(StageStyle.DECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("/registraClienti/registra.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Registra Cliente");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
    }
    
    @FXML
    private void openVendita(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vendita/vendita.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Vendita");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
    }
    
    @FXML
    private void openNoleggio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/noleggio/noleggio.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Noleggio");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
    }
}
