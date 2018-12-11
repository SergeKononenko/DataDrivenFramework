package com.serge.rough;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.serge.uilities.SendEmail;

public class TestHostAddress {

	public static void main(String[] args)
			throws UnknownHostException, AddressException, MessagingException {

		String USER_NAME = "sergey.ucl@gmail.com"; // GMail user name (just the part
								// before "@gmail.com")
		String PASSWORD = ""; // GMail password
		String RECIPIENT = "sergey.ucl@gmail.com";

		String from = USER_NAME;

		String[] to = { "sergey.ucl@gmail.com" }; // list of recipient email addresses
		String subject = "Java send mail example";
		String body = "Test Suite Finished @ - "+ new Date() + "\nhttp://"
				+ InetAddress.getLocalHost().getHostAddress()
				+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";

		SendEmail mail = new SendEmail();
		mail.sendFromGMailTLS(from, to, subject, body);
		

	}

}
