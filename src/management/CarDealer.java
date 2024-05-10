
package management;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import login.Login;

public class CarDealer {
    private ObservableList<Car> carList;
    private ObservableList<Customer> customerList;
    private ObservableList<Sale> saleList;
    private ArrayList<User> userList;
    private ArrayList<String> customerIdList;
    private FileManagement file;
    
    public CarDealer() throws IOException {
        this.file = new FileManagement();
        this.carList = file.readCar(Login.carPath);
        this.customerList = file.readCustomer(Login.customerPath);
        this.saleList = file.readSale(Login.salePath);
        this.userList = file.readUser(Login.userPath);
        
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
    public ObservableList<Sale> getSaleList() {
        return saleList;
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
    
    public void removeCustomer(String surname, String name, String birth) {
        for (int i=0; i<customerList.size(); i++) {
            if(customerList.get(i).getSurname().equals(surname) && customerList.get(i).getName().equals(name) && customerList.get(i).getBirth().equals(birth)) {
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
    public void saveUserList() {
        file.cleanUpFiles(Login.userPath);
        for (int i=0; i<userList.size(); i++) {
            file.writeFile(Login.salePath, userList.get(i).getName());
            file.writeFile(Login.salePath, userList.get(i).getPassword());
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
    
    public String getTotalIncome() {
        Integer price = 0;
        for (int i=0; i<saleList.size(); i++) {
            price += Integer.valueOf(saleList.get(i).getPrice().replace(".", ""));
        }
        return price.toString();
    }
    
    public void carStockUpdate() throws IOException {
        this.carList = file.readCar(Login.carPath);
    }
    
    public boolean tryLogin(String name, String password){
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).getName().equals(name) && userList.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    public boolean isRegistered(String name) {
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void registerUser(String name, String password) throws IOException {
        file.writeFile(Login.userPath, name);
        file.writeFile(Login.userPath, password);
        this.userList = file.readUser(Login.userPath);
    }
}
