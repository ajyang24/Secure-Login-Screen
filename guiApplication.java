package purdueGUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.awt.Color;
import java.awt.Image;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TouchListener;
import org.eclipse.swt.events.TouchEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class guiApplication {

	protected Shell shell;
	private Text text;
	private Text usernameTextfield;
	private Text passwordTextfield;
	private Label passwordLabel;
	private Label passwordHiddenLabel;
	private Label idLabel;
	private Text idTextField;
	private Label idHiddenLabel;
	private Label phoneNumberHiddenLabel_1;
	private Label loginPageLabel;
	private Label loginWarningLabel;
	ImageIcon imagePNWLogo = new ImageIcon("PurdueNorthwestLogo.png");

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			guiApplication window = new guiApplication();
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
		
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		
		panel_1.setBackground(Color.CYAN);
		panel_2.setBackground(Color.DARK_GRAY);
				
		Label usernameLabel = new Label(shell, SWT.NONE);
		usernameLabel.setBounds(10, 55, 74, 21);
		usernameLabel.setText("Username");
		
		Label usernameHiddenLabel = new Label(shell, SWT.NONE);
		usernameHiddenLabel.setVisible(false);
		usernameHiddenLabel.setBounds(331, 55, 59, 14);
		usernameHiddenLabel.setText("New Label");
		
		usernameTextfield = new Text(shell, SWT.BORDER);
		usernameTextfield.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String inputText = usernameTextfield.getText();
				
				if ((!inputText.matches("[a-zA-Z]*"))||(inputText.equals("")))
				{
					usernameHiddenLabel.setText("Error");
					usernameHiddenLabel.setVisible(true);
					//usernameHiddenLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));

				} else {
					usernameHiddenLabel.setVisible(false);
					
				
				}
			}
			
		});
		usernameTextfield.setBounds(112, 52, 105, 19);
		
		
		
		passwordHiddenLabel = new Label(shell, SWT.NONE);
		passwordHiddenLabel.setVisible(false);
		passwordHiddenLabel.setBounds(331, 93, 59, 14);
		passwordHiddenLabel.setText("New Label");
		
		
		passwordLabel = new Label(shell, SWT.NONE);
		passwordLabel.setBounds(10, 93, 59, 14);
		passwordLabel.setText("Password");

		
		passwordTextfield = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		passwordTextfield.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String inputPassword = passwordTextfield.getText();				
				if ((!inputPassword.matches("[a-zA-Z0-9]*"))||(inputPassword.equals("")))
				{
					passwordHiddenLabel.setText("Error");
					passwordHiddenLabel.setVisible(true);
					
				} else {
					passwordHiddenLabel.setVisible(false);
					
				
				}
			}
		});
		passwordTextfield.setBounds(112, 90, 105, 19);
		
		idHiddenLabel = new Label(shell, SWT.NONE);
		idHiddenLabel.setVisible(false);
		idHiddenLabel.setBounds(331, 133, 59, 14);
		idHiddenLabel.setText("New Label");
		
		idLabel = new Label(shell, SWT.NONE);
		idLabel.setBounds(10, 133, 59, 14);
		idLabel.setText("ID");
		
		idTextField = new Text(shell, SWT.BORDER);
		idTextField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String inputID = idTextField.getText();
				
				if ((!inputID.matches("[0-9]*"))||(inputID.equals(""))||(inputID.length() != 9))
				{
					idHiddenLabel.setText("Error");
					idHiddenLabel.setVisible(true);
					
				} else {
					
					idHiddenLabel.setVisible(false);
				}
				
				
			}
		});
		idTextField.setBounds(112, 130, 105, 19);
		
		
		phoneNumberHiddenLabel_1 = new Label(shell, SWT.NONE);
		phoneNumberHiddenLabel_1.setVisible(false);
		phoneNumberHiddenLabel_1.setBounds(331, 133, 59, 14);
		phoneNumberHiddenLabel_1.setText("New Label");
		
		String[] menuItems = new String[] {"Chocolate Chip Cookie", "Potato Chips", "Gatorade", "Chocolate Bar", "Peanut Butter Sandwich", "Granola Bar", "Bottled Water", "Soda Pop"};
		
		Label itemNumberHiddenLabel = new Label(shell, SWT.NONE);
		itemNumberHiddenLabel.setBounds(331, 214, 59, 14);
		itemNumberHiddenLabel.setVisible(false);
		itemNumberHiddenLabel.setText("Error");
	
		Label priceLabel = new Label(shell, SWT.NONE);
		priceLabel.setBounds(286, 241, 119, 21);
		priceLabel.setVisible(false);		
		priceLabel.setText("New Label");
		
		loginWarningLabel = new Label(shell, SWT.NONE);
		loginWarningLabel.setBounds(271, 173, 119, 32);
		loginWarningLabel.setVisible(false);
		loginWarningLabel.setText("New Label");
		
		Button loginButton = new Button(shell, SWT.NONE);
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if((usernameTextfield.getText().equals("")) || (passwordTextfield.getText().equals("")) || (idTextField.getText().equals("")))
				{
					loginWarningLabel.setText("Login Error");
					loginWarningLabel.setVisible(true);
					
				} else if((usernameHiddenLabel.getVisible() == true) || (passwordHiddenLabel.getVisible() == true) || (idHiddenLabel.getVisible() == true))
				{
					loginWarningLabel.setText("Login Error");
					loginWarningLabel.setVisible(true);
				}
				else if((usernameHiddenLabel.getVisible() == false) && (passwordHiddenLabel.getVisible() == false) && (idHiddenLabel.getVisible() == false))
				{
					loginWarningLabel.setText("Login Successful!");
					LoginGUIpage window = new LoginGUIpage(); 
					window.open();
				}
				
			
			}
		});
	
		loginButton.setBounds(10, 167, 94, 27);
		loginButton.setText("Login");
		
		loginPageLabel = new Label(shell, SWT.NONE);
		loginPageLabel.setBounds(10, 10, 74, 21);
		loginPageLabel.setText("Login Page");
		
		Label pnwLabelPic = new Label(shell, SWT.NONE);
		pnwLabelPic.setBounds(271, 10, 156, 21);
//		pnwLabelPic.setIcon("imagePNWLogo.png");
		
		
		
		
		
		
		
		
		
		
	}
}
