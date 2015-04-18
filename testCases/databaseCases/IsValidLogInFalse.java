package databaseCases;

import static org.junit.Assert.*;

import org.junit.Test;

import database.Database;

public class IsValidLogInFalse {

	@Test
	public void test() {
		try
		{
		Database db = new Database();
		assertEquals(false, db.isValidLogin("NotAUser", "NotAPassWord"));
		assertEquals(false, db.isValidLogin("picker", "NotAPassWord"));
		assertEquals(false, db.isValidLogin("NotAUser", "1234"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
