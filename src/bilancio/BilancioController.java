
package bilancio;

import java.io.IOException;
import listino.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import login.LoginController;
import management.Car;
import management.Customer;
import management.Sale;

public class BilancioController implements Initializable {

    @FXML private Label incassiTotali;
    @FXML private TableView<Sale> tabellaVendite;
    @FXML private TableColumn<Sale, String> colonnaData;
    @FXML private TableColumn<Sale, String> colonnaIdCliente;
    @FXML private TableColumn<Sale, String> colonnaCognome;
    @FXML private TableColumn<Sale, String> colonnaNome;
    @FXML private TableColumn<Sale, String> colonnaMarca;
    @FXML private TableColumn<Sale, String> colonnaModello;
    @FXML private TableColumn<Sale, String> colonnaPrezzo;
    
    @FXML private Button btnRifornimento;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabellaVendite.setItems(LoginController.gestione.getSaleList());
        colonnaIdCliente.setCellValueFactory(cellData -> cellData.getValue().getCustomer().getIdProperty());
        colonnaData.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
        colonnaCognome.setCellValueFactory(cellData -> cellData.getValue().getCustomer().getSurnameProperty());
        colonnaNome.setCellValueFactory(cellData -> cellData.getValue().getCustomer().getNameProperty());
        colonnaMarca.setCellValueFactory(cellData -> cellData.getValue().getCar().getBrandProperty());
        colonnaModello.setCellValueFactory(cellData -> cellData.getValue().getCar().getModelProperty());
        colonnaPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
        
        incassiTotali.setText(LoginController.gestione.getTotalIncome());
    }
    
    @FXML
    public void rifornimentoAuto(ActionEvent event) throws IOException {
        LoginController.gestione.carStockUpdate();
    }
}
