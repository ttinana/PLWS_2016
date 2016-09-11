package rs.crhov.tijanap.main;

/**
 * @author tijana.pavicic
 *
 */

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
//import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

//import org.codehaus.xfire.xmpp.SoapEnvelopePacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rs.crhov.tijanap.util.PropertiesReadConfigMain;

public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
	static Logger logger = LoggerFactory.getLogger(HeaderHandler.class);

	public boolean handleMessage(SOAPMessageContext smc) {

		Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		/*
		 * try {
		 * smc.getMessage().setProperty(SOAPMessage.CHARACTER_SET_ENCODING,
		 * "ISO-8859-5"); } catch (SOAPException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); }
		 */

		if (outboundProperty.booleanValue()) {

			SOAPMessage message = smc.getMessage();

			try {
				SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
				// envelope.setEncodingStyle("ISO-8859-5");
				/*
				 * envelope.setAttribute(SOAPMessage.CHARACTER_SET_ENCODING,
				 * "ISO-8859-5");
				 */
				SOAPHeader header = envelope.addHeader();
				/**
				 * setting up credentials
				 */
				PropertiesReadConfigMain prop = new PropertiesReadConfigMain();
				SOAPElement security = header.addChildElement("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

				SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
				usernameToken.addAttribute(new QName("xmlns:wsu"),
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

				SOAPElement username = usernameToken.addChildElement("Username", "wsse");
				username.addTextNode(prop.getUserAPR());

				SOAPElement password = usernameToken.addChildElement("Password", "wsse");
				password.setAttribute("Type",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
				password.addTextNode(prop.getPassAPR());

				// Print out the outbound SOAP message to System.out
				// message.writeTo(System.out);
				logger.debug(" |DEBUG| message from HeaderHandler.class:" + message);

			} catch (Exception e) {
				logger.error(" |ERROR| from HeaderHandler.class:" + e);

			}

		} else {
			try {

				// This handler does nothing with the response from the Web
				// Service: we just print out the SOAP message.
				/*
				 * SOAPMessage message = smc.getMessage();
				 * message.writeTo(System.out); System.out.println(" ");
				 */
				logger.debug(" |DEBUG| from HeaderHandler.class. ");

			} catch (Exception ex) {
				logger.error(" |ERROR| from HeaderHandler.class: " + ex);
			}
		}

		return outboundProperty;

	}

	public Set<QName> getHeaders() {
		// The code below is added on order to invoke Spring secured WS.
		// Otherwise,
		// http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd
		// won't be recognised
		final QName securityHeader = new QName(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security",
				"wsse");

		final HashSet<QName> headers = new HashSet<QName>();
		headers.add(securityHeader);
		logger.debug(" |DEBUG| from HeaderHandler.class method getHeaders().");
		return headers;
	}

	public boolean handleFault(SOAPMessageContext context) {
		// throw new UnsupportedOperationException("Not supported yet.");
		return true;
	}

	public void close(MessageContext context) {
		// throw new UnsupportedOperationException("Not supported yet.");
	}
}
