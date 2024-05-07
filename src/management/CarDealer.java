
package management;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import login.Login;

public class CarDealer {
    private ObservableList<Car> carList;
    private ObservableList<Customer> customerList;
    private ArrayList<Sale> saleList;
    private ArrayList<Rent> rentList;
    private ArrayList<String> idList;
    private GestioneFile file;
    
    public CarDealer(String carPath, String customerPath) throws IOException {
        this.file = new GestioneFile();
        this.carList = file.readCar(carPath);
        this.customerList = file.readCustomer(customerPath);
        this.saleList = new ArrayList();
        this.rentList = new ArrayList();
        this.idList = new ArrayList();
        for (int i=0; i<customerList.size(); i++) {
            idList.add(customerList.get(i).getId());
        }
    }
    
    public void addRent(Rent rent){
        if(verifyRent(rent)){
            rentList.add(rent);
        }
    }
    
    public boolean verifyRent(Rent rent){
        for(int i = 0; i < rentList.size(); i++){
            if(rentList.get(i).equals(rent)){
               return false;
            }
        }
        return true;
    }

    public ObservableList<Customer> getCustomerList() {
        return customerList;
    }
    
    public void addCustomer(Customer c) {
        customerList.add(c);
    }
    
    public void removeCustomer(String name, String surname, String birth) {
        Customer c;
        for (int i=0; i<customerList.size(); i++) {
            c = customerList.get(i);
            if(c.getName().equals(name) && c.getSurname().equals(surname) && c.getBirth().equals(birth)) {
                customerList.remove(i);
                break;
            }
        }
    }
    
    public void saveCustomerList() {
        file.cleanUpFiles(Login.customerPath);
        for (int i=0; i<customerList.size(); i++) {
            file.writeFile(Login.customerPath, customerList.get(i).getName());
            file.writeFile(Login.customerPath, customerList.get(i).getSurname());
            file.writeFile(Login.customerPath, customerList.get(i).getBirth());
            file.writeFile(Login.customerPath, customerList.get(i).getId());
        }
    }
    
    public String getNewId() {
        Integer newId=1;
        while (true) {
            if (idList.contains(newId.toString())) {
                newId++;
            }
            else {
                idList.add(newId.toString());
                return newId.toString();
            }
        }
    }
}
