package purdueGUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class LoginGUIpage {

	protected Shell shell;
	private Label phoneNumberLabel;
	private Text phoneNumberTextField;
	private Label phoneNumberHiddenLabel_1;
	private Label itemNumberLabel;
	private Text itemNumberTextField;
	private Text phoneNumberTextfield1;
	private Text itemNumberTextfield;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginGUIpage window = new LoginGUIpage();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label orderPageLabel = new Label(shell, SWT.NONE);
		orderPageLabel.setBounds(10, 10, 74, 19);
		orderPageLabel.setText("Order Page");
		
		Label phoneNumberLabel_1 = new Label(shell, SWT.NONE);
		phoneNumberLabel_1.setText("Phone #");
		phoneNumberLabel_1.setBounds(10, 47, 59, 14);
		
		Label phoneNumberHiddenLabel_1 = new Label(shell, SWT.NONE);
		phoneNumberHiddenLabel_1.setVisible(false);
		phoneNumberHiddenLabel_1.setText("New Label");
		phoneNumberHiddenLabel_1.setBounds(356, 47, 59, 14);
		
		phoneNumberTextfield1 = new Text(shell, SWT.BORDER);
		phoneNumberTextfield1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String inputPhoneNumber = phoneNumberTextfield1.getText();
				
				if(!inputPhoneNumber.matches("\\d{3}-\\d{3}-\\d{4}"))
				{
					phoneNumberHiddenLabel_1.setText("Error");
					phoneNumberHiddenLabel_1.setVisible(true);
				
				} else {
					phoneNumberHiddenLabel_1.setVisible(false);
					
				}
			}
		});
		phoneNumberTextfield1.setBounds(100, 44, 105, 19);
		
		
		
		Label selectionLabel = new Label(shell, SWT.NONE);
		selectionLabel.setText("Selection:");
		selectionLabel.setBounds(10, 85, 74, 14);
		
		Combo dropDownMenu = new Combo(shell, SWT.NONE);
		dropDownMenu.setBounds(100, 85, 207, 27);
		dropDownMenu.add("Chocolate Chip Cookie $2.00");
		dropDownMenu.add("Potato Chips $1.50");
		dropDownMenu.add("Gatorade $1.00");
		dropDownMenu.add("Chocolate Bar $1.35");
		dropDownMenu.add("Peanut Butter Sandwich $4.50");
		dropDownMenu.add("Granola Bar $0.75");
		dropDownMenu.add("Bottled Water $1.25");
		dropDownMenu.add("Soda Pop $2.00");
		
		Label itemNumberLabel_1 = new Label(shell, SWT.NONE);
		itemNumberLabel_1.setText("# of Items:");
		itemNumberLabel_1.setBounds(10, 130, 74, 14);
		
		Label itemNumberHiddenLabel = new Label(shell, SWT.NONE);
		itemNumberHiddenLabel.setVisible(false);
		itemNumberHiddenLabel.setText("Error");
		itemNumberHiddenLabel.setBounds(356, 130, 59, 14);
		
		itemNumberTextfield = new Text(shell, SWT.BORDER);
		itemNumberTextfield.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String inputItemNumber = itemNumberTextfield.getText();
				if ((inputItemNumber.equals(""))||(!inputItemNumber.matches("[0-9]*"))){
					itemNumberHiddenLabel.setText("Error");
					itemNumberHiddenLabel.setVisible(true);
				} else {
				
				int x = Integer.parseInt(inputItemNumber);
				
				
				if ((x <= 0)||(x > 20))
				{
					itemNumberHiddenLabel.setText("Error");
					itemNumberHiddenLabel.setVisible(true);
					
				} else {
					
					itemNumberHiddenLabel.setVisible(false);
				
				
				}
			}	
			}
		});
		itemNumberTextfield.setBounds(100, 130, 64, 19);
		
		Label totalPriceLabel = new Label(shell, SWT.NONE);
		totalPriceLabel.setBounds(279, 165, 136, 14);
		totalPriceLabel.setVisible(false);
		
		Button btnSubmitOrder = new Button(shell, SWT.NONE);
		btnSubmitOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if((phoneNumberTextfield1.getText().equals("")) || (dropDownMenu.getText().equals("")) || (itemNumberTextfield.getText().equals("")) || (phoneNumberHiddenLabel_1.getVisible() == true) || (itemNumberHiddenLabel.getVisible() == true))
				{
					totalPriceLabel.setText("Order Error");
					totalPriceLabel.setVisible(true);

				} 
				else if(dropDownMenu.getText().equals("Chocolate Chip Cookie $2.00"))
				{	
					double totalPrice = 2.00 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				} 
				else if(dropDownMenu.getText().equals("Potato Chips $1.50"))
				{
					double totalPrice = 1.50 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Gatorade $1.00"))
				{
					double totalPrice = 1.00 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Chocolate Bar $1.35"))
				{
					double totalPrice = 1.35 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Peanut Butter Sandwich $4.50"))
				{
					double totalPrice = 4.50 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Granola Bar $0.75"))
				{
					double totalPrice = 0.75 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Bottled Water $1.25"))
				{
					double totalPrice = 1.25 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				else if(dropDownMenu.getText().equals("Soda Pop $2.00"))
				{
					double totalPrice = 2.00 * Double.parseDouble(itemNumberTextfield.getText());
					totalPriceLabel.setText("Your total is: $" + String.valueOf(totalPrice) + "0");
				}
				
			}
		});
		btnSubmitOrder.setBounds(10, 165, 116, 27);
		btnSubmitOrder.setText("Submit Order");
		
		

	}
}
