
package management;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import login.Login;

public class CarDealer {
    private ObservableList<Car> carList;
    private ObservableList<Customer> customerList;
    private ArrayList<Sale> saleList;
    private ArrayList<String> customerIdList;
    private FileManagement file;
    
    public CarDealer() throws IOException {
        this.file = new FileManagement();
        this.carList = file.readCar(Login.carPath);
        this.customerList = file.readCustomer(Login.customerPath);
        this.saleList = new ArrayList();
        //this.saleList = file.readSale(Login.salePath);
        
        this.customerIdList = new ArrayList();
        for (int i=0; i<customerList.size(); i++) {
            customerIdList.add(customerList.get(i).getId());
        }
    }

    public ObservableList<Customer> getCustomerList() {
        return customerList;
    }
    public ObservableList<Car> getCarList() {
        return carList;
    }
    
    public void addCustomer(Customer c) {
        customerList.add(c);
    }
    
    public void addSale(String carId, String customerId) {
        Car car = new Car();
        Customer customer = new Customer();
        for (int i=0; i<carList.size(); i++) {
            if (carList.get(i).getId().equals(carId)) {
                car = carList.get(i);
                carList.remove(i);
            }
        }
        for (int i=0; i<customerList.size(); i++) {
            if (customerList.get(i).getId().equals(customerId)) {
                customer = customerList.get(i);
            }
        }
        saleList.add(new Sale(car, customer));
    }
    
    public void removeCustomer(String id) {
        for (int i=0; i<customerList.size(); i++) {
            if(customerList.get(i).getId().equals(id)) {
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
    
    public void saveSaleList() {
        file.cleanUpFiles(Login.salePath);
        for (int i=0; i<saleList.size(); i++) {
            file.writeFile(Login.salePath, "----------CAR----------");
            file.writeFile(Login.salePath, saleList.get(i).getCar().toString());
            file.writeFile(Login.salePath, "----------CUSTOMER----------");
            file.writeFile(Login.salePath, saleList.get(i).getCustomer().toString());
            file.writeFile(Login.salePath, "----------PRICE----------");
            file.writeFile(Login.salePath, saleList.get(i).getPrice());
            file.writeFile(Login.salePath, "----------DATE----------");
            file.writeFile(Login.salePath, saleList.get(i).getDate());
        }
    }
    
    public String getNewId() {
        Integer newId=1;
        while (true) {
            if (customerIdList.contains(newId.toString())) {
                newId++;
            }
            else {
                customerIdList.add(newId.toString());
                return newId.toString();
            }
        }
    }
}
