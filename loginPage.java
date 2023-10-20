package purdueGUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class loginPage {

	protected Shell shell;
	private Text text;
	private Text usernameTextfield;
	private Text passwordTextfield;
	private Label passwordLabel;
	private Label passwordHiddenLabel;
	private Label idLabel;
	private Text idTextField;
	private Label idHiddenLabel;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			loginPage window = new loginPage();
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
		
		Label usernameLabel = new Label(shell, SWT.NONE);
		usernameLabel.setBounds(23, 10, 74, 21);
		usernameLabel.setText("Username");
		
		Label usernameHiddenLabel = new Label(shell, SWT.NONE);
		usernameHiddenLabel.setVisible(false);
		usernameHiddenLabel.setBounds(331, 10, 59, 14);
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
		usernameTextfield.setBounds(112, 7, 105, 19);
		
		
		
		passwordHiddenLabel = new Label(shell, SWT.NONE);
		passwordHiddenLabel.setVisible(false);
		passwordHiddenLabel.setBounds(331, 51, 59, 14);
		passwordHiddenLabel.setText("New Label");
		
		
		passwordLabel = new Label(shell, SWT.NONE);
		passwordLabel.setBounds(23, 51, 59, 14);
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
		passwordTextfield.setBounds(112, 48, 105, 19);
		
		idHiddenLabel = new Label(shell, SWT.NONE);
		idHiddenLabel.setVisible(false);
		idHiddenLabel.setBounds(331, 92, 59, 14);
		idHiddenLabel.setText("New Label");
		
		idLabel = new Label(shell, SWT.NONE);
		idLabel.setBounds(23, 92, 59, 14);
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
		idTextField.setBounds(112, 87, 105, 19);

		Button submitButton = new Button(shell, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if((usernameHiddenLabel.getVisible() == false) && (passwordHiddenLabel.getVisible() == false) && (idHiddenLabel.getVisible() == false))
				{
					
					
				}
			
			}
		});
	
		submitButton.setBounds(23, 132, 94, 27);
		submitButton.setText("Submit");
		
	}

}
