package com.serge.rough;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimeStamp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();	
		System.out.println(d);
		
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH:mm:ss");

		String dateString = format.format( new Date()   );
		
		System.out.println(dateString+".jpg");
	}

}
