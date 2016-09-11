package rs.crhov.tijanap.jdbc;

import java.io.IOException;

/**
 * @author tijana.pavicic
 *
 */

import java.text.ParseException;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import rs.crhov.tijanap.soap.ArrayOfPrivredniSubjekat;


public interface EntitySOAPeDAO {

	public void insertListPromene(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) throws ParseException, NumberFormatException, IOException, DatatypeConfigurationException, Exception;

	public void insertListAll(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) throws NumberFormatException, DataAccessException, IOException, DatatypeConfigurationException;
	
	public void insertZaJMB(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate) throws NumberFormatException, DataAccessException, IOException, DatatypeConfigurationException;

}
