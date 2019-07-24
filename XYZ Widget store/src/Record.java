public class Record {
    String type;
    double number;
    double price;


    public Record(String type, double number) {
        this.type= type;
        this.number =number;
    }
    public Record(String type, double number, double price){
        this.type= type;
        this.number =number;
        this.price=price;
    }

    public double getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
