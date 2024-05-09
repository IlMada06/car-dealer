
package listino;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import login.LoginController;
import management.Car;
import management.Customer;

public class ListinoController implements Initializable {

    @FXML private TableView<Car> tabellaListino;
    @FXML private TableColumn<Car, String> colonnaId;
    @FXML private TableColumn<Car, String> colonnaModello;
    @FXML private TableColumn<Car, String> colonnaMarca;
    @FXML private TableColumn<Car, String> colonnaPrezzo;
    @FXML private TextField txtCilindrata;
    @FXML private TextField txtPotenza;
    @FXML private TextField txtEmissione;
    @FXML private TextField txtTrazione;
    @FXML private TextField txtPosti;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabellaListino.setItems(LoginController.gestione.getCarList());
        colonnaId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        colonnaModello.setCellValueFactory(cellData -> cellData.getValue().getModelProperty());
        colonnaMarca.setCellValueFactory(cellData -> cellData.getValue().getBrandProperty());
        colonnaPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
        tabellaListino.getSelectionModel().selectedItemProperty().addListener((observable,oldValue, newValue)-> mostraDettagliCar(newValue));
    }
    
    private void mostraDettagliCar(Car c) {
        if (c!=null){
            txtCilindrata.setText(c.getCc());
            txtPotenza.setText(c.getHp());
            txtEmissione.setText(c.getEmissionClass());
            txtTrazione.setText(c.getTraction());
            txtPosti.setText(c.getSeats());
        }
    }
    
}
