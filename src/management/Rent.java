
package management;

import java.util.ArrayList;

public class Rent extends Sale{
    private String returnDate;
    private int days;

    public Rent(String returnDate, Car car, Customer customer, int days) {
        super(car, customer);
        this.returnDate = returnDate;
        this.days = days;
        //rentPrice(car.getPrice());
    }
    
    private void rentPrice(float price) {
        super.setPrice(price/100*days);
    }
    
}
