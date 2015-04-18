package databaseCases;

import static org.junit.Assert.*;

import org.junit.Test;

import database.Database;

public class IsValidLogInTrue {


	
	@Test
	public void test() {
		try
		{
		Database db = new Database();
		assertEquals(true, db.isValidLogin("picker", "1234"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
