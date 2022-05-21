/**
 * 
 */
package notesManager;

/**
 * @author olivia
 *
 */
class BasicTitle implements Title {
	public String name;
	
	BasicTitle(){
		this.name = "Untitled";
	}
	
	BasicTitle(String newName){
		this.name = newName;
	}
}
