package de.michel.rcp.intro.editor.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


import de.michel.rcp.intro.editor.View;
import de.michel.rcp.intro.editor.db.DatenbankListe;
import de.michel.rcp.intro.editor.model.Adresse;
import de.michel.rcp.intro.editor.model.MyModel;
import de.michel.rcp.intro.editor.model.Person;

public class MyPersonEditor extends EditorPart {
	public static final String ID = "de.michel.rcp.intro.editor.editors.MyPersonEditor";
	private Person person;
	private Text vorname, nachname, str, hnr, plz, ort, land;
	Button speichernBtn, abbrechenBtn;
	Combo geschlecht;
	static List list;
	static Browser browser;
	
	public MyPersonEditor() {
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		saveData();		
		updateListe();
	}

	@Override
	public void doSaveAs() {
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
		person = ((MyPersonEditorInput) input).getPerson();
		setPartName(person.getVorname());
	}

	@Override
	public boolean isDirty() {		
		if(checkInput()){			
			return true;
		}		
		return false;
	}
	
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		
		Layout layout = new GridLayout(3, false);		
		parent.setLayout(layout);

		// Vorname
		Label vornameLabel = new Label(parent, SWT.NONE);
		vornameLabel.setText("Vorname: ");
		vorname = new Text(parent, SWT.BORDER);
		
		GridData gridData = new GridData();
		gridData.widthHint = 217;
		gridData.horizontalSpan = 2;

		gridData.grabExcessHorizontalSpace = true;
		vorname.setLayoutData(gridData);
		
		// Nachname
		Label nachnameLabel = new Label(parent, SWT.NONE);
		nachnameLabel.setText("Nachname: ");
		nachname = new Text(parent, SWT.BORDER);
		
		gridData = new GridData();
		gridData.widthHint = 217;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		nachname.setLayoutData(gridData);
		
		// Strasse
		Label strLabel = new Label(parent, SWT.NONE);
		strLabel.setText("Strasse Hnr.: ");
		str = new Text(parent, SWT.BORDER);
		
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.widthHint = 100;
		str.setLayoutData(gridData);
		
		// Hnr
		hnr = new Text(parent, SWT.BORDER);		

		gridData = new GridData();				
		gridData.grabExcessHorizontalSpace = true;
		gridData.widthHint = 100;
		hnr.setLayoutData(gridData);
			
