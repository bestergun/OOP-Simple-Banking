package Best;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GUI extends Application{

	public static int time=0;
	
	Label result;
	Label ID;
	Label month;
	Label withdraw;
	Label amount;
	Label deposit;
	Label amountdep;
	Label senderID;
	Label receiverID;
	Label amounttran;
	
	
	TextField txID;
	TextField txmonth;
	TextField txIDwithdraw;
	TextField txamount;
	TextField txIDdeposit;
	TextField txamountdep;
	TextField txIDsender;
	TextField txIDreceiver;
	TextField txamounttran;
	
	
	Button bttransfer;
	Button btwithdraw;
	Button btdeposit;
	Button btseeBalance;
	Button btUpdateTime;
	Button gridtransfer;
	Button griddeposit;
	Button gridwithdraw;
	
	public static void main(String[] args) {
		launch();

	}
	
	   public void init() {  
		
		   
		   
		result=new Label("");
		ID=new Label("AccountID");
		month=new Label("Month");
		withdraw=new Label("AccountID");
		amount=new Label("amount");
		deposit=new Label("AccountID");
		amountdep=new Label("amount");
		senderID=new Label("SenderID");
		receiverID=new Label("ReceiverID");
		amounttran=new Label("Amount");
		
		
		
		txID=new TextField();
		txID.setPrefColumnCount(10);
		txmonth=new TextField();
		txmonth.setPrefColumnCount(10);
		
		txIDwithdraw=new TextField();
		txIDwithdraw.setPrefColumnCount(10);
		txamount=new TextField();
		txamount.setPrefColumnCount(10);
		
		txIDdeposit=new TextField();
		txIDdeposit.setPrefColumnCount(10);
		txamountdep=new TextField();
		txamountdep.setPrefColumnCount(10);
		
		txIDsender=new TextField();
		txIDsender.setPrefColumnCount(10);
		txIDreceiver=new TextField();
		txIDreceiver.setPrefColumnCount(10);
		txamounttran=new TextField();
		txamounttran.setPrefColumnCount(10);
		
		btseeBalance=new Button("seeBalance");
		btUpdateTime=new Button("UpdateTime");
		btwithdraw=new Button("withdraw");
		btdeposit=new Button("deposit");
		bttransfer=new Button("Transfer");
		
		gridtransfer=new Button("Press");
		griddeposit=new Button("Press");
		gridwithdraw=new Button("Press");
		   } 

	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Bank"); 
		BorderPane rootNode = new BorderPane();
		
		GridPane seebalance = new GridPane();
		seebalance.add(ID,0,0);
		seebalance.add(txID,0,1);
		
		GridPane timegrid = new GridPane();
		timegrid.add(month,0,0);
		timegrid.add(txmonth,0,1);
		
		GridPane withdrawgrid=new GridPane();
		withdrawgrid.add(withdraw, 0, 0);
		withdrawgrid.add(txIDwithdraw, 0, 1);
		withdrawgrid.add(amount, 1, 0);
		withdrawgrid.add(txamount, 1, 1);
		withdrawgrid.add(gridwithdraw, 2, 1);
		
		GridPane depositgrid=new GridPane();
		depositgrid.add(deposit, 0, 0);
		depositgrid.add(txIDdeposit, 0, 1);
		depositgrid.add(amountdep, 1, 0);
		depositgrid.add(txamountdep, 1, 1);
		depositgrid.add(griddeposit, 2, 1);
		
		GridPane transfergrid=new GridPane();
		transfergrid.add(senderID, 0, 0);
		transfergrid.add(txIDsender, 0, 1);
		transfergrid.add(receiverID, 1, 0);
		transfergrid.add(txIDreceiver, 1, 1);
		transfergrid.add(amounttran, 2, 0);
		transfergrid.add(txamounttran, 2, 1);
		transfergrid.add(gridtransfer, 3, 1);
		
		FlowPane buttons = new FlowPane();
		buttons.getChildren().addAll(btseeBalance,btUpdateTime,btwithdraw,btdeposit,bttransfer,result);

		rootNode.setTop(result);
		rootNode.setCenter(seebalance);
		rootNode.setBottom(buttons);
		
		Scene myScene = new Scene(rootNode, 500, 200); 
	    myStage.setScene(myScene);
	    
	    btseeBalance.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	  rootNode.setCenter(timegrid);	        			        			       
		      } 
	    });
	    
	    btUpdateTime.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	  rootNode.setCenter(seebalance);	        			        			       
		      } 
	    });
	    
	    btwithdraw.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	  rootNode.setCenter(withdrawgrid);	        			        			       
		      } 
	    });
	    
	    btdeposit.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	  rootNode.setCenter(depositgrid);	        			        			       
		      } 
	    });
	    
	    bttransfer.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	  rootNode.setCenter(transfergrid);	        			        			       
		      } 
	    });
	    
	    txID.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	try {		    		
					result.setText(Bank.seebalance(txID.getText()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
		      } 
	    });
	    
	    gridwithdraw.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	try {
		    		
					if(Bank.withdraw(txIDwithdraw.getText(),Double.parseDouble(txamount.getText())))
					result.setText(Bank.seebalance(txIDwithdraw.getText()));
					else
					result.setText("there is no enough money");
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		      } 
	    });
	    
	    griddeposit.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	try {
		    		
					Bank.deposit(txIDdeposit.getText(),Double.parseDouble(txamountdep.getText()));
					result.setText(Bank.seebalance(txIDdeposit.getText()));
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		      } 
	    });
	    
	    txmonth.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) {
		    	 time=time+Integer.parseInt(txmonth.getText());
		    	 Account.setCurrentTime(time);
		    	
		      } 
	    });
	    
	    gridtransfer.setOnAction(new EventHandler<ActionEvent>() { 
		      public void handle(ActionEvent ae) { 
		    	try {
		    		
					if(Bank.Transfer(txIDsender.getText(),txIDreceiver.getText(),Double.parseDouble(txamounttran.getText())))
					result.setText(Bank.seebalance(txIDsender.getText()));
					else
						throw new MoneyException();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (MoneyException e) {
					System.out.println("there is no enough money");
				}
		      } 
	    });
	    myStage.show();
		
	}

	

}
