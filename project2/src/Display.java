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
    JButton HButton = new JButton("History");
    private static String [] keys={"AAL","AAPL","ABAC"};

    //Create the combo box, select item at index 4.
//Indices start at 0, so 4 specifies the pig.
    JComboBox symbols = new JComboBox(keys);
   
 public static Timer timer;

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

	timer = new Timer(500, this);
	timer.start(); 

	this.server = server;
        HButton.addActionListener(this);
        this.add(HButton);
        symbols.setSelectedIndex(0);
        symbols.addActionListener(this);
        this.add(symbols);

    }
    
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==timer) {
            textArea.setText("");
            if (stockList != null) {
                for (int i = 0; i < keys.length; i++) {
                    textArea.append(keys[i] + "\t" + stockList.get(keys[i]) + "\n");
                }


                //Make sure the new text is visible, even if there
                //was a selection in the text area.
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
        }
        if(e.getSource()==HButton){
            System.out.println(symbols.getSelectedItem().toString());
            new Display1(symbols.getSelectedItem().toString());
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
	