/**
 * 
 */
package rs.crhov.tijanap.soap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.crhov.tijanap.main.HeaderHandlerResolver;
import rs.crhov.tijanap.main.ScheduledTaskRunPLWS;

/**
 * @author ttinana
 *
 */

public class PlServicestub {
	private PlService myClient = new PlService();
	static Logger logger = LoggerFactory.getLogger(ScheduledTaskRunPLWS.class);

	public ArrayOfPrivredniSubjekat preuzmiPromenePodatakaOPrivrednimSubjektima()
			throws DatatypeConfigurationException {

		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		myClient.setHandlerResolver(handlerResolver);
		// GregorianCalendar - MONTH field is 0-based. e.g
		// *** 0 for January **** 1 for February
		LocalDate today = LocalDate.now();
		Integer year = today.getYear();
		Integer month = today.getMonthValue();
		Integer day = today.getDayOfMonth();
		/* TODO SKINUTI FIKSNE DATUME ZA PRODUKCIJU */

		GregorianCalendar pocetak = new GregorianCalendar(year, month - 1, day - 1);
		// ovo je zapravo 5.Novembar tj 5.11.
		GregorianCalendar krajnji = new GregorianCalendar(year, month - 1, day);

		XMLGregorianCalendar pocetakXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(pocetak);
		XMLGregorianCalendar krajnjiXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(krajnji);

		PrivredniSubjektiPromenePoDatumu reqDates = new PrivredniSubjektiPromenePoDatumu();
		reqDates.datumOd = pocetakXML;
		reqDates.datumDo = krajnjiXML;

		ArrayOfPrivredniSubjekat listOfPS = myClient.getCustomBindingIPlService()
				.preuzmiPromenePodatakaOPrivrednimSubjektima(reqDates);

		return listOfPS;

	}

