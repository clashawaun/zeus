package databaseCases;

import static org.junit.Assert.*;

import org.junit.Test;

import coreClasses.User;
import coreClasses.UserFactory;
import database.Database;

public class GetUserFalse {

	@Test
	public void test() {
		try
		{
		Database db = new Database();
		UserFactory factory = new UserFactory();
		User user = factory.makeUser(1 , 4,"" ,"", "", "", "");
		User user1 = db.getUser(-100);
		
		assertEquals(false, user.equals(user1));
	
		}catch(Exception e)
		{
			fail("Exception");
		}
	}

}
