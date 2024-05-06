
package registraClienti;

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
import management.CarDealer;
import management.Customer;

public class RegistraController implements Initializable {

    @FXML private TableView<Customer> tabellaClienti;
    @FXML private TableColumn<Customer, String> colonnaNome;
    @FXML private TableColumn<Customer, String> colonnaCognome;
    @FXML private TableColumn<Customer, String> colonnaNascita;
    @FXML private TableColumn<Customer, String> colonnaId;
    @FXML private TextField txtNome;
    @FXML private TextField txtCognome;
    @FXML private TextField txtNascita;
    
    @FXML private Button btnSalva;
    @FXML private Button btnAggiungi;
    @FXML private Button btnRimuovi;
    
    
    void setMainModel(CarDealer gestione) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabellaClienti.setItems(LoginController.gestione.getCustomerList());
        colonnaNome.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        colonnaCognome.setCellValueFactory(cellData -> cellData.getValue().getSurnameProperty());
        colonnaNascita.setCellValueFactory(cellData -> cellData.getValue().getBirthProperty());
        colonnaId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
        tabellaClienti.getSelectionModel().selectedItemProperty().addListener((observable,oldValue, newValue)-> mostraDettagliCliente(newValue));
    }  
    
    private void mostraDettagliCliente(Customer c) {
        if (c!=null){
            txtNome.setText(c.getName());
            txtCognome.setText(c.getSurname());
            txtNascita.setText(c.getBirth());
        }
    }
    
    @FXML
    private void aggiungiCliente(ActionEvent event) {
        String nome = txtNome.getText();
        String cognome = txtCognome.getText();
        String nascita = txtNascita.getText();
        String id = LoginController.gestione.getNewId();
        LoginController.gestione.addCustomer(new Customer(nome,cognome,nascita,id));
    }
    
    @FXML
    private void rimuoviCliente(ActionEvent event) {
        LoginController.gestione.removeCustomer(txtNome.getText(), txtCognome.getText(), txtNascita.getText());
    }
    
    @FXML void salvaSuFile(ActionEvent event) {
        LoginController.gestione.saveCustomerList();
    }
}
