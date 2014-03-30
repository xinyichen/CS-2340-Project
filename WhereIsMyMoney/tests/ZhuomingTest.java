import junit.framework.TestCase;

import com.whereismymoney.model.PasswordManager;


public class ZhuomingTest extends TestCase {

/**
 * 
 * @author Zhuoming Li (Ming)
 *
 */
	PasswordManager manager;
	
	
	public void setUp(){
		//register user
		PasswordManager manager = new PasswordManager();
		manager.register( "username",  "first_name",
	             "last_name",  "password123",  "email@gatech.edu");
		
	}
	
	
	/**
	 * login denied with wrong password
	 */
	public void testLoginWithWrongPassword(){
		setUp();
		assertFalse(manager.login("username","wrongpassword"));
	}
	
	
	/**
	 * login accepted with right password
	 */
	public void testLoginWithRightPassword(){
		assertTrue(manager.login("username","pass123"));
	}

}
