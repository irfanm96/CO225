import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServer { 

    /* Some constants */     
    public static final int BASE_PORT = 1250;  // do not change    


    /* local data for the server 
     * Every main server is defined in terms of the port it 
     * listens and the database of allowed initailStocks 
     */ 
    private ServerSocket serverSocket=null;  // server Socket for main server 
    private StockDB initialStocks;     // who are allowed to chat

    public MainServer(int socket, StockDB initialStocks) {
	this.initialStocks = initialStocks;

	try { 
	    this.serverSocket = new ServerSocket(socket); 
	} catch (IOException e) { 
	    System.out.println(e); 
	}
    }

    /* each server will provide the following functions to 
     * the public. Note that these are non-static 
     */ 


    /* server will define how the messages should be posted 
     * this will be used by the connection servers
     */ 

    public void postMSG(String msg) { 
	// all threads print to same screen 
	System.out.println(msg); 
    }

    public void server_loop() { 
	try { 
	    while(true) { 
		Socket socket = this.serverSocket.accept(); 
		ConnectionServer worker = new ConnectionServer(this); 
		worker.handleConnection(socket); 
	    }
	} catch(IOException e) { 
	    System.out.println(e);
	}
    }// end server_loop 
}


	




