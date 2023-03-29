package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_URL="https://demo.nopcommerce.com/";
	public static final String ADMIN_URL="https://admin-demo.nopcommerce.com/";
	
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles"+File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator  + "downloadFiles"+File.separator;
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs"+File.separator;
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5"+File.separator;
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots"+File.separator;
	public static final String DB_URL = "";
	public static final String DB_USER="";
	public static final String DB_PASS = "";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;
	public static final String JAVA_VERSION = System.getProperty("java.version");
}
