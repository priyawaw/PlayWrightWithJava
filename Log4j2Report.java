package PlayWrightSessions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Report {

	private static final Logger log = LogManager.getLogger(Log4j2Report.class);

	public static void main(String[] args) {

		log.error("Test error log");
		log.info("Information log");
		log.debug("Debug log");
	}
}
