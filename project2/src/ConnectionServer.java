import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class ConnectionServer implements Runnable, ActionListener {
    // some constants 
    public static final int WAIT_AUTH = 0;
    public static final int GET_SYMBOL = 1;
    public static final int GET_BID_PRICE = 2;
    public static final int BID_ONE_MORE = 3;
    private static MainServer mainServer;


    // per connection variables
    private Socket mySocket; // connection socket per thread 
    private int currentState;
    private String clientName;
    private String symbol;
    private double bidPrice;
    private PrintWriter out;
    private  int listLength=0;
    private  Timer timer;



    public void actionPerformed(ActionEvent e) {
        if(StockDB.stockHistory.get(symbol)!=null) {
            int newLength = StockDB.stockHistory.get(symbol).size();
            StockHistory s = StockDB.stockHistory.get(symbol).get(newLength - 1);
            if (newLength > listLength && clientName!=s.client) {
                listLength=newLength;
                String outline = "\n"+s.client + " bidded " + s.price+"\n";
                printOut(outline);
                out.flush();
            }
        }
    }


    public ConnectionServer(MainServer mainServer) {
        this.mySocket = null; // we will set this later
        this.clientName = null;
        this.mainServer = mainServer;
        timer = new Timer(500, this);

        // who created me. He should give some interface
    }

    public boolean handleConnection(Socket socket) {
        this.mySocket = socket;
        Thread newThread = new Thread(this);
        newThread.start();
        return true;
    }

    public void run() { // can not use "throws .." interface is different
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new
                    BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            out = new
                    PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
             this.out=out;
            String line, outline;
            currentState = WAIT_AUTH;
            outline="WELCOME TO AUCTION SERVER\n";
            printOut(outline);
            outline="Type quit to exit\n";
            printOut(outline);
            outline="\nEnter Your Name: ";
            printOut(outline);
            out.flush();
            for (line = in.readLine(); line != null && !line.equals("quit"); line = in.readLine()) {
                switch (currentState) {
                        case WAIT_AUTH:
                            clientName = line;
                            outline = "Welcome " + clientName + "\nPlease Enter the security symbol\n";
                            printOut(outline);
                            currentState = GET_SYMBOL;
                            break;
                        case GET_SYMBOL:
                            timer.start();
                            symbol = line;
                            System.out.println(line);
                            if (StockDB.keyExists(symbol)) {
                                currentState = GET_BID_PRICE;
                                outline = "You Are Bidding On " + line + "\n"+"Current stock Price is :" + StockDB.getPrice(symbol) + "\n"+"Enter Your bid amount:\n";
                                printOut(outline);

                                if(StockDB.stockHistory.get(symbol)!=null){
                                     listLength=StockDB.stockHistory.get(symbol).size();
                                 }

                            } else {
                                currentState = GET_SYMBOL;
                                outline = "Security Symbol does not exists,Enter a valid Symbol again\n";
                                printOut(outline);

                            }
                            break;
                        case GET_BID_PRICE:
                            bidPrice = Double.parseDouble(line);

                            if (bidPrice > StockDB.getPrice(symbol)) {
                                StockDB.setPrice(symbol, bidPrice,clientName);
                                outline = "Current stock Price is updated to :" + bidPrice + "\n"+"Are you willing to bid for one more item ? (Y/N)\n";
                                printOut(outline);
                                currentState=BID_ONE_MORE;


                            } else {
                                outline = "Bid Price has to be higher ,Try Again\n";
                                printOut(outline);
                                currentState = GET_BID_PRICE;
                            }

                            break;
                        case BID_ONE_MORE:

                            if(!line.equalsIgnoreCase("y") && !line.equalsIgnoreCase("n") ){
                                outline="Please Type Y for Yes and N for NO \n ";
                                printOut(outline);
                                currentState=BID_ONE_MORE;
                            }else{
                                if(line.equalsIgnoreCase("n")){
                                    outline="Thank You!";
                                    printOut(outline);
                                    out.close();
                                    in.close();
                                    this.mySocket.close();
                                }else{
                                    outline="Enter the symbol to bid \n";
                                    printOut(outline);
                                    currentState=GET_SYMBOL;
                                }

                            }

                            break;
                        default:
                            System.out.println("Undefined state");
                            return;
                    }
                }
                out.flush();
            out.close();
            in.close();
            this.mySocket.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void printOut(String msg ){
        this.out.print(msg);
    }
}

    
    

