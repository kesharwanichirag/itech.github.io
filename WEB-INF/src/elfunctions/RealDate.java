package	elfunctions;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class RealDate{
	public static String realDate(Timestamp realDate){
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a, dd/MMM/yyyy");

		return sdf.format(realDate);
	}
}