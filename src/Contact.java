import java.util.List;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getKey() {
        return this.name.replace(" ", "").toLowerCase();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String newNumber) {
        this.number = newNumber;
    }

    public String getFormattedNumber() {
        if (this.number.length() == 7) {
            return this.number.substring(0, 3) + "-" + this.number.substring(3);
        } else if (this.number.length() == 10) {
            return "(" + this.number.substring(0,3) + ") " + this.number.substring(3,6) + "-" + this.number.substring(6);
        } else {
            return this.number;
        }
    }


}
