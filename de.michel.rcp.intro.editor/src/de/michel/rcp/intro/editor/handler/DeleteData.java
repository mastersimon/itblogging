package de.michel.rcp.intro.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.michel.rcp.intro.editor.View;
import de.michel.rcp.intro.editor.db.DatenbankListe;
import de.michel.rcp.intro.editor.model.MyModel;
import de.michel.rcp.intro.editor.model.Person;

public class DeleteData  extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);		
		IWorkbenchPage page = window.getActivePage();
		View view = (View) page.findView(View.ID);
		TableViewer viewer = view.getViewer();
		
		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		Person person = (Person) obj;
		
		if(person == null){
			MessageDialog.openError(shell, "Fehlermeldung", "Sie haben keine Person ausgewählt\n\n" +
					"Wählen Sie aus der Liste auf der linken Seite bitte einen Namen den Sie löschen möchten.");
		}
		
		String title = person.getVorname() + " " + person.getNachname() + " löschen?";
		String text = "Sind Sie sicher das sie " + person.getVorname() + " " + person.getNachname() + " löschen wollen?";
		boolean delete = MessageDialog.openConfirm(shell, title, text);
		
		if(delete)
		{
			if(DatenbankListe.getDieDatenbank().deletePerson(person.getId())){
				  viewer.setInput(new MyModel());
			}
		}
		
		return null;
	}

}