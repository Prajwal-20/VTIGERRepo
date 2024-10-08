package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilityFile {

	//Generate Random number
	public int getRandomNumber() {
		Random random = new Random();
		int r = random.nextInt(5000);
		return r;
	}
	
	// Capture the System date
	public String getSystemDateyyyyMMdd() {
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-DD");
		String date = sim.format(dateobj);
		return date;
	}
	
	//Get Required Data
	
		public String getRequiredDateyyyMMdd(int days) {
			Date dateObj= new Date();
			SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
			sim.format(dateObj);
			Calendar cal = sim.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,days);
			String reqDate = sim.format(cal.getTime());
			return reqDate;
		}

		// syatem date and time
	     public String dateAndTime() {
	    	 Date d = new Date();
	    	String date = d.toString().replace(':','_').replace(' ','_');
	    	System.out.println(date);
	    	return date;
	     }
	     
	     
	    
	
}
