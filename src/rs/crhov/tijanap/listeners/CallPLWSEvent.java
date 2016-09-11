/**
 * 
 */
package rs.crhov.tijanap.listeners;

import org.springframework.context.ApplicationEvent;

/**
 * @author ttinana
 *
 */
public class CallPLWSEvent extends ApplicationEvent {

	public CallPLWSEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CallPLWSEvent [source=" + source + "] by T.";
	}
	

}
