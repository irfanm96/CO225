import java.awt.*;
import javax.swing.Timer; //for timer

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.html.parser.Entity;

import java.io.IOException;
import java.util.Map;

public class Display 
    extends JPanel implements ActionListener { 
    private  JTextArea textArea;
    private VisualServer server;
    private Map<String, StockItem> stockList=StockDB.stockList;
    JButton OKButton = new JButton("OK");
    private static String [] keys={"AAL","AAPL","ABAC"};


    public Display(VisualServer server) { 
        super(new GridBagLayout());

	textArea = new JTextArea(10, 50);
	textArea.setEditable(false);
	JScrollPane scrollPane = new JScrollPane(textArea);
	
	 //Add Components to this panel.
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);

	Timer timer = new Timer(500, this); 
	timer.start(); 

	this.server = server;
        OKButton.addActionListener(this);
        this.add(OKButton);
    }
    
    public void actionPerformed(ActionEvent e) {

        textArea.setText("");
        if(stockList != null) {
            for(int i=0 ; i<keys.length ;i++) {
                textArea.append(keys[i] + "\t" + stockList.get(keys[i]) + "\n");
            }


	    //Make sure the new text is visible, even if there
	    //was a selection in the text area.
	    textArea.setCaretPosition(textArea.getDocument().getLength());
	}

    }

    public static void main(String [] args) throws IOException { 
	//Create and set up the window.
        JFrame frame = new JFrame("Current Stock Prices");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	StockDB initialStocks = new StockDB("stocks.csv","Symbol","Security Name","Price");
	VisualServer server = new VisualServer(MainServer.BASE_PORT,
					       initialStocks);
        //Add contents to the window.
        frame.add(new Display(server));

        //Display the window.
        frame.pack();
        frame.setVisible(true);

	server.server_loop(); 
    }
}
	