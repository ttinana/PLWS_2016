/**
 * 
 */
package rs.crhov.tijanap.main;

import java.io.IOException;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import rs.crhov.tijanap.soap.PrivredniSubjekat;
import rs.crhov.tijanap.util.CSVReader;
import rs.crhov.tijanap.util.CSVReader6;
import rs.crhov.tijanap.util.ReadExcelFile;

/**
 * @author tijana.pavicic
 *
 */
public class InitialTaskRunPLWS implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	static Logger logger = LoggerFactory.getLogger(ScheduledTaskRunPLWS.class);


	public static List<PrivredniSubjekat> runInitially(ApplicationContext applicationContext)
			throws IOException, DatatypeConfigurationException {

		ReadExcelFile readExcelFile = applicationContext.getBean("readExcelFile", ReadExcelFile.class);
		List<PrivredniSubjekat> listOfPSInicijalno = readExcelFile.readPrivredniSubjekatFromExcel();
		return listOfPSInicijalno;

	}
	
	public static List<PrivredniSubjekat> runInitiallyCSV(ApplicationContext applicationContext)
			throws IOException, DatatypeConfigurationException {

		CSVReader reader = applicationContext.getBean("cSVReader", CSVReader.class);		
		List<PrivredniSubjekat> listOfPSInicijalno = reader.getValues();
		return listOfPSInicijalno;

	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		InitialTaskRunPLWS.applicationContext = context;

	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
