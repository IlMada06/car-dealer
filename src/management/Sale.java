
package management;

public class Sale {
    private Car car;
    private Customer customer;
    private float price;
    
    public Sale(Car car, Customer customer){
        this.car = car;
        this.customer = customer;
        //this.price = car.getPrice();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
