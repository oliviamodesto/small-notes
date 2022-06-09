/** CUstom exception to handle situation in which an event is not found
 * 
 */
package notepaperPlannerManager;

/**
 * @author olivia
 *
 */
class EventNotFoundException extends Exception{
	
	EventNotFoundException(){
		super("The event was not found!\n");
		//TODO: add something
	}
}
