import java.sql.Timestamp;

public class StockHistory {
    String client;
    Timestamp dateTime;
    double price;

    public StockHistory(String client, Timestamp dateTime,double price) {
        this.client = client;
        this.dateTime = dateTime;
        this.price=price;
    }

    public String details(){

        return  client+ " bidded for "+price+" on "+dateTime;
    }
}
