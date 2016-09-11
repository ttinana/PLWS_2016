/**
 * 
 */
package rs.crhov.tijanap.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tijana.pavicic
 *
 */
public class App2016 {
	/**
	 * @param args
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	static Logger logger = LoggerFactory.getLogger(App2016.class);

	public static void main(String[] args) {
		
		
		try {
			runSceculed();
			//runInitial();

		} catch (Exception ex) {
			logger.error("  |ERROR| in |class App2016.main|" + ex);

		}
	}

	public static void runSceculed() {
		ScheduledTaskRunPLWS clientPLWS = new ScheduledTaskRunPLWS();
		clientPLWS.startScheduleTask();

	}

	/*public static void runInitial() throws IOException {
		InitialTaskRunPLWS clientPLWS = new InitialTaskRunPLWS();
		clientPLWS.startInitialTask();
	}*/

}