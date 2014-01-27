package cn.jhc.myexam.vaadin.wizard;

import java.util.List;

/**
 * Callback used by {@link ExcelUploadWizard}.
 * @author luyanfei
 *
 * @param <T>
 * 		Entity type.
 */
public interface ExcelUploadWizardCallback<T> {
	/**
	 * Implementor should provide persistence logic here. Don't forget to refresh vaadin table behind.
	 * @param list
	 * 		the entity list that should be persisted in db.
	 */
	public void saveList(List<T> list);
	/**
	 * Entity that cann't be persisted should be informed.
	 * @return
	 * 		entities that failed to persist. The return list can be an empty list, but should not be null.
	 */
	public List<T> getFailedList();
	/**
	 * This method will be called after user click "finish" button is wizard.
	 */
	public void afterFinish();
}
