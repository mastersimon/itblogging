package de.michel.rcp.intro.editor.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;


import de.michel.rcp.intro.editor.View;
import de.michel.rcp.intro.editor.model.MyModel;

public class Refresh extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {		
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);		
		IWorkbenchPage page = window.getActivePage();
		View view = (View) page.findView(View.ID);
		view.getViewer().setInput(new MyModel());		
		return null;
	}
}

