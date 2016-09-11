/**
 * 
 */
package rs.crhov.tijanap.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import rs.crhov.tijanap.service.EntitySOAPeDAOServiceImpl;
import rs.crhov.tijanap.soap.ArrayOfPrivredniSubjekat;
import rs.crhov.tijanap.soap.PlServicestub;

/**
 * @author tijana.pavicic
 *
 */
// @ContextConfiguration("/springTest.xml")
public class EntitySOAPeDAOeImplTest2 {
	private static ApplicationContext applicationContext = null;

	DataSource dataSourceTest = (DataSource) applicationContext.getBean("dataSourceTest");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("springTest.xml");

	}

	@Test
	public void testOne() {
		String str = "tijana";
		assertEquals("tijana", str);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		String str = "tijana testovi ok";
		assertEquals("tijana testovi ok", str);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#inserEntity(org.ttinana.dao.EntitySOAPI, org.springframework.jdbc.core.JdbcTemplate)}
	 * .
	 */
	@Test
	public final void testInserEntity() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#getListAll(org.springframework.jdbc.core.JdbcTemplate)}
	 * .
	 */
	@Test
	public final void testGetListAll() {
		PlServicestub plStub = new PlServicestub();

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceTest);
		EntitySOAPeDAOServiceImpl entitySOAPeDAOServiceImpl = (EntitySOAPeDAOServiceImpl) applicationContext
				.getBean("entitySOAPService");
		// ArrayOfPrivredniSubjekat listOfPS =
		// ScheduledTaskRunPLWS.sviPodaciOPrivrednimsubjektimaObj(plStub);
		ArrayOfPrivredniSubjekat psMB = null;
		/*
		 * for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) { String
		 * mb = ps.getMaticniBroj(); String tip = ps.getTip(); //psMB =
		 * ScheduledTaskRunPLWS.podaciZaMaticniBroj(mb, tip, plStub);
		 * entitySOAPeDAOServiceImpl.insertZaJMB(psMB, jdbcTemplate); }
		 */

	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#updateEntitySOAP(org.ttinana.dao.EntitySOAP)}
	 * .
	 */
	@Test
	public final void testUpdateEntitySOAP() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#deleteEntitySOAP(int, java.lang.String)}
	 * .
	 */
	@Test
	public final void testDeleteEntitySOAP() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#getElement(int, java.lang.String)}
	 * .
	 */
	@Test
	public final void testGetElementIntString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#getElement(org.ttinana.dao.EntitySOAP)}
	 * .
	 */
	@Test
	public final void testGetElementEntitySOAP() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#getUsersFromGroup(int)}
	 * .
	 */
	@Test
	public final void testGetUsersFromGroup() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#setList(org.ttinana.soap.ArrayOfPrivredniSubjekat, org.springframework.jdbc.core.JdbcTemplate)}
	 * .
	 */
	@Test
	public final void testSetList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#insertListPromene(org.ttinana.soap.ArrayOfPrivredniSubjekat, org.springframework.jdbc.core.JdbcTemplate)}
	 * .
	 */
	@Test
	public final void testInsertList7() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link org.ttinana.service.EntitySOAPeDAOServiceImpl#insertZaJMB(org.ttinana.soap.ArrayOfPrivredniSubjekat, org.springframework.jdbc.core.JdbcTemplate)}
	 * .
	 */
	@Test
	public final void testInsertZaJMB() {
		fail("Not yet implemented"); // TODO
	}

}
