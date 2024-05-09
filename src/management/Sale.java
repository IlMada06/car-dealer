
package management;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sale {
    private Car car;
    private Customer customer;
    private String price;
    private String date;
    
    public Sale(Car car, Customer customer){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.car = car;
        this.customer = customer;
        this.price = car.getPrice();
        this.date = dateFormat.format(currentDate);
    }

    public Sale(Car car, Customer customer, String price, String date) {
        this.car = car;
        this.customer = customer;
        this.price = price;
        this.date = date;
    }

    public Car getCar() {
        return car;
    }
    public Customer getCustomer() {
        return customer;
    }
    public String getPrice() {
        return price;
    }
    public String getDate() {
        return date;
    }
    
    public StringProperty getDateProperty() {
        return new SimpleStringProperty(date);
    }
    public StringProperty getPriceProperty() {
        return new SimpleStringProperty(price);
    }
}
