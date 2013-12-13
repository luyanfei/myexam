package cn.jhc.myexam.vaadin.util;

import org.eobjects.metamodel.schema.Table;

public class ImportUsersExcelFileUploadHandler extends ExcelFileUploadHandler {

	@Override
	protected void showDataWindow(Table sheet) {
	}

	@Override
	protected boolean validateColumnNames(Table sheet) {
		return false;
	}

}
