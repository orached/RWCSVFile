import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CurrentDate {
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	//get current date time with Date()
	public static String getCurrentDate(){
	Date date = new Date();
	return dateFormat.format(date).toString();
	}
}
