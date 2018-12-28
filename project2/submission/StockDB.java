import java.io.*;
import java.sql.Timestamp;
import java.util.*;

class StockDB {

    public static Map<String, StockItem> stockList = new HashMap<>();
    public static Map<String, ArrayList<StockHistory>> stockHistory = new HashMap<>();
    private String[] fields;


    public StockDB(String cvsFile, String key, String securityName, String price) {
        FileReader fileRd = null;
        BufferedReader reader = null;

        try {
            fileRd = new FileReader(cvsFile);
            reader = new BufferedReader(fileRd);

            /* read the CSV file's first line which has
             * the names of fields.
             */
            String header = reader.readLine();
            fields = header.split(",");// keep field names
            int keyIndex = 0;
            int secIndex = 1;

            int priceIndex = 2;

            if (keyIndex == -1 || secIndex == -1 || priceIndex == -1)
                throw new IOException("CVS file does not have data");
            // note how you can throw a new exception


            /* read each line, getting it split by ,
             * use the indexes to get the key and value
             */
            String[] tokens;
            for (String line = reader.readLine();
                 line != null;
                 line = reader.readLine()) {
                tokens = line.split(",");
                stockList.put(tokens[keyIndex], new StockItem(tokens[secIndex], Double.parseDouble(tokens[priceIndex])));
            }

            if (fileRd != null) fileRd.close();
            if (reader != null) reader.close();

            // I can catch more than one exceptions
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Malformed CSV file");
            System.out.println(e);
        }
    }

    private int findIndexOf(String key) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i].equals(key)) {
                return i;
            }
        return -1;
    }

    public static double getPrice(String symbol) {
        return stockList.get(symbol).getPrice();
    }

    public static void setPrice(String symbol, double price, String client) {
        stockList.get(symbol).setPrice(price);
        Date date= new Date();
        StockHistory s = new StockHistory(client,  new Timestamp(date.getTime()), price);
        if (stockHistory.containsKey(symbol)) {
            stockHistory.get(symbol).add(s);
        } else {
            ArrayList<StockHistory> list = new ArrayList<>();
            list.add(s);
            stockHistory.put(symbol, list);
        }
    }

    public static boolean keyExists(String key) {
        if (stockList.containsKey(key)) {
            return true;
        }
        return false;
    }

}
	    