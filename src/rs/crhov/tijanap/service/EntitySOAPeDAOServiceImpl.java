package rs.crhov.tijanap.service;

import java.io.IOException;

/**
 * @author tijana.pavicic
 *
 */

import java.text.ParseException;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import rs.crhov.tijanap.jdbc.EntitySOAPeDAO;
import rs.crhov.tijanap.main.App2016;
import rs.crhov.tijanap.soap.ArrayOfPrivredniSubjekat;

public class EntitySOAPeDAOServiceImpl implements EntitySOAPeDAOService {

	@Autowired
	private EntitySOAPeDAO element;

	static Logger logger = LoggerFactory.getLogger(EntitySOAPeDAOServiceImpl.class);

	@Override
	public void insertListPromene(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) throws ParseException {

		try {
			element.insertListPromene(listOfPS, jdbcTemplate);
		} catch (NumberFormatException e) {
			logger.error(e.toString());
		} catch (IOException e) {
			logger.error(e.toString());
		} catch (DatatypeConfigurationException e) {
			logger.error(e.toString());
		} catch (Exception e) {
			logger.error(e.toString());
		}

	}

	@Override
	public void insertListAll(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) {
		try {
			element.insertListAll(listOfPS, jdbcTemplate);
		} catch (NumberFormatException | DataAccessException | IOException | DatatypeConfigurationException e) {
			logger.error(e.toString());
		}
	}

	@Override
	public void insertZaJMB(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) {
		try {
			element.insertZaJMB(listOfPS, jdbcTemplate);
		} catch (NumberFormatException | DataAccessException | IOException | DatatypeConfigurationException e) {
			logger.error(e.toString());
		}

	}

}