		// PLZ
		Label plzLabel = new Label(parent, SWT.BEGINNING);
		plzLabel.setText("Plz Ort: ");
		plz = new Text(parent, SWT.BORDER);
		
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		plz.setLayoutData(gridData);
		plz.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				try 
				{ 
					Integer.parseInt(plz.getText().trim());
					plz.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
					checkInput();
				} 
				catch ( NumberFormatException e1 ) {
					
					plz.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));					
				}	
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		// Ort
		ort = new Text(parent, SWT.BORDER);
		
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.NONE;		
		gridData.widthHint = 100;
		
		gridData.grabExcessHorizontalSpace = true;		
		ort.setLayoutData(gridData);
		
		// Land
		Label landLabel = new Label(parent, SWT.NONE);
		landLabel.setText("Land: ");
		land = new Text(parent, SWT.BORDER);
		
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		gridData.widthHint = 217;
		land.setLayoutData(gridData);
		
		// Geschlecht		
		Label geschlechtLabel = new Label(parent, SWT.NONE);
		geschlechtLabel.setText("Geschlecht: ");
		
		geschlecht = new Combo (parent, SWT.READ_ONLY);
		geschlecht.setItems (new String [] {"männlich", "weiblich"});
		
		gridData = new GridData();
		gridData.widthHint = 202;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		geschlecht.setLayoutData(gridData);
		
		setToDefault();
		
		// Speichern-Button
		speichernBtn = new Button(parent, SWT.PUSH);
		speichernBtn.setText("Speichern"); 
		speichernBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(checkInput() == true) {
					saveData();
					updateListe();					
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}			
		});
		
		// Speichern-Button
		abbrechenBtn = new Button(parent, SWT.PUSH);
		abbrechenBtn.setText("Abbrechen"); 
		abbrechenBtn.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				setToDefault();				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}			
		});
		
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		//Browser
		gridData = new GridData();
		gridData.horizontalSpan = 3;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = SWT.FILL;
		gridData.grabExcessVerticalSpace = true;
		
		new Label(parent, SWT.NONE);

		
		browser = new Browser(parent, SWT.NONE);

		browser.addControlListener(new ControlListener() {
			public void controlResized(ControlEvent e) {
				// Use Javascript to set the browser width and height
				browser.execute("document.getElementById('map_canvas').style.width= "
								+ (browser.getSize().x - 20) + ";");
				browser.execute("document.getElementById('map_canvas').style.height= "
								+ (browser.getSize().y - 20) + ";");
			}

			public void controlMoved(ControlEvent e) {
			}
		});
		 
		browser.setText(createHTML(person));		
	    browser.setLayoutData(gridData);
	}
	
	private boolean checkInput(){
		boolean dirty = false;
		int plzInt = 0;
		
		try 
		{ 
			plzInt = Integer.parseInt(plz.getText().trim()); 
		} 
		catch ( NumberFormatException e ) {
			plz.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));			
			return true;
		}
		
		if (!person.getVorname().equals(vorname.getText().trim())) dirty = true;
		if (!person.getNachname().equals(nachname.getText().trim())) dirty = true;
		if (!person.getGeschlecht().equals(geschlecht.getText())) dirty = true;
		if (!person.getAdresse().getStrasse().equals(str.getText().trim())) dirty = true;
		if (!person.getAdresse().getHnr().equals(hnr.getText().trim())) dirty = true;
		if (person.getAdresse().getPlz() != plzInt) dirty = true;
		if (!person.getAdresse().getOrt().equals(ort.getText().trim())) dirty = true;
		if (!person.getAdresse().getLand().equals(land.getText().trim())) dirty = true;		
		if(dirty) return true;
		return false;		
	}
	
	private void saveData(){	
		Person p = new Person(person.getId(), vorname.getText().trim(), 
				nachname.getText().trim(), geschlecht.getText());
		int plzInt = Integer.parseInt(plz.getText());		
		p.setAdresse(new Adresse(person.getId(), str.getText().trim(), 
				hnr.getText().trim(), plzInt, ort.getText().trim(), land.getText().trim()));
		if(DatenbankListe.getDieDatenbank().updatePerson(p))
		{	
			refreshLabels();			
			browser.setText(createHTML(person));
			
			
		}
	}
	
	private void setToDefault(){
		vorname.setText(person.getVorname());		
		nachname.setText(person.getNachname());
		str.setText(person.getAdresse().getStrasse());
		hnr.setText(person.getAdresse().getHnr() + "");
		plz.setText(person.getAdresse().getPlz() + "");
		ort.setText(person.getAdresse().getOrt());
		land.setText(person.getAdresse().getLand());
		plz.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		if(person.getGeschlecht().equals("männlich")) geschlecht.select(0); else geschlecht.select(1);		
	}
	
	private void refreshLabels(){
		person.setNachname(nachname.getText().trim());
		person.setVorname(vorname.getText().trim());
		person.setGeschlecht(geschlecht.getText());
		person.getAdresse().setStrasse(str.getText().trim());
		person.getAdresse().setHnr(hnr.getText().trim());
		person.getAdresse().setPlz(Integer.parseInt(plz.getText()));
		person.getAdresse().setOrt(ort.getText().trim());
		person.getAdresse().setLand(land.getText().trim());	
		setPartName(person.getVorname());
	}
		
	private void updateListe(){				
		IWorkbenchPage page = getSite().getPage();
		View view = (View) page.findView(View.ID);
		view.getViewer().setInput(new MyModel());	
	}
	
	

	@Override
	public void setFocus() {
	}
	
	static String createHTML (Person person) {
		String adresse = person.getAdresse().getStrasse() + " " + person.getAdresse().getHnr() + ", " + person.getAdresse().getOrt();
		String adresseInfo = person.getVorname() + " " + person.getNachname() + "<br> " 
								+ person.getAdresse().getStrasse() + " " + person.getAdresse().getHnr() + "<br> " 
								+ person.getAdresse().getOrt();
		StringBuffer buffer = new StringBuffer ();		
		buffer.append("</html>\n");
		buffer.append("<!DOCTYPE html '-//W3C//DTD XHTML 1.0 Strict//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd'>");
		buffer.append("<html xmlns='http://www.w3.org/1999/xhtml'>");
		buffer.append("<head><meta http-equiv='content-type' content='text/html; charset=utf-8'/>");
		buffer.append("<title>Migration von RCP zu RAP - Michel</title>");
		buffer.append("<script src='http://maps.google.com/maps?file=api&amp;v=2&amp;key=abcdefg&sensor=false' type='text/javascript'>" +
				"</script> <script type='text/javascript'>");
		buffer.append("var map = null;" +
				"var geocoder = null;" +
				"function initialize() {" +
					"if (GBrowserIsCompatible()) {" +
					"map = new GMap2(document.getElementById('map_canvas'));" +
					"geocoder = new GClientGeocoder();" +
					"address = '" + adresse + "';adressInfo ='"+ adresseInfo +"';" +
					"if (geocoder) {" +
					"geocoder.getLatLng(" +
					"address," +
					"function(point) {" +
					"if (!point) {" +
					"alert(address + ' konnte nicht gefunden werden!');" +
					"} else {" +
					"map.setCenter(point, 14);" +
					"var marker = new GMarker(point);" +
					"map.addOverlay(marker);" +
					"marker.openInfoWindowHtml(adressInfo);" +
					"}});}}" +
					"map.setUIToDefault();}");
		buffer.append("</script></head><body scroll='no' onload='initialize()' >" +
				"<div id='map_canvas' style='width: 605px; height: 287px; margin-top:-15px; margin-left:-10px;'></div>" +
				"</body></html>");		
		return buffer.toString ();
	}

}