package PlayWrightSessions;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import Utilities.MonitoringMail;
import Utilities.TestConfig;

public class TestMail {

	public static void main(String[] args) throws AddressException, MessagingException {

		MonitoringMail mail = new MonitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody,
				TestConfig.attachmentPath, TestConfig.attachmentName);

	}

}
