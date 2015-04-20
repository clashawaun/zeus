import java.text.ParseException;
import java.util.ArrayList;




import coreClasses.User;
import client.GUICommunicatorController;
import database.Database;


public class playground {
	
	
	public static void main(String args[]) throws ParseException, Exception
	{
	
		GUICommunicatorController GCC = new GUICommunicatorController();
		GCC.LoginUser("stocker", "1234");
		GCC.getSectorsIDs();
		System.out.println(GCC.getStockerCurrentBasket());

		
//		Database db = new Database();
//		
//	
//		System.out.println(db.createUser(3, "firstName", "secondName", "email", "phone", "password"));
//		System.out.println(db.isValidLogin("picker", "1234"));
//		
//		ArrayList<Integer> temp = new ArrayList<Integer>() ;
//		temp.add(1);
//		temp.add(2);
//		System.out.println(db.registerOrder(temp , "addressone"));
//		System.out.println(db.getOrder(1));
//		System.out.println(db.createItem(1, "2015-04-01", null));
//		System.out.println(db.createProduct("productname", "description", 0.11, 0.12f, 0.32f, 0.12f,0.25f, 0));
//		System.out.println(db.getOpenOrders());
//		System.out.println(db.getItems(1));
//		System.out.println(db.getProducts());
//		System.out.println(db.getProduct(1));
//		System.out.println(db.getItem(2));
//		System.out.println(db.itemBelonngsTo(2));
//		System.out.println(db.createCubby(1));
//		System.out.println(db.createShelve( 1));
//		System.out.println(db.createSector(1));
//		
//		System.out.println(db.getItems());
//		System.out.print("Deleting item   ");
//		db.deleteItem(1);
//		System.out.println(db.getItems());
//		
//		db.deleteProduct(1);
//		db.deleteOrder(1);
//		System.out.println(db.getPriority(0));
//
//		System.out.println(db.getAllSectors());
//		System.out.println(db.createSector());
//
//		System.out.println(db.getSector(1));
//		System.out.println(db.itemBelongsToCubby(7 ));
//		System.out.println(db.cubbyBelongsToShelf(2));
//		System.out.println(db.shelfBelongsToSector(2));
//		System.out.println(db.getUser("email", "password"));
//		System.out.println(db.getUser(4));
//		
	}
}
