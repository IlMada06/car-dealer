
package management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GestioneFile {
    
    public void cleanUpFiles(String path) {
        File targetFile = new File(path);
        targetFile.delete();
    }
    
    public void writeFile(String path, String text) {
        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text+"\n");
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public ObservableList<Car> readCar(String path) throws FileNotFoundException, IOException {
        ObservableList<Car> carList = FXCollections.observableArrayList();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                carList.add(new Car(br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine()));
                br.readLine();
            }
        }

        return carList;
    }
    
    public ObservableList<Customer> readCustomer(String path) throws FileNotFoundException, IOException {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.ready()) {
                customerList.add(new Customer(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
            }
        }
        return customerList;
    }
}
