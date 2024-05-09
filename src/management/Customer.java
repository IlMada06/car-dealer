
package management;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty name;
    private StringProperty surname; 
    private StringProperty birth;
    private StringProperty id;

    public Customer(String name, String surname, String birth, String id) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.birth = new SimpleStringProperty(birth);
        this.id = new SimpleStringProperty(id);
    }
    public Customer() {
        
    }

    public StringProperty getIdProperty() {
        return id;
    }
    public StringProperty getNameProperty() {
        return name;
    }
    public StringProperty getSurnameProperty() {
        return surname;
    }
    public StringProperty getBirthProperty() {
        return birth;
    }

    public String getName() {
        return name.get();
    }
    public String getSurname() {
        return surname.get();
    }
    public String getBirth() {
        return birth.get();
    }
    public String getId() {
        return id.get();
    }

    @Override
    public String toString() {
        return getName() + "\n" + getSurname() + "\n" + getBirth() + "\n" + getId();
    }
    
}
