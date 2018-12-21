import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServer { 

    /* Some constants */     
    public static final int BASE_PORT = 2000;  // port number for listening


    /* local data for the server 
     * Every main server is defined in terms of the port
     */ 
    private ServerSocket serverSocket=null;  // server Socket for main server 
    private StockDB initialStocks;     // initial stock values

    public MainServer(int socket, StockDB initialStocks) {
	this.initialStocks = initialStocks;

	try { 
	    this.serverSocket = new ServerSocket(socket); //create new serverSocket
	} catch (IOException e) { 
	    System.out.println(e); 
	}
    }

    //server listening for requests and create threads for each connection
    public void server_loop() { 
	try { 
	    while(true) { 
		Socket socket = this.serverSocket.accept(); 
		ConnectionServer worker = new ConnectionServer(this); 
		worker.handleConnection(socket); //handle the socket
	    }
	} catch(IOException e) { 
	    System.out.println(e);
	}
    }// end server_loop 
}


	




