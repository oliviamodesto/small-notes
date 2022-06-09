/**
 * 
 */
package notepaperPasswordManager;

/**
 * @author olivia
 *
 */
public interface PasswordAccountManager {

	/**add new password-account pair
	 * */
	public void enterNewPasswordAccount(String password, String account);
	
	/**remove password-account pair
	 * */
	public void removeNewPasswordAccount(String password, String account);
	
	
}
