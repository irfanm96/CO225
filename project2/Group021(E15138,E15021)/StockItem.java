public class StockItem {

    private  String securityName;
    private double price;

    public StockItem(String securityName, double price) {
        this.securityName = securityName;
        this.price = price;
    }


    @Override
    public String toString() {
        return  price + "\t" + securityName;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }
}
