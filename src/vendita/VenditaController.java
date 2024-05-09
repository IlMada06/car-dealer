
package vendita;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import login.LoginController;
import management.Car;
import management.CarDealer;
import management.Customer;

public class VenditaController implements Initializable {
    
    @FXML private TableView<Car> tabellaAutovettura;
    @FXML private TableColumn<Car, String> colonnaIdCar;
    @FXML private TableColumn<Car, String> colonnaModello;
    @FXML private TableColumn<Car, String> colonnaMarca;
    @FXML private TableColumn<Car, String> colonnaPrezzo;
    @FXML private TextField txtIdAuto;
    @FXML private TextField txtModello;
    @FXML private TextField txtMarca;
    @FXML private TextField txtPrezzo;
    
    @FXML private TableView<Customer> tabellaClienti;
    @FXML private TableColumn<Customer, String> colonnaNome;
    @FXML private TableColumn<Customer, String> colonnaCognome;
    @FXML private TableColumn<Customer, String> colonnaNascita;
    @FXML private TableColumn<Customer, String> colonnaIdCliente;
    @FXML private TextField txtIdCliente;
    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private TextField txtNascita;
    @FXML private Button btnVendi;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabellaAutovettura.setItems(LoginController.gestione.getCarList());
        colonnaIdCar.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        colonnaModello.setCellValueFactory(cellData -> cellData.getValue().getModelProperty());
        colonnaMarca.setCellValueFactory(cellData -> cellData.getValue().getBrandProperty());
        colonnaPrezzo.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty());
        tabellaAutovettura.getSelectionModel().selectedItemProperty().addListener((observable,oldValue, newValue)-> mostraDettagliCar(newValue));
        
        tabellaClienti.setItems(LoginController.gestione.getCustomerList());
        colonnaIdCliente.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        colonnaCognome.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        colonnaNome.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        colonnaNascita.setCellValueFactory(cellData -> cellData.getValue().getBirthProperty());
        tabellaClienti.getSelectionModel().selectedItemProperty().addListener((observable,oldValue, newValue)-> mostraDettagliCustomer(newValue));
    }    
    
    private void mostraDettagliCar(Car c) {
        if (c!=null){
            txtIdAuto.setText(c.getId());
            txtModello.setText(c.getModel());
            txtMarca.setText(c.getBrand());
            txtPrezzo.setText(c.getPrice());
        }
    }
    
    private void mostraDettagliCustomer(Customer c) {
        if (c!=null){
            txtIdCliente.setText(c.getId());
            txtNome.setText(c.getName());
            txtCognome.setText(c.getSurname());
            txtNascita.setText(c.getBirth());
        }
    }
    
    @FXML
    private void vendiAuto(ActionEvent event) {
        LoginController.gestione.addSale(txtIdAuto.getText(), txtIdCliente.getText());
        LoginController.gestione.saveSaleList();
    }
        
    
}