	/* *** *** *** *** ***/
	public ArrayOfPrivredniSubjekat podaciZaMaticniBroj(String mb, String tip, PlServicestub plStub) {

		ArrayOfPrivredniSubjekat psMBarray = null;
		PrivredniSubjekatMaticniBroj privredniSubjekatMaticniBroj = new PrivredniSubjekatMaticniBroj();
		privredniSubjekatMaticniBroj.setMaticniBroj(mb);
		privredniSubjekatMaticniBroj.setTip(tip);

		PrivredniSubjektiUlazniPodaci privredniSubjektiUlazniPodaci = new PrivredniSubjektiUlazniPodaci();
		privredniSubjektiUlazniPodaci.setPrivredniSubjekti(privredniSubjekatMaticniBroj);

		try {
			psMBarray = myClient.getCustomBindingIPlService()
					.preuzmiPodatkeOPrivrednomSubjektu(privredniSubjektiUlazniPodaci);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		return psMBarray;
	}

	public ArrayOfPrivredniSubjekat podaciZaMaticniBrojInit(String mb, String tip, PlServicestub plStub) {
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		try {
			myClient.setHandlerResolver(handlerResolver);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		ArrayOfPrivredniSubjekat psMBarray = null;
		PrivredniSubjekatMaticniBroj privredniSubjekatMaticniBroj = new PrivredniSubjekatMaticniBroj();
		privredniSubjekatMaticniBroj.setMaticniBroj("56976647");
		privredniSubjekatMaticniBroj.setTip("2");

		PrivredniSubjektiUlazniPodaci privredniSubjektiUlazniPodaci = new PrivredniSubjektiUlazniPodaci();
		privredniSubjektiUlazniPodaci.setPrivredniSubjekti(privredniSubjekatMaticniBroj);

		try {
			psMBarray = myClient.getCustomBindingIPlService()
					.preuzmiPodatkeOPrivrednomSubjektu(privredniSubjektiUlazniPodaci);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		return psMBarray;
	}

	/**********************************************************************************/

	public ArrayOfPrivredniSubjekat podaciZaMaticniBrojInitBK(String mb, String tip, PlServicestub plStub) {

		ArrayOfPrivredniSubjekat psMBarray = null;

		PrivredniSubjekatMaticniBroj privredniSubjekatMaticniBroj = new PrivredniSubjekatMaticniBroj();
		privredniSubjekatMaticniBroj.setMaticniBroj(mb);
		privredniSubjekatMaticniBroj.setTip(tip);
		privredniSubjekatMaticniBroj.getGp();

		PrivredniSubjektiUlazniPodaci req1 = new PrivredniSubjektiUlazniPodaci();
		req1.setPrivredniSubjekti(privredniSubjekatMaticniBroj);
		/*
		 * req1.privredniSubjekti = privredniSubjekatMaticniBroj;
		 * req1.privredniSubjekti.setTip(tip);
		 * req1.privredniSubjekti.setMaticniBroj(mb);
		 */
		try {
			psMBarray = myClient.getCustomBindingIPlService().preuzmiPodatkeOPrivrednomSubjektu(req1);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		return psMBarray;
	}

	/**********************************************************************************/
	public String sviPodaciOPrivrednimsubjektimaTest() throws DatatypeConfigurationException {

		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		try {
			myClient.setHandlerResolver(handlerResolver);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		// Date today = new Date();

		// GregorianCalendar
		// month - the value used to set the MONTH calendar field in the
		// calendar. Month value is 0-based. e.g.,
		// *** 0 for January ****

		LocalDate today = LocalDate.now();
		Integer year = today.getYear();
		Integer month = today.getMonthValue();
		Integer day = today.getDayOfMonth();

		/***********************************************/
		GregorianCalendar pocetak = new GregorianCalendar(2012, 10, 05);
		// ovo je zapravo 5. Novembar tj 5.11.
		GregorianCalendar krajnji = new GregorianCalendar(2012, 10, 06);
		// ovo je zapravo 6. Novembar tj 6.11.
		XMLGregorianCalendar pocetakXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(pocetak);
		XMLGregorianCalendar krajnjiXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(krajnji);

		PrivredniSubjektiPromenePoDatumu reqDates = new PrivredniSubjektiPromenePoDatumu();
		reqDates.datumOd = pocetakXML;
		reqDates.datumDo = krajnjiXML;

		/*
		 * ArrayOfPrivredniSubjekat listOfPS =
		 * myClient.getCustomBindingIPlService()
		 * .preuzmiPromenePodatakaOPrivrednimSubjektima(reqDates);
		 */

		return (" sviPodaciOPrivrednimsubjektimaTest method");

	}

	/* * SIFARNICICI */

	public Sifarnik sviPodaciODelatnostima() {

		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		try {
			myClient.setHandlerResolver(handlerResolver);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		myClient.getCustomBindingIPlService();
		Sifarnik p = myClient.getCustomBindingIPlService().sviPodaciODelatnostima();
		return p;
	}

	public Sifarnik sviPodaciODrzavama() {

		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		try {
			myClient.setHandlerResolver(handlerResolver);
		} catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
			javax.xml.soap.SOAPFault fault = soapFaultException.getFault(); // <Fault>
																			// node
			javax.xml.soap.Detail detail = fault.getDetail();

			logger.error("|ERROR|: SOAPFaultException. FAULT: " + fault.toString());
			logger.error("|ERROR|: SOAPFaultException. DETAIL: " + detail.toString());
		}

		QName s = myClient.getServiceName();
		String sa = s.getLocalPart();
		logger.debug(sa);
		Sifarnik p = myClient.getCustomBindingIPlService().sviPodaciODrzavama();
		return p;

	}

	public List<Zapis> sviPodaciODrzavamaObj() throws ParserConfigurationException {
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver();
		myClient.setHandlerResolver(handlerResolver);

		Sifarnik mySifarnik = myClient.getCustomBindingIPlService().sviPodaciODrzavama();

		Zapis zapis = new Zapis();
		List<Zapis> sifarnik = new ArrayList<Zapis>();

		for (Zapis obj : mySifarnik.getZapis()) {
			for (Podatak podatak : obj.getPodatak()) {
				Podatak prolaz = new Podatak();
				prolaz.setNaziv(podatak.getNaziv());
				prolaz.setVrednost(podatak.getVrednost());
				zapis.getPodatak().add(prolaz);

			}
			sifarnik.add(zapis);

		}
		return sifarnik;
	}
	/*
	 * @Override public void
	 * setApplicationEventPublisher(ApplicationEventPublisher publisher) {
	 * this.publisher=publisher;
	 * 
	 * }
	 */

}
