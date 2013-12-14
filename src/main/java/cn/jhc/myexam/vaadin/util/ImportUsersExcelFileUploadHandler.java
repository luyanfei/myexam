package cn.jhc.myexam.vaadin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.eobjects.metamodel.DataContext;
import org.eobjects.metamodel.data.DataSet;
import org.eobjects.metamodel.data.Row;
import org.eobjects.metamodel.query.Query;
import org.eobjects.metamodel.schema.Column;
import org.eobjects.metamodel.schema.Schema;
import org.eobjects.metamodel.schema.Table;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.vaadin.component.ConfirmImportRecordComponent;
import cn.jhc.myexam.vaadin.component.ImportUsersWindow;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import com.vaadin.ui.Table.ColumnHeaderMode;

@SuppressWarnings("serial")
public class ImportUsersExcelFileUploadHandler extends ExcelFileUploadHandler {
	
	private static final Logger logger = Logger.getLogger(ImportUsersExcelFileUploadHandler.class.getName());
	private Column usernameColumn;
	private Column displayNameColumn;

	@Override
	protected void showDataWindow(DataContext context) {
		Table table = context.getDefaultSchema().getTable(0);
		Query query = context.query().from(table)
				.select(usernameColumn, displayNameColumn)
				.toQuery();
		logger.fine("MetaModel SQL: " + query.toString());
		
		List<User> list = new ArrayList<User>();
		DataSet dataSet = context.executeQuery(query);
		while(dataSet.next()) {
			Row row = dataSet.getRow();
			User user = new User();
			String username = (String)row.getValue(usernameColumn);
			user.setUsername(username);
			user.setPassword(username);
			user.setDisplayName((String)row.getValue(displayNameColumn));
			user.setEnabled(true);
			list.add(user);
		}
		
		//构建Vaadin Table
		com.vaadin.ui.Table usersTable = new com.vaadin.ui.Table();
		BeanItemContainer<User> container = new BeanItemContainer<User>(User.class,list);
		usersTable.setContainerDataSource(container, Arrays.asList("username","enabled","displayName"));
		usersTable.setColumnHeaderMode(ColumnHeaderMode.EXPLICIT);
		usersTable.setColumnHeaders("准考证号","启用","用户名");
		
		Component confirmComponent = new ConfirmImportRecordComponent(usersTable);
		Window importUsersWindow = WindowUtils.findWindowById(Constants.ID_IMPORT_USERS_WINDOW);
		importUsersWindow.setCaption("确认导入的考生数据");
		importUsersWindow.setContent(confirmComponent);
		importUsersWindow.center();
	}

	@Override
	protected boolean validateColumnNames(DataContext context) {
		Schema schema = context.getDefaultSchema();
		Table sheet = schema.getTable(0);
		usernameColumn = sheet.getColumnByName(ImportUsersWindow.USERNAME);
		displayNameColumn = sheet.getColumnByName(ImportUsersWindow.DISPLAYNAME);
		if(usernameColumn == null || displayNameColumn == null)
			return false;
		return true;
	}

}
