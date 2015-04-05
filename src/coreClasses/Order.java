package coreClasses;
import java.util.ArrayList;

public class Order 
{
	private final int ID;
	private ArrayList<Integer> productIds;
	private String shippingAddress;
	private String status;
	private float priority;


	public Order(int id, ArrayList<Integer> productIDs, String shippingAddress)
	{
		this.ID = id;
		this.productIds = productIDs;
		this.shippingAddress = shippingAddress;
		this.status = "OPEN";
		this.priority = 0;
	}

	public float getPriority() {
		return priority;
	}

	public void setPriority(float priority) {
		this.priority = priority;
	}

	public boolean hasItem(int itemID){
		
		return true;
	}
	public ArrayList<Integer> getProductIds() {
		return productIds;
	}

	public void setProductIds(ArrayList<Integer> productIds) {
		this.productIds = productIds;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public int getID() {
		return ID;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public boolean addItemId(int itemID, int productID) {
		
		boolean replaced = false;
		
		for(int index = 0; index < productIds.size(); index++)
		{
			if(productIds.get(index)== productID);
			{
				productIds.set(index, itemID);
				replaced = true;
			}
		}
		
		return replaced;
	}
	

}
