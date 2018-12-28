import java.awt.*;
import javax.swing.Timer; //for timer

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Display1 
    extends JPanel implements ActionListener { 
    JTextArea textArea;
    private String key;
    private Timer timer=new Timer(500,this);
    private ArrayList<StockHistory> sHistory;

    public Display1(String key) {
        super(new GridBagLayout());
    this.key=key;
	textArea = new JTextArea(10, 35);
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

        //Create and set up the window.
        JFrame f = new JFrame("Stock History of "+this.key);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Add contents to the window.
        f.add(this);

        //Display the window.
        f.pack();
        f.setVisible(true);
        timer.start();


    }

    public void actionPerformed(ActionEvent e) {

        sHistory=StockDB.stockHistory.get(this.key);
            textArea.setText("");
            if(sHistory==null){
                textArea.append("No Bids Yet!!");
            }else{
                textArea.append("Name\t Price \tDateTime \n");

                for(StockHistory i : sHistory){
                    textArea.append(i.client +"\t"+ i.price+"\t"+i.dateTime+"\n");
                }
                textArea.setCaretPosition(textArea.getDocument().getLength());

        }

    }

}
	