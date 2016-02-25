package de.michel.rcp.intro.editor.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class NewDataPage1 extends WizardPage {
	private Text vorname, nachname;
	private Composite container;
	Combo geschlecht;

	public NewDataPage1() {
		super("Bitte Name und Geschlecht eingeben");
		setTitle("Bitte Name und Geschlecht eingeben");
		setDescription("Dieser Wizard lässt Sie eine neue Person erstellen.");
	}

	
	public void createControl(Composite parent) {
		
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		// Vorname
		Label vornameLabel = new Label(container, SWT.NONE);
		vornameLabel.setText("Vorname: ");
		vorname = new Text(container, SWT.BORDER);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		vorname.setLayoutData(gridData);
		
		vorname.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				if(!nachname.getText().isEmpty() && !vorname.getText().isEmpty() && geschlecht.getSelectionIndex() != -1){
					setPageComplete(true);
				}else{
					setPageComplete(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}

		});
		
		
		// Nachname
		Label nachnameLabel = new Label(container, SWT.NONE);
		nachnameLabel.setText("Nachname: ");
		nachname = new Text(container, SWT.BORDER);
		
		nachname.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(!nachname.getText().isEmpty() && !vorname.getText().isEmpty() && geschlecht.getSelectionIndex() != -1){
					setPageComplete(true);
				}else{
					setPageComplete(false);
				}	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
										
			}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		nachname.setLayoutData(gridData);
		
		// Geschlecht		
		Label geschlechtLabel = new Label(container, SWT.NONE);
		geschlechtLabel.setText("Geschlecht: ");
		
		geschlecht = new Combo (container, SWT.READ_ONLY);
		geschlecht.setItems (new String [] {"männlich", "weiblich"});
		geschlecht.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!nachname.getText().isEmpty() && !vorname.getText().isEmpty() && geschlecht.getSelectionIndex() != -1){
					setPageComplete(true);
				}else{
					setPageComplete(false);
				}				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		geschlecht.setLayoutData(gridData);
	
		
		setControl(container);
		setPageComplete(false);
		
	}

	public String getVorname() {
		return vorname.getText();
	}
	
	public String getNachname() {
		return nachname.getText();
	}
	
	public String getGeschlecht() {
		return geschlecht.getText();
	}
				
	}
