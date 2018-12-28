*********************************************************
Instructions for Using the Auction Serevr
*********************************************************

** Compile and run Display.java

	To compile	: javac Display.java
	To run		: java Display

** GUI controls

  * The GUI displays the current stock prices of FB, VRTU, MSFT, GOOGL, YHOO, XLNX, TSLA and TXN.
  * 3rd column includes current price and it gets updated in every 500ms (if bid prices have chaneged,it will show the current price)
  * 'Show History' Button at the bottom, will pop up a history window for the selected stock next to the button
  * The history window popped up will have all valid bids placed on symbol that  corresponds to the selected item in the dropdown list in main window.
  * the history window displays all the bid History and It gets updated when a valid bid is placed (after 500ms is a restriction).

*********************************************************
Instrucitons for the Clients 
*********************************************************

**The client can use the terminal to connect to the server.
**Connect to the to the server using nc command through port no 2000.

After connecting,
  * The client required to provide a Name. 
  * Then client required to provide Symbol of the security he/she is willing to bid on. 
  * If client enter a valid symbol then client can start Bidding.
  * If not the client will be prompted to give the correct symbol.
  * Client can only enter valid bids (integers or floats).
  * The bid will be accepted only if the client's bid is larger than the stock's current price.
  * After placing the bid,client will be prompted to a new bid (client should input Y for yes And N for no).
  * While placing the bid,client will be notified if someone else has bidded higher than the current price(restriction chnages will happen after 500ms)
  * The world "quit" can be entered(without quotes) at any point in the program to exit it.
