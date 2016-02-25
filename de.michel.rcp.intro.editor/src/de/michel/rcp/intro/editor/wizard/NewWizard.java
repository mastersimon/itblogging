package de.michel.rcp.intro.editor.wizard;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import de.michel.rcp.intro.editor.View;
import de.michel.rcp.intro.editor.db.DatenbankListe;
import de.michel.rcp.intro.editor.model.Adresse;
import de.michel.rcp.intro.editor.model.MyModel;
import de.michel.rcp.intro.editor.model.Person;


public class NewWizard extends Wizard {

	private NewDataPage1 one;
	private NewDataPage2 two;

	public NewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		one = new NewDataPage1();
		two = new NewDataPage2();
		addPage(one);
		addPage(two);
	}

	@Override
	public boolean performFinish() {
		
		Person p = new Person(0,one.getVorname().trim(),one.getNachname().trim(),one.getGeschlecht());
		p.setAdresse(new Adresse(0,two.getStrasse().trim(), two.getHnr().trim(), two.getPlz(), two.getOrt().trim(), two.getLand().trim()));

		if(DatenbankListe.getDieDatenbank().insertPerson(p)){
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			View view = (View) page.findView(View.ID);
			view.getViewer().setInput(new MyModel());	
			return true;			
		}
		return false;
	}
}
