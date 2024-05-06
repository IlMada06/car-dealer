
package vendita;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import management.CarDealer;

public class VenditaController implements Initializable {

    private CarDealer gestione;
    
    public void setMainModel(CarDealer gestione) {
        this.gestione=gestione;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
