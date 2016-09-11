
package rs.crhov.tijanap.jdbc;

import java.io.IOException;

/**
 * @author tijana.pavicic
 *
 */

import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import rs.crhov.tijanap.soap.ArrayOfPrivredniSubjekat;
import rs.crhov.tijanap.soap.Grupa;
import rs.crhov.tijanap.soap.Podatak;
import rs.crhov.tijanap.soap.PrivredniSubjekat;

public class EntitySOAPeDAOeImplMySQL implements EntitySOAPeDAO {
	static Logger logger = LoggerFactory.getLogger(EntitySOAPeDAOeImpl.class);

	public EntitySOAPeDAOeImplMySQL() {
	}

	@Override
	public void insertListPromene(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate)
			throws NumberFormatException, IOException, DatatypeConfigurationException, Exception {

		java.util.Date utilDate = new java.util.Date();
		String mB;
		int myGrupa;
		for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) {
			mB = ps.getMaticniBroj();

			for (Grupa grupa : ps.getGrupa()) {
				myGrupa = castToInt(grupa.getId());
				String datumPromene = "";
				String identifikatornacinapromene = "";
				int identifikatortiparegistracionogpostupka = 0;
				String tipPrivrednogSubjekta = "";
				for (Podatak podatak : grupa.getPodatak()) {

					if (podatak.getNaziv().equalsIgnoreCase("DatumPromene")) {
						datumPromene = podatak.getVrednost();
						// Date datumPromeneF =
						// parseStringToDateM(datumPromene);
						// System.out.println(datumPromene);
					}

					if (podatak.getNaziv().equalsIgnoreCase("Identifikatornacinapromene")) {
						identifikatornacinapromene = podatak.getVrednost().toString();
					}

					if (podatak.getNaziv().equalsIgnoreCase("Identifikatortiparegistracionogpostupka")) {
						identifikatortiparegistracionogpostupka = castToInt(podatak.getVrednost());

					}

					if (podatak.getNaziv().equalsIgnoreCase("TipPrivrednogSubjekta")) {
						tipPrivrednogSubjekta = (String) podatak.getVrednost().toString();
											}
				}

				String sql = "insert into Promene (MaticniBroj, GrupaID, DatumPromene, Identifikatornacinapromene, "
						+ "Identifikatortiparegistracionogpostupka, TipPrivrednogSubjekta, DatumPustanja) VALUES (?, ?, ?, ?, ?, ?, ?)";

				try {
					jdbcTemplate.update(sql,
							new Object[] { mB, myGrupa, new java.sql.Date(utilDate.getTime()),
									castToInt(identifikatornacinapromene),
									identifikatortiparegistracionogpostupka, tipPrivrednogSubjekta,
									new java.sql.Date(utilDate.getTime()) },
							new int[] { Types.NVARCHAR, Types.INTEGER, Types.DATE, Types.INTEGER, Types.INTEGER,
									Types.NVARCHAR, Types.DATE });
					logger.debug(" |DEBUG| Insert into from dbo.Promene. ");
				} catch (Exception e) {
					logger.error(" |ERROR| Greska pri unosu u tabelu Promene. Klasa EntitySOAPeDAOeImpl. " + e);
					throw e;
				} finally {
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. ");
				}

			}
		}

	}

	/**
	 * Gets the java.util.Date from String in format "yyyy-MM-dd".
	 * 
	 * @param dateString
	 * @return Date
	 */

	public static Date parseStringToDateY(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = dateString;
		Date date = null;

		try {

			date = formatter.parse(dateInString);
			// System.out.println(date);
			// System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * Gets the java.util.Date from String in format "MM/dd/yyyy HH:mm:ss a".
	 * 
	 * @param dateString
	 * @return Date
	 */
	public static Date parseStringToDateM(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		String dateInString = dateString;
		Date date = null;

		try {

			date = formatter.parse(dateInString);
			// System.out.println(date);
			// System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * Gets the java.util.Date from String in format "dd-MM-yyyy".
	 * 
	 * @param dateString
	 * @return Date
	 */

	public static Date parseStringToDateD(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = dateString;
		Date date = null;

		try {

			date = formatter.parse(dateInString);
			// System.out.println(date);
			// System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * Gets the java.sql.Date from String in format "MM/dd/yyy HH:mm:ss".
	 */
	public static java.sql.Date convertDateForDBT(String dateString) throws ParseException {

		int cela = dateString.length();
		String strSub = dateString.substring(0, cela - 3);
		java.util.Date temp = new SimpleDateFormat("MM/dd/yyy HH:mm:ss").parse(strSub);
		java.sql.Date sqlDat = new java.sql.Date(temp.getTime());
		logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Method convertDateForDBT. ");
		return sqlDat;
	}

	@Override
	public void insertZaJMB(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate)
			throws NumberFormatException, DataAccessException, IOException, DatatypeConfigurationException {

		insertListAll(listOfPS, jdbcTemplate);
		// insertListAll108(listOfPS, jdbcTemplate);
	}

	/* metode koje NISU NASLEDJENE */
	public void insertListAll(ArrayOfPrivredniSubjekat listOfPS, JdbcTemplate jdbcTemplate)
			throws NumberFormatException, DataAccessException, IOException, DatatypeConfigurationException {

		for (PrivredniSubjekat ps : listOfPS.getPrivredniSubjekat()) {
			String mb = ps.getMaticniBroj();
			for (Grupa grupa : ps.getGrupa()) {
				int myGrupa = castToInt(grupa.getId());
				/*****************************************************************/
				if (myGrupa == 1010) {
					long identifikatorMesta = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						/*
						 * if (podatak.getNaziv().equalsIgnoreCase(
						 * "IdentifikatorMesta")) {
						 */
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							identifikatorMesta = castToInt(podatak.getVrednost());
						} else {
							logger.warn(" |WARNING| identifikatorStatusa nije poslat za 1010");
						}
						/* } */

						String sql = "insert into  Grupa_1010t (IdentifikatorGrupe, MaticniBroj, IdentifikatorMesta) VALUES (?, ?, ?)";
						jdbcTemplate.update(sql, new Object[] { myGrupa, mb, identifikatorMesta },
								new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
					}
				}
				/****************************** 1001 ***************************/
				if (myGrupa == 1001) {
					String sql = "insert into  Grupa_1001t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, ps.getMaticniBroj() },
							new int[] { Types.INTEGER, Types.NVARCHAR });
				}
				/******************************** 1002 ****************************/
				if (myGrupa == 1002) {
					long identifikatorstatusa = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							identifikatorstatusa = castToInt(podatak.getVrednost());
						} else {
							logger.warn(" |WARNING| identifikatorStatusa nije poslat za 1002");
						}

						String sql = "insert into  Grupa_1002t (IdentifikatorGrupe, MaticniBroj, Identifikatorstatusa) VALUES (?, ?, ?)";
						jdbcTemplate.update(sql, new Object[] { myGrupa, mb, identifikatorstatusa },
								new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
					}
				}
				/********************************* 1004 ******************************************/
				if (myGrupa == 1004) {
					long identifikatorParam = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							identifikatorParam = castToInt(podatak.getVrednost());
						} else {
							logger.warn(" |WARNING| identifikatorPF nije poslat za 1004");
						}

						String sql = "insert into  Grupa_1004t (IdentifikatorGrupe, MaticniBroj, IdentifikatorPravneForme) VALUES (?, ?, ?)";
						jdbcTemplate.update(sql, new Object[] { myGrupa, mb, identifikatorParam },
								new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
					}
				}
				/******************************* 1006 ***************************************/
				if (myGrupa == 1006) {
					String skracenoPoslovnoIme = "";
					String skracenoPoslovnoImeLatinica = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoIme") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							skracenoPoslovnoIme = podatak.getVrednost();
						}

						if (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoImeLatinica")
								&& podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							skracenoPoslovnoImeLatinica = podatak.getVrednost();
						}
					}
					String sql = "insert into  Grupa_1006t (IdentifikatorGrupe, MaticniBroj, SkracenoPoslovnoIme, SkracenoPoslovnoImeLatinica ) VALUES (?, ?, ?, ?)";
					jdbcTemplate.update(sql,
							new Object[] { myGrupa, mb, skracenoPoslovnoIme, skracenoPoslovnoImeLatinica },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR });
				}

				/********************************* 1007 ******************************************/
				/*
				 * na mysql-u nisam kreirala tabele pa komentaisem kod za
				 * nekreirane...
				 */

				/*
				 * if (myGrupa == 1007) { String Naziv = ""; String
				 * NazivLatinica = ""; for (Podatak podatak :
				 * grupa.getPodatak()) { if
				 * (podatak.getNaziv().equalsIgnoreCase("Naziv") &&
				 * podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { Naziv =
				 * podatak.getVrednost(); }
				 * 
				 * if (podatak.getNaziv().equalsIgnoreCase("NazivLatinica") &&
				 * podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { NazivLatinica =
				 * podatak.getVrednost(); } } String sql =
				 * "insert into  Grupa_1007t (IdentifikatorGrupe, MaticniBroj, Naziv, NazivLatinica ) VALUES (?, ?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb, Naziv,
				 * NazivLatinica }, new int[] { Types.INTEGER, Types.NVARCHAR,
				 * Types.NVARCHAR, Types.NVARCHAR }); }
				 */
				/********************************* 1011 ********************************************************/
				if (myGrupa == 1011) {
					String KodUlice = "";
					String NazivUlice = "";
					String NazivUliceLatinica = "";
					String AdresaBroj = "";
					String AdresaSprat = "";
					String AdresaBrojStana = "";
					String AdresaSlovo = "";
					String DodatniPodaciAdrese = "";
					String DodatniPodaciAdreseLatinica = "";
					String PostanskiBroj = "";
					String NazivPoste = "";
					String PostanskiAdresniKod = "";
					int IdentifikatorMesta = 0;

					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getNaziv().equalsIgnoreCase("KodUlice") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							KodUlice = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("NazivUlice") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							NazivUlice = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("NazivUliceLatinica") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							NazivUliceLatinica = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("AdresaBroj") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							AdresaBroj = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("AdresaSprat") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							AdresaSprat = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("AdresaBrojStana") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							AdresaBrojStana = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("AdresaSlovo") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							AdresaSlovo = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("DodatniPodaciAdrese") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							DodatniPodaciAdrese = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("DodatniPodaciAdreseLatinica")
								&& podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							DodatniPodaciAdreseLatinica = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("PostanskiBroj") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							PostanskiBroj = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("NazivPoste") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							NazivPoste = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("PostanskiAdresniKod") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							PostanskiAdresniKod = podatak.getVrednost();
						}
						if (podatak.getNaziv().equalsIgnoreCase("IdentifikatorMesta")) {
							IdentifikatorMesta = castToInt(podatak.getVrednost());
						}
					}
					String sql = "insert into  Grupa_1011t (IdentifikatorGrupe, MaticniBroj, KodUlice, NazivUlice, NazivUliceLatinica, AdresaBroj, AdresaSprat, AdresaBrojStana, AdresaSlovo,DodatniPodaciAdrese, DodatniPodaciAdreseLatinica, PostanskiBroj, NazivPoste, PostanskiAdresniKod,IdentifikatorMesta  ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
					jdbcTemplate.update(sql,
							new Object[] { myGrupa, mb, KodUlice, NazivUlice, NazivUliceLatinica, AdresaBroj,
									AdresaSprat, AdresaBrojStana, AdresaSlovo, DodatniPodaciAdrese,
									DodatniPodaciAdreseLatinica, PostanskiBroj, NazivPoste, PostanskiAdresniKod,
									IdentifikatorMesta },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR,
									Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR,
									Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR, Types.INTEGER });
				}

				/***************************** 1017 ***************************************************/
				if (myGrupa == 1017) {
					String pib = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							pib = podatak.getVrednost();
						} else {
							logger.error(" |ERROR| isostavljen pib u 1017");
						}
					}
					String sql = "insert into  Grupa_1017t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, mb, pib },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1017. ");

				/********************************** 102 ****************************************************/

				/*
				 * if (myGrupa == 102) { String PunNaziv = ""; String
				 * PunNazivLatinica = ""; for (Podatak podatak :
				 * grupa.getPodatak()) { if
				 * (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoIme")
				 * && podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { PunNaziv =
				 * podatak.getVrednost(); }
				 * 
				 * if (podatak.getNaziv().equalsIgnoreCase(
				 * "SkracenoPoslovnoImeLatinica") && podatak.getVrednost() !=
				 * null && !podatak.getVrednost().isEmpty()) { PunNazivLatinica
				 * = podatak.getVrednost(); } } String sql =
				 * "insert into  Grupa_102t (IdentifikatorGrupe, MaticniBroj, PunNaziv, PunNazivLatinica ) VALUES (?, ?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb,
				 * PunNaziv, PunNazivLatinica }, new int[] { Types.INTEGER,
				 * Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR }); }
				 * logger.debug(
				 * " |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_102. "
				 * );
				 */

				/**************************** 103 *******************************************/
				if (myGrupa == 103) {
					String skracenoPoslovnoIme = "";
					String skracenoPoslovnoImeLatinica = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoIme") && podatak.getVrednost() != null
								&& !podatak.getVrednost().isEmpty()) {
							skracenoPoslovnoIme = podatak.getVrednost();
						}

						if (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoImeLatinica")
								&& podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							skracenoPoslovnoImeLatinica = podatak.getVrednost();
						}
					}
					String sql = "insert into  Grupa_103t (IdentifikatorGrupe, MaticniBroj, SkracenoPoslovnoIme, SkracenoPoslovnoImeLatinica ) VALUES (?, ?, ?, ?)";
					jdbcTemplate.update(sql,
							new Object[] { myGrupa, mb, skracenoPoslovnoIme, skracenoPoslovnoImeLatinica },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR });
				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_103. ");
				/************************************** 1041 **********************************************/
				if (myGrupa == 1041) {
					String sql = "insert into  Grupa_1041t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, ps.getMaticniBroj() },
							new int[] { Types.INTEGER, Types.NVARCHAR });
				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1041. ");
				/************************************** 1042 *******************************************************/
				if (myGrupa == 1042) {
					long identifikatorstatusa = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							identifikatorstatusa = castToInt(podatak.getVrednost());
						} else {
							logger.error(" |ERROR| identifikator statusa u 1042 je izostavljen");
						}
					}
					String sql = "insert into  Grupa_1042t (IdentifikatorGrupe, MaticniBroj, IdentifikatorStatusa) VALUES (?, ?, ?)";

					jdbcTemplate.update(sql, new Object[] { myGrupa, mb, identifikatorstatusa },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });

				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1042. ");
				/****************************** 1044 ************************************************/
				if (myGrupa == 1044) {
					Boolean preduzetnickaRadnjaJeOrtacka = false;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							preduzetnickaRadnjaJeOrtacka = Boolean.valueOf(podatak.getVrednost());
						}
					}
					String sql = "insert into  Grupa_1044t (IdentifikatorGrupe, MaticniBroj, PreduzetnickaRadnjaJeOrtacka) VALUES (?, ?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, mb, preduzetnickaRadnjaJeOrtacka },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIT });
				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1044. ");
				/********************************** 1045 ****************************************************/
				/*
				 * if (myGrupa == 1045) { String PoslovnoIme = ""; String
				 * PoslovnoImeLatinica = ""; for (Podatak podatak :
				 * grupa.getPodatak()) { if
				 * (podatak.getNaziv().equalsIgnoreCase("PoslovnoIme") &&
				 * podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { PoslovnoIme =
				 * podatak.getVrednost(); }
				 * 
				 * if
				 * (podatak.getNaziv().equalsIgnoreCase("PoslovnoImeLatinica")
				 * && podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { PoslovnoImeLatinica =
				 * podatak.getVrednost(); } } String sql =
				 * "insert into  Grupa_1045t (IdentifikatorGrupe, MaticniBroj, PoslovnoIme, PoslovnoImeLatinica ) VALUES (?, ?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb,
				 * PoslovnoIme, PoslovnoImeLatinica }, new int[] {
				 * Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR, Types.NVARCHAR
				 * }); } logger.debug(
				 * " |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1045. "
				 * );
				 */
				/********************************** 1046 ****************************************************/
				/*
				 * if (myGrupa == 1046) { String skracenoPoslovnoIme = "";
				 * String skracenoPoslovnoImeLatinica = ""; for (Podatak podatak
				 * : grupa.getPodatak()) { if
				 * (podatak.getNaziv().equalsIgnoreCase("SkracenoPoslovnoIme")
				 * && podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { skracenoPoslovnoIme =
				 * podatak.getVrednost(); }
				 * 
				 * if (podatak.getNaziv().equalsIgnoreCase(
				 * "SkracenoPoslovnoImeLatinica") && podatak.getVrednost() !=
				 * null && !podatak.getVrednost().isEmpty()) {
				 * skracenoPoslovnoImeLatinica = podatak.getVrednost(); } }
				 * String sql =
				 * "insert into  Grupa_1046t (IdentifikatorGrupe, MaticniBroj, SkracenoPoslovnoIme, SkracenoPoslovnoImeLatinica ) VALUES (?, ?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb,
				 * skracenoPoslovnoIme, skracenoPoslovnoImeLatinica }, new int[]
				 * { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR,
				 * Types.NVARCHAR }); }
				 */
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1046. ");
				/********************************** 1058 ****************************************************/
				if (myGrupa == 1058) {
					String preduzetnickaRadnjaJeOrtacka = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							preduzetnickaRadnjaJeOrtacka = podatak.getVrednost();
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_1058 ne moze da importuje prazan PIB. Kontaktirajte APR.");
						}
					}
					String sql = "insert into  Grupa_1058t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, mb, preduzetnickaRadnjaJeOrtacka },
							new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
				}
				logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1058. ");
				/********************************** 1068 ****************************************************/
				if (myGrupa == 1068) {
					long identifikatorVrsteOblikaOrganizovanja = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						identifikatorVrsteOblikaOrganizovanja = castToInt(podatak.getVrednost());

						String sql = "insert into  Grupa_1068t (IdentifikatorGrupe, MaticniBroj, IdentifikatorVrsteOblikaOrganizovanja) VALUES (?, ?, ?)";
						jdbcTemplate.update(sql, new Object[] { myGrupa, mb, identifikatorVrsteOblikaOrganizovanja },
								new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
					}
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1068. ");
				}

				/********************************** 1076 ****************************************************/
				if (myGrupa == 1076) {
					String sql = "insert into  Grupa_1076t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, mb }, new int[] { Types.INTEGER, Types.NVARCHAR });
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1076. ");
				}

				/**********************************    ****************************************************/
				if (myGrupa == 1077) {
					String PIB = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							PIB = podatak.getVrednost();
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_1077 ne moze da importuje prazan PIB. Kontaktirajte APR.");
						}

						String sql = "insert into  Grupa_1077t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)";
						jdbcTemplate.update(sql, new Object[] { myGrupa, mb, PIB },
								new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });

					}
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_1077. ");
				}

				/********************************** 108 ****************************************************/
				if (myGrupa == 108) {
					String sql = "insert into  Grupa_108t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, mb }, new int[] { Types.INTEGER, Types.NVARCHAR });
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_108. ");
				}

				/********************************** 109 ****************************************************/

				if (myGrupa == 109) {
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							String PIB = podatak.getVrednost();

							String sql = "insert into  Grupa_109t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, PIB },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_109 ne moze da importuje prazan PIB. Kontaktirajte APR.");
						}

					}

					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_109. ");
				}

				/**********************************    ****************************************************/
				if (myGrupa == 110) {
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							long identifikatorVrsteOblikaOrganizovanja = castToInt(podatak.getVrednost());

							String sql = "insert into  Grupa_110t (IdentifikatorGrupe, MaticniBroj, IdentifikatorVrsteOblikaOrganizovanja) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql,
									new Object[] { myGrupa, mb, identifikatorVrsteOblikaOrganizovanja },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
						} else {

							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_110 ne moze da importuje prazan IdentifikatorVrsteOblikaOrganizovanja. Kontaktirajte APR.");
						}
					}
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_110. ");
				}

				/********************************** 111 ****************************************************/

				if (myGrupa == 111) {
					// long IdentifikatorStatusa = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							long IdentifikatorStatusa =castToInt(podatak.getVrednost());

							String sql = "insert into  Grupa_111t (IdentifikatorGrupe, MaticniBroj, IdentifikatorStatusa) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, IdentifikatorStatusa },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_111 ne moze da importuje prazan IdentifikatorStatusa. Kontaktirajte APR.");
						}
					}
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_111. ");
				}

				/********************************** 2001 ****************************************************/
				if (myGrupa == 2001) {
					String sql = "insert into  Grupa_2001t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)";
					jdbcTemplate.update(sql, new Object[] { myGrupa, ps.getMaticniBroj() },
							new int[] { Types.INTEGER, Types.NVARCHAR });
				}
				/********************************** 2002 ****************************************************/
				if (myGrupa == 2002) {
					// long IdentifikatorStatusa = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							long IdentifikatorStatusa = castToInt(podatak.getVrednost());

							String sql = "insert into  Grupa_2002t (IdentifikatorGrupe, MaticniBroj, IdentifikatorStatusa) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, IdentifikatorStatusa },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
						} else {
							logger.error(
									" |ERROR| Klasa EntitySOAPeDAOeImpl.  Grupa_2002 ne moze da importuje prazan IdentifikatorStatusa. Kontaktirajte APR.");
						}
					}
					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_2002. ");
				}

				/********************************** 2003 ****************************************************/
				if (myGrupa == 2003) {
					// if (grupa.getId().equals("2003")) {
					System.out.println(myGrupa);
					// String PIB = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							String PIB = podatak.getVrednost();

							String sql = "insert into  Grupa_2003t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, PIB },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_2003 ne moze da importuje prazan PIB. Kontaktirajte APR.");
						}

					}

					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_2003. ");
				}

				/********************************** 2004 ****************************************************/
				if (myGrupa == 2004) {

					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							String PoslovnoIme = podatak.getVrednost();

							String sql = "insert into  Grupa_2004t (IdentifikatorGrupe, MaticniBroj, PoslovnoIme) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, PoslovnoIme },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_2004 ne moze da importuje prazan PIB. Kontaktirajte APR.");
						}

					}

					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_2004. ");
				}

				/********************************** 2005 ****************************************************/
				if (myGrupa == 2005) {
					// if (grupa.getId().equals("2005")) {
					System.out.println(myGrupa);
					// String PIB = "";
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							String SkraceniNaziv = podatak.getVrednost();

							String sql = "insert into Grupa_2005t (IdentifikatorGrupe, MaticniBroj, SkraceniNaziv) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql, new Object[] { myGrupa, mb, SkraceniNaziv },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_2005 ne moze da importuje prazan skracen naziv. Kontaktirajte APR.");
						}

					}

					logger.debug(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_2005. ");
				}

				/********************************** 2014 ****************************************************/
				if (myGrupa == 2014) {
					// long IdentifikatorStatusa = 0;
					for (Podatak podatak : grupa.getPodatak()) {
						if (podatak.getVrednost() != null && !podatak.getVrednost().isEmpty()) {
							long IdentifikatorVrsteOblikaOrganizovanja = castToInt(podatak.getVrednost());

							String sql = "insert into  Grupa_2014t (IdentifikatorGrupe, MaticniBroj, IdentifikatorVrsteOblikaOrganizovanja) VALUES (?, ?, ?)";
							jdbcTemplate.update(sql,
									new Object[] { myGrupa, mb, IdentifikatorVrsteOblikaOrganizovanja },
									new int[] { Types.INTEGER, Types.NVARCHAR, Types.BIGINT });
						} else {
							logger.warn(
									" |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_2014 ne moze da importuje prazan IdentifikatorVrsteOblikaOrganizovanja. Kontaktirajte APR.");
						}
					}
					logger.info(" |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_2014. ");
				}

				/********************************** 49 ****************************************************/
				/*
				 * if (myGrupa == 49) { String naziv = ""; for (Podatak podatak
				 * : grupa.getPodatak()) {
				 * 
				 * if (podatak.getNaziv().equalsIgnoreCase(
				 * "IdentifikatorMesta")) {
				 * 
				 * if (podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { naziv =
				 * podatak.getVrednost(); } else { logger.warn(
				 * " |WARNING| naziv nije poslat za 49"); } }
				 * 
				 * String sql =
				 * "insert into  Grupa_49t (IdentifikatorGrupe, MaticniBroj, Naziv) VALUES (?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb, naziv
				 * }, new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR
				 * }); } }
				 */
				/********************************** 50 ****************************************************/
				/*
				 * if (myGrupa == 50) { String SkracenoPoslovnoIme = ""; for
				 * (Podatak podatak : grupa.getPodatak()) {
				 * 
				 * if (podatak.getNaziv().equalsIgnoreCase(
				 * "IdentifikatorMesta")) {
				 * 
				 * if (podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { SkracenoPoslovnoIme =
				 * podatak.getVrednost(); } else { logger.warn(
				 * " |WARNING| naziv nije poslat za 50"); } }
				 * 
				 * String sql =
				 * "insert into  Grupa_50t (IdentifikatorGrupe, MaticniBroj, SkracenoPoslovnoIme) VALUES (?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb,
				 * SkracenoPoslovnoIme }, new int[] { Types.INTEGER,
				 * Types.NVARCHAR, Types.NVARCHAR }); } }
				 */
				/**********************************    ****************************************************/
				/*
				 * if (myGrupa == 55) { String sql =
				 * "insert into  Grupa_55t (IdentifikatorGrupe, MaticniBroj) VALUES (?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa,
				 * ps.getMaticniBroj() }, new int[] { Types.INTEGER,
				 * Types.NVARCHAR }); }
				 */
				/**********************************    ****************************************************/
				/*
				 * if (myGrupa == 56) { String PIB = ""; for (Podatak podatak :
				 * grupa.getPodatak()) { if (podatak.getVrednost() != null &&
				 * !podatak.getVrednost().isEmpty()) { PIB =
				 * podatak.getVrednost(); } else { logger.warn(
				 * " |WARN| Klasa EntitySOAPeDAOeImpl.  Grupa_56 ne moze da importuje prazan PIB. Kontaktirajte APR."
				 * ); }
				 * 
				 * String sql =
				 * "insert into  Grupa_56t (IdentifikatorGrupe, MaticniBroj, PIB) VALUES (?, ?, ?)"
				 * ; jdbcTemplate.update(sql, new Object[] { myGrupa, mb, PIB },
				 * new int[] { Types.INTEGER, Types.NVARCHAR, Types.NVARCHAR });
				 * 
				 * } logger.debug(
				 * " |DEBUG| Klasa EntitySOAPeDAOeImpl. Insert into  Grupa_56. "
				 * ); }
				 */
				/**********************************    ****************************************************/

			}
		}
		// logger.info(" |INFO| Klasa EntitySOAPeDAOeImpl. 1001 - 1076
		// executed**********************. ");
	}

	public static int castToInt(String vrednostPodatka) {
		int vrednostInt = 0;
		try {
			vrednostInt = Integer.parseInt(vrednostPodatka);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}
		return vrednostInt;
	}

}
