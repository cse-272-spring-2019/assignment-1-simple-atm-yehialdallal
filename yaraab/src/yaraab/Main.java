package yaraab;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	ArrayList<Transaction> transactionList = new ArrayList<>();
	private Stage window;
	private int start = 0,max = 0;
	Scene scene1,scene2,sceneThreeDeposit,sceneThreeWithdraw;
	trial atmMethods=new trial();
	public static void main(String[] args) {
		launch(args);
	}
 
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ATM APPLICATION");
		
		//CREATING SCENE 1
		Label label = new Label("ENTER YOUR PIN NUMBER");
		Label warning = new Label();
		TextField textField = new TextField();
		Button button = new Button("SUBMIT");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
		@Override
		public void handle(ActionEvent event) {
			String text = textField.getText();
				if (atmMethods.validate(text))
				{
					window.setScene(scene2);
				}
				else
				{
					warning.setText("ERROR..INVALID PIN,RE-ENTER YOUR PIN");
					textField.setText("");
				}
				
			}
		});
		GridPane layout = new GridPane();
		
		layout.add(label, 100, 0);
		layout.add(warning, 100, 1);
		layout.add(textField,100, 2);
		layout.add(button, 100, 23);
		Scene scene1 = new Scene(layout,300,250);
		
		// CREATING SCENE 2
		Label welcome = new Label("CHOOSE YOUR DESIRED OPTION FROM BELOW");
		Label preview = new Label();
		Button deposit = new Button("DEPOSIT");
		Button balanceInquiry = new Button("BALANCE INQUIRY");
		Button withdraw = new Button("WITHDRAW");
		Button previous = new Button("PREVIOUS");
		Button next = new Button("NEXT");
		
		deposit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				preview.setText("");
				window.setScene(sceneThreeDeposit);
				
			}
		});
		
		withdraw.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				preview.setText("");
				window.setScene(sceneThreeWithdraw);
				
			}
		});
		
		balanceInquiry.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String stringConv = String.valueOf(atmMethods.getBalance());
				preview.setText("YOUR CURRENT BALANCE IS "+stringConv);
			}
		});
		
		previous.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(--start < 0)
				{
					 preview.setText("NO FURTHER TRANSACTIONS");
					 start = -1 ;
				}
				else 
				{
					Transaction dummy = transactionList.get(start);
					preview.setText(dummy.getType() + " " + dummy.getValue());
				}
			}
		});
		
		next.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				if (++start>max)
				{
					preview.setText("NO FURTHER TRANSACTIONS");
					start--;
				}	
				else
				{
					Transaction dummy = transactionList.get(start);
					preview.setText(dummy.getType() + " " + dummy.getValue());
				}
			}
		});
		GridPane layout2 = new GridPane();
		
		layout2.add(welcome, 1, 0);
		layout2.add(preview, 1, 1);
		layout2.add(deposit, 0, 2);
		layout2.add(withdraw, 2, 2);
		layout2.add(balanceInquiry, 1, 3);
		layout2.add(previous, 0, 4);
		layout2.add(next, 2, 4);
		scene2 = new Scene(layout2, 430, 250);
		
		// CREATING SCENE 3-DEPOSIT
		
		Label previewDeposit = new Label();
		Button submitDeposit = new Button("SUBMIT");
		Button button1=new Button("1");
		Button button2=new Button("2");
		Button button3=new Button("3");
		Button button4=new Button("4");
		Button button5=new Button("5");
		Button button6=new Button("6");
		Button button7=new Button("7");
		Button button8=new Button("8");
		Button button9=new Button("9");
		Button button0=new Button("0");
		
		submitDeposit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				atmMethods.deposit(previewDeposit.getText());
				Transaction transaction = new Transaction("DEPOSIT",previewDeposit.getText());
				addTransaction(transaction);
				start=max;
				previewDeposit.setText("");
				window.setScene(scene2);
			}
		});
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewDeposit.setText(previewDeposit.getText()+button1.getText());
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button2.getText());
			}
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewDeposit.setText(previewDeposit.getText()+button3.getText());
			}
		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewDeposit.setText(previewDeposit.getText()+button4.getText());
			}
		});;
		button5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button5.getText());
			}
		});
		button6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button6.getText());
			}
		});
		button7.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button7.getText());
			}
		});
		button8.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button8.getText());
			}
		});
		button9.setOnAction(new  EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button9.getText());
			}
		});
		button0.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewDeposit.setText(previewDeposit.getText()+button0.getText());
			}
		});

		GridPane layoutThreeDeposit = new GridPane();
		
		layoutThreeDeposit.add(previewDeposit, 200, 0);
		layoutThreeDeposit.add(submitDeposit, 200, 2);
		//layoutThreeDeposit.add(back1, 200,3);
		layoutThreeDeposit.add(button1, 0, 1);
		layoutThreeDeposit.add(button2, 1, 1);
		layoutThreeDeposit.add(button3, 2, 1);
		layoutThreeDeposit.add(button4, 0, 2);
		layoutThreeDeposit.add(button5, 1, 2);
		layoutThreeDeposit.add(button6, 2, 2);
		layoutThreeDeposit.add(button7, 0, 3);
		layoutThreeDeposit.add(button8, 1, 3);
		layoutThreeDeposit.add(button9, 2, 3);
		layoutThreeDeposit.add(button0, 1, 4);

		sceneThreeDeposit = new Scene(layoutThreeDeposit,300,250);
		
		// CREATING SCENE 3-WITHDRAW
		
		Label previewWithdraw = new Label();
		Button submitWithdraw = new Button("SUBMIT");
		Button button11=new Button("1");
		Button button22=new Button("2");
		Button button33=new Button("3");
		Button button44=new Button("4");
		Button button55=new Button("5");
		Button button66=new Button("6");
		Button button77=new Button("7");
		Button button88=new Button("8");
		Button button99=new Button("9");
		Button button00=new Button("0");
		
		submitWithdraw.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				atmMethods.withdraw(previewWithdraw.getText());
				Transaction transaction = new Transaction("WITHDRAW",previewWithdraw.getText());
				addTransaction(transaction);
				previewWithdraw.setText("");
				start = max;
				window.setScene(scene2);
			}
		});
        button11.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewWithdraw.setText(previewWithdraw.getText()+button11.getText());
			}
		});
		button22.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button22.getText());
			}
		});
		button33.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewWithdraw.setText(previewWithdraw.getText()+button33.getText());
			}
		});
		button44.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				previewWithdraw.setText(previewWithdraw.getText()+button44.getText());
			}
		});;
		button55.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button55.getText());
			}
		});
		button66.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button66.getText());
			}
		});
		button77.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button77.getText());
			}
		});
		button88.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button88.getText());
			}
		});
		button99.setOnAction(new  EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button99.getText());
			}
		});
		button00.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				previewWithdraw.setText(previewWithdraw.getText()+button00.getText());
			}
		});

		GridPane layoutThreeWithdraw = new GridPane();
				
		layoutThreeWithdraw.add(previewWithdraw, 200, 0);
		layoutThreeWithdraw.add(submitWithdraw, 200, 2);
		layoutThreeWithdraw.add(button11, 0, 1);
		layoutThreeWithdraw.add(button22, 1, 1);
		layoutThreeWithdraw.add(button33, 2, 1);
		layoutThreeWithdraw.add(button44, 0, 2);
		layoutThreeWithdraw.add(button55, 1, 2);
		layoutThreeWithdraw.add(button66, 2, 2);
		layoutThreeWithdraw.add(button77, 0, 3);
		layoutThreeWithdraw.add(button88, 1, 3);
		layoutThreeWithdraw.add(button99, 2, 3);
		layoutThreeWithdraw.add(button00, 1, 4);

				
		sceneThreeWithdraw = new Scene(layoutThreeWithdraw,300,250);

		window.setScene(scene1);
		window.show();
		
		
	}
	
	public void addTransaction(Transaction transaction)
	{
		long x=Long.parseLong(transaction.getValue());
		if (x == 0)
			return ;
		if (transactionList.size() < 5)
		{
			transactionList.add(transaction);
			start++;
			max++;
		}
		else
		{
			transactionList.remove(0);
			transactionList.add(transaction);
		}
	}







}
