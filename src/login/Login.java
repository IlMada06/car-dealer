
package login;

import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import management.CarDealer;

public class Login extends Application {
    
    private Stage primaryStage;
    private LoginController loginController;
    public static String carPath = System.getProperty("user.dir")+"\\src\\file\\carList.txt";
    public static String customerPath = System.getProperty("user.dir")+"\\src\\file\\customerList.txt";
    public static String salePath = System.getProperty("user.dir")+"\\src\\file\\saleList.txt";
    public static String userPath = System.getProperty("user.dir")+"\\src\\file\\userList.txt";

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Login");

        inizializza();        
    }
    
     public static void main(String[] args) {
        launch(args);
    }
     
    private void inizializza() {
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Login.class.getResource("login.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            CarDealer gestione=new CarDealer();
            
            loginController=loader.getController();
            loginController.setMainModel(gestione);
            //loginController.setMainApp(this);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.getScene().getWindow().addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void closeWindowEvent(WindowEvent event) {
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getButtonTypes().remove(ButtonType.OK);
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.getButtonTypes().add(ButtonType.YES);
            alert.setTitle("Avviso");
            alert.setContentText("Sei sicuro di voler chiudere il programma?");
            alert.initOwner(primaryStage.getOwner());
            Optional<ButtonType> res = alert.showAndWait();

            if(res.isPresent()) {
                if(res.get().equals(ButtonType.CANCEL))
                    event.consume();
            }
    } 
}
