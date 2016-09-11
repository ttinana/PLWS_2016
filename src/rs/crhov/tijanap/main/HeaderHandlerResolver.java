package rs.crhov.tijanap.main;

/**
 * @author tijana.pavicic
 *
 */

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class HeaderHandlerResolver implements HandlerResolver {
	static Logger logger = LoggerFactory.getLogger(HeaderHandlerResolver.class);

	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<Handler>();

		HeaderHandler hh = new HeaderHandler();
		handlerChain.add(hh);
		logger.debug("|DEBUG| FROM HeaderHandlerResolver.CLASS. ");
		return handlerChain;
	}
}