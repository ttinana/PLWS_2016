package rs.crhov.tijanap.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import rs.crhov.tijanap.main.InitialTaskRunPLWS;
import rs.crhov.tijanap.main.ScheduledTaskRunPLWS;
import rs.crhov.tijanap.service.EntitySOAPeDAOServiceImpl;
import rs.crhov.tijanap.soap.ArrayOfPrivredniSubjekat;
import rs.crhov.tijanap.soap.PlService;
import rs.crhov.tijanap.soap.PlServicestub;
import rs.crhov.tijanap.soap.PrivredniSubjekat;

/**
 * @author tijana.pavicic
 *
 */

public class ScheduledTaskRunPLWSTest {
	private static ApplicationContext applicationContext;
	static Logger logger = LoggerFactory.getLogger(ScheduledTaskRunPLWS.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("springTest.xml");

	}

	// @Test
	public void runClientside() throws IOException, DatatypeConfigurationException {

		PlServicestub plStub = new PlServicestub();
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
		EntitySOAPeDAOServiceImpl entitySOAPeDAOServiceImpl = (EntitySOAPeDAOServiceImpl) applicationContext
				.getBean("entitySOAPService");

		// ovde pozivam prvu funkciju
		ArrayOfPrivredniSubjekat listOfPS = preuzmiPromenePodatakaOPrivrednimSubjektima(plStub);

		try {
			// ovde insertujem u promene
			entitySOAPeDAOServiceImpl.insertListPromene(listOfPS, jdbcTemplate);
			// ovde pozivamo drugu funkciju
			ArrayOfPrivredniSubjekat psMBarray = null;
			for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) {
				String mb = ps.getMaticniBroj();
				String tip = ps.getTip();
				psMBarray = podaciZaMaticniBroj(mb, tip, plStub);
				entitySOAPeDAOServiceImpl.insertZaJMB(psMBarray, jdbcTemplate);
			}

		} catch (ParseException e) {
		}
	}

	@Test
	public void runClientsideInit() throws IOException, DatatypeConfigurationException {

		PlServicestub plStub = new PlServicestub();
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
		EntitySOAPeDAOServiceImpl entitySOAPeDAOServiceImpl = (EntitySOAPeDAOServiceImpl) applicationContext
				.getBean("entitySOAPService");

		// ovde pozivamo prvu funkciju
		ArrayOfPrivredniSubjekat listOfPS = preuzmiPromenePodatakaOPrivrednimSubjektima(plStub);
		// uzimamo podatke iz excella
		InitialTaskRunPLWS initialTaskRunPLWS = new InitialTaskRunPLWS();
		ArrayList<PrivredniSubjekat> listOfPScsv = (ArrayList<PrivredniSubjekat>) InitialTaskRunPLWS
				.runInitiallyCSV(applicationContext);
		// listi koja je rezultat poziva prve funkcije servisa dodajem listu iz
		// excella
		listOfPS.getPrivredniSubjekat().addAll(listOfPScsv);
		// problem je sto nemam dodati security header za te elemente jer nisu
		// vraceni kao rezultat prve funkcije vec su dodati na klijentskoj
		// strani
		// dakle pri stampi vidimo da lista zaista ima sve dodate elemente u
		// sebi ali i da oni nemaju property hashovan na serverskoj strani koji
		// imaju el iz prvog poziva
		System.out.println(listOfPS.getPrivredniSubjekat().size());
		for (PrivredniSubjekat p : listOfPS.getPrivredniSubjekat()) {
			System.out.println("1: " + p.getMaticniBroj() + " " + p.getTip() + " class: " + p.getClass() + " grupa "
					+ p.getGrupa() + " .");

		}

		for (PrivredniSubjekat p : listOfPScsv) {
			// System.out.println("2: "+p.getMaticniBroj() +" " +p.getTip() +"
			// class: " +p.getClass() + " grupa " + p.getGrupa());
		}

		try {
			// ovde insertujemo u promene
			entitySOAPeDAOServiceImpl.insertListPromene(listOfPS, jdbcTemplate);
			logger.info(" |INFO| Insertovano u tabelu Promene je uspešno izvršen. ");
			// ovde preuzimamo podatke za svaki element iz liste koju je vratila
			// prva funkcija
			ArrayOfPrivredniSubjekat psMBarray = null;
			for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) {
				String mb = ps.getMaticniBroj();
				String tip = ps.getTip();
				psMBarray = podaciZaMaticniBroj(mb, tip, plStub);
				entitySOAPeDAOServiceImpl.insertZaJMB(psMBarray, jdbcTemplate);
			}

		} catch (ParseException e) {
			logger.error(" |ERROR| Podaci nisu insertovani u bazu. " + e);
		}
		assertEquals(listOfPS.getPrivredniSubjekat(), listOfPScsv);
	}

	private void runClientsideInitBK(ApplicationContext applicationContext)
			throws IOException, DatatypeConfigurationException {

		PlServicestub plStub = new PlServicestub();
		JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
		EntitySOAPeDAOServiceImpl entitySOAPeDAOServiceImpl = (EntitySOAPeDAOServiceImpl) applicationContext
				.getBean("entitySOAPService");

		// ovde pozivamo prvu funkciju
		ArrayOfPrivredniSubjekat listOfPS = preuzmiPromenePodatakaOPrivrednimSubjektima(plStub);
		// uzimamo podatke iz excella
		InitialTaskRunPLWS initialTaskRunPLWS = new InitialTaskRunPLWS();
		List<PrivredniSubjekat> listOfPScsv = initialTaskRunPLWS.runInitiallyCSV(applicationContext);
		// listi koja je rezultat poziva prve funkcije servisa dodajem listu iz
		// excella
		listOfPS.getPrivredniSubjekat().addAll(listOfPScsv);
		// problem je sto nemam dodati security header za te elemente jer nisu
		// vraceni kao rezultat prve funkcije vec su dodati na klijentskoj
		// strani
		// dakle pri stampi vidimo da lista zaista ima sve dodate elemente u
		// sebi ali i da oni nemaju property hashovan na serverskoj strani koji
		// imaju el iz prvog poziva
		System.out.println(listOfPS.getPrivredniSubjekat().size());
		for (PrivredniSubjekat p : listOfPS.getPrivredniSubjekat()) {
			System.out.println("1: " + p.getMaticniBroj() + " " + p.getTip() + " class: " + p.getClass() + " grupa "
					+ p.getGrupa());
		}

		for (PrivredniSubjekat p : listOfPScsv) {
			// System.out.println("2: "+p.getMaticniBroj() +" " +p.getTip() +"
			// class: " +p.getClass() + " grupa " + p.getGrupa());
		}

		try {
			// ovde insertujemo u promene
			entitySOAPeDAOServiceImpl.insertListPromene(listOfPS, jdbcTemplate);
			logger.info(" |INFO| Insertovano u tabelu Promene je uspešno izvršen. ");
			// ovde preuzimamo podatke za svaki element iz liste koju je vratila
			// prva funkcija
			ArrayOfPrivredniSubjekat psMBarray = null;
			for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) {
				String mb = ps.getMaticniBroj();
				String tip = ps.getTip();
				psMBarray = podaciZaMaticniBroj(mb, tip, plStub);
				entitySOAPeDAOServiceImpl.insertZaJMB(psMBarray, jdbcTemplate);
			}

		} catch (ParseException e) {
			logger.error(" |ERROR| Podaci nisu insertovani u bazu. " + e);
		}

	}

	public static ArrayOfPrivredniSubjekat podaciZaMaticniBroj(String mb, String tip, PlServicestub plStub) {
		ArrayOfPrivredniSubjekat psMBarray;
		psMBarray = plStub.podaciZaMaticniBroj(mb, tip, plStub);
		return psMBarray;
	}

	public void runClientsideARH(ApplicationContext applicationContext) {
		JdbcTemplate jdbcTemplate = getApplicationContext().getBean("jdbcTemplate", JdbcTemplate.class);
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("AprCRHV").withSchemaName("dbo")
				.withProcedureName("DnevnaObradaImportovanih").withoutProcedureColumnMetaDataAccess();
		jdbcCall.execute();
	}

	public static ArrayOfPrivredniSubjekat preuzmiPromenePodatakaOPrivrednimSubjektima(PlServicestub plStub) {
		ArrayOfPrivredniSubjekat listOfPS;
		try {
			listOfPS = plStub.preuzmiPromenePodatakaOPrivrednimSubjektima();
		} catch (DatatypeConfigurationException e) {
			listOfPS = null;
			logger.error(" |ERROR| Exception in sviPodaciOPrivrednimsubjektimaObj: " + e);
		}
		return listOfPS;
	}

	public static void endingClient() {
		((AbstractApplicationContext) getApplicationContext()).registerShutdownHook();
		logger.info(" |INFO| Finishing client PLWS by Tijana.");
		System.out.println(" |INFO| Finishing client PLWS by Tijana.");
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}