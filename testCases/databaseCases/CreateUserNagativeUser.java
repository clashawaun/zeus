package databaseCases;

import static org.junit.Assert.*;

import org.junit.Test;

import coreClasses.User;

import database.Database;

public class CreateUserNagativeUser {

	@Test
	public void test() {
		try
		{
		Database db = new Database();
		
		User user = db.createUser(-1000, "", "", "", "", "");
		assertEquals(true, user==null );
		
		user = db.createUser(1000, "", "", "", "", "");
		assertEquals(true, user==null );
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
