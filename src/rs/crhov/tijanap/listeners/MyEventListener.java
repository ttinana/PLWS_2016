/**
 * 
 */
package rs.crhov.tijanap.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author ttinana
 *
 */
@Component
public class MyEventListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("*****************tinana****************************");
		System.out.println(event.toString());
		System.out.println("*******************tinana***************************");

}
}