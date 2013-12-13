package cn.jhc.myexam.vaadin.util;

import org.eobjects.metamodel.DataContext;
import org.eobjects.metamodel.schema.Column;
import org.eobjects.metamodel.schema.Schema;
import org.eobjects.metamodel.schema.Table;

import cn.jhc.myexam.vaadin.component.ImportUsersWindow;

@SuppressWarnings("serial")
public class ImportUsersExcelFileUploadHandler extends ExcelFileUploadHandler {

	@Override
	protected void showDataWindow(DataContext context) {
	}

	@Override
	protected boolean validateColumnNames(DataContext context) {
		Schema schema = context.getDefaultSchema();
		Table sheet = schema.getTable(0);
		Column idColumn = sheet.getColumnByName(ImportUsersWindow.USERNAME);
		Column nameColumn = sheet.getColumnByName(ImportUsersWindow.DISPLAYNAME);
		if(idColumn == null || nameColumn == null)
			return false;
		return true;
	}

}
