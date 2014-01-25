package cn.jhc.myexam.vaadin.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eobjects.metamodel.DataContext;
import org.eobjects.metamodel.data.DataSet;
import org.eobjects.metamodel.data.Row;
import org.eobjects.metamodel.query.Query;
import org.eobjects.metamodel.schema.Column;
import org.eobjects.metamodel.schema.Schema;
import org.eobjects.metamodel.schema.Table;
import org.springframework.context.annotation.Scope;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.component.ConfirmImportRecordComponent;
import cn.jhc.myexam.vaadin.component.ImportUsersWindow;
import cn.jhc.myexam.vaadin.factory.EntityBuilderFactory;

import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@org.springframework.stereotype.Component
@Scope("prototype")
public class ImportUsersExcelFileUploadHandler {
	
	private static final Logger logger = Logger.getLogger(ImportUsersExcelFileUploadHandler.class.getName());
	private Column usernameColumn;
	private Column displayNameColumn;

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
		dataSet.close();
		
		//构建Vaadin Table
		com.vaadin.ui.Table usersTable = EntityBuilderFactory.getEntityBuilder(User.class).buildTable(list); 
		
		ConfirmImportRecordComponent confirmComponent = new ConfirmImportRecordComponent(usersTable);
		confirmComponent.addCommitButtonListener(new ImportUsersCommitButtonListener( confirmComponent.getTable()));
		
		Window importUsersWindow = WindowUtils.findWindowById(Constants.ID_IMPORT_USERS_WINDOW);
		importUsersWindow.setCaption("确认导入的考生数据");
		importUsersWindow.setContent(confirmComponent);
		importUsersWindow.center();
	}

}
