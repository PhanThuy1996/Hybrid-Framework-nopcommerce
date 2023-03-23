package pageUI.Jquery;

public class AppendGridUI {
	public final static String COLUMN_INDEX_BY_NAME="//tr/th[text()='%s']/preceding-sibling::th";
	public final static String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX="//tbody/tr[%s]/td[%s]/input";
	public final static String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX="//tbody/tr[%s]/td[%s]//select";
	public final static String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX="//tbody/tr[%s]/td[%s]//input[@type='checkbox']";
	public final static String LOAD_DATA_BUTTON="";	
}
