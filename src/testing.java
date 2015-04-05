import customExpection.UnableToAssignItemToUserException;
import database.DataBase;


public class testing {

	public static void main(String args[])
	{
		try {
		DataBase db = new DataBase();
		System.out.println("Hello world");
		
			db.assignItemToUser(100, 50);
			
		} catch (UnableToAssignItemToUserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage(100, 50));
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Throwed world");
		}
		System.out.println("Hello world Finished");
	}
	
	public testing() {

		
	}

}
