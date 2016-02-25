package de.michel.rcp.intro.editor.wizard;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewDataPage2 extends WizardPage {
	private Text strasse,hnr,plz,ort,land;
	private Composite container;

	public NewDataPage2() {
		super("Bitte Adresse angeben!");
		setTitle("Bitte die Adresse ausfüllen");
		setDescription("Zur Vervollständigung wird die Adresse noch benötigt.");
	}

	@Override
	public void createControl(Composite parent) {
		
		final Display display = Display.getCurrent();
		
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		// Strasse
		Label strasseLabel = new Label(container, SWT.NONE);
		strasseLabel.setText("Strasse: ");
		strasse = new Text(container, SWT.BORDER);
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		strasse.setLayoutData(gridData);
		
		strasse.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				checkInput();
			}

		});
		
		
		// Hnr
		Label hnrLabel = new Label(container, SWT.NONE);
		hnrLabel.setText("Hnr: ");
		hnr = new Text(container, SWT.BORDER);
		
		hnr.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkInput();			
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		strasse.setLayoutData(gridData);
		
		// PLZ
		Label plzLabel = new Label(container, SWT.NONE);
		plzLabel.setText("PLZ: ");
		plz = new Text(container, SWT.BORDER);
		
		
		plz.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				try 
				{ 
					Integer.parseInt(plz.getText().trim());
					plz.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
					checkInput();
				} 
				catch ( NumberFormatException e1 ) {
					
					plz.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));					
				}							
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		plz.setLayoutData(gridData);
		
		// Ort
		Label ortLabel = new Label(container, SWT.NONE);
		ortLabel.setText("Ort: ");
		ort = new Text(container, SWT.BORDER);
		
		ort.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkInput();				
				}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		ort.setLayoutData(gridData);
		
		// Land
		Label landLabel = new Label(container, SWT.NONE);
		landLabel.setText("Land: ");
		land = new Text(container, SWT.BORDER);
		
		land.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				checkInput();				
				}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		land.setLayoutData(gridData);
	
		
		setControl(container);
		setPageComplete(false);

	}

	public String getStrasse() {
		return strasse.getText();
	}
	
	public String getHnr() {
		return hnr.getText();
	}
	
	public int getPlz() {
		return Integer.parseInt(plz.getText());
	}
	
	public String getOrt() {
		return ort.getText();
	}
	
	public String getLand() {
		return land.getText();
	}
	
	private void checkInput(){
		
		if (!strasse.getText().isEmpty() 
				&& !hnr.getText().isEmpty()
				&& !plz.getText().isEmpty()
				&& !ort.getText().isEmpty()
				&& !land.getText().isEmpty()) {
			setPageComplete(true);
		}else{
			setPageComplete(false);
		}
	}

}

