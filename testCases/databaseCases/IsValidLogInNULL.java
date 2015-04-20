package databaseCases;

import static org.junit.Assert.*;

import org.junit.Test;

import database.Database;

public class IsValidLogInNULL {

	@Test
	public void test() {
		try
		{
		Database db = new Database();
		assertEquals(false, db.isValidLogin(null, null));
		}catch(Exception e)
		{
			fail("Exception");
		}
	}

}
